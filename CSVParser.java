import java.io.*;
import java.util.*;

/**
 * CSV Parser for reading and validating student data from CSV files
 */
public class CSVParser {
    
    // Expected CSV headers
    private static final String[] EXPECTED_HEADERS = {
        "EN_Number", "Name", "Contact", "Email", "Category", "Gender", 
        "PWD_DEF", "EWS", "TFWS", "Orphan", "Minority",
        "SSC_English", "SSC_Maths", "SSC_Science", "SSC_SocialStudies", "SSC_Hindi", "SSC_Marathi",
        "HSC_English", "HSC_Physics", "HSC_Chemistry", "HSC_Maths", "HSC_Biology",
        "MHTCET_Physics", "MHTCET_Chemistry", "MHTCET_Maths",
        "DOB_Day", "DOB_Month", "DOB_Year"
    };
    
    /**
     * Parse CSV file and create Detail objects for each student
     */
    public static List<Detail> parseCSV(File csvFile) throws Exception {
        List<Detail> students = new ArrayList<>();
        BufferedReader br = null;
        
        try {
            br = new BufferedReader(new FileReader(csvFile));
            String line;
            
            // Read and validate header
            String headerLine = br.readLine();
            if (headerLine == null) {
                throw new Exception("CSV file is empty!");
            }
            
            String[] headers = headerLine.split(",");
            validateHeaders(headers);
            
            int lineNumber = 1;
            while ((line = br.readLine()) != null) {
                lineNumber++;
                
                // Skip empty lines
                if (line.trim().isEmpty()) {
                    continue;
                }
                
                try {
                    Detail student = parseStudentLine(line, lineNumber);
                    students.add(student);
                } catch (Exception e) {
                    throw new Exception("Error parsing line " + lineNumber + ": " + e.getMessage());
                }
            }
            
            if (students.isEmpty()) {
                throw new Exception("No valid student data found in CSV!");
            }
            
        } catch (IOException e) {
            throw new Exception("Error reading CSV file: " + e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return students;
    }
    
    /**
     * Parse a single line of CSV data into a Detail object
     */
    private static Detail parseStudentLine(String line, int lineNumber) throws Exception {
        String[] values = line.split(",", -1); // -1 to include empty trailing fields
        
        if (values.length < EXPECTED_HEADERS.length) {
            throw new Exception("Insufficient columns. Expected " + EXPECTED_HEADERS.length + ", found " + values.length);
        }
        
        Detail student = new Detail();
        
        try {
            // Personal Details (columns 0-10)
            student.setEN(Long.parseLong(values[0].trim()));
            student.setName(values[1].trim());
            student.setPh(Long.parseLong(values[2].trim()));
            student.setEmail(values[3].trim());
            student.setCategory(values[4].trim());
            student.setGender(values[5].trim());
            student.setPwdDef(values[6].trim());
            student.setEws(values[7].trim());
            student.setTfws(values[8].trim());
            student.setOrphan(values[9].trim());
            student.setMinority(values[10].trim());
            
            // SSC Details (columns 11-16)
            SSCDetails ssc = new SSCDetails();
            ssc.setEng(Float.parseFloat(values[11].trim()));
            ssc.setMaths(Float.parseFloat(values[12].trim()));
            ssc.setScience(Float.parseFloat(values[13].trim()));
            ssc.setSs(Float.parseFloat(values[14].trim()));
            ssc.setHindi(Float.parseFloat(values[15].trim()));
            ssc.setMarathi(Float.parseFloat(values[16].trim()));
            student.setSsc(ssc);
            
            // HSC Details (columns 17-21)
            HSCDetails hsc = new HSCDetails();
            hsc.setEng(Float.parseFloat(values[17].trim()));
            hsc.setPhysics(Float.parseFloat(values[18].trim()));
            hsc.setChemistry(Float.parseFloat(values[19].trim()));
            hsc.setMaths(Float.parseFloat(values[20].trim()));
            hsc.setVocational(Float.parseFloat(values[21].trim()));
            student.setHsc(hsc);
            
            // MHT-CET Details (columns 22-24)
            MHTCETDetails mhtcet = new MHTCETDetails();
            mhtcet.setPhysics(Float.parseFloat(values[22].trim()));
            mhtcet.setChemistry(Float.parseFloat(values[23].trim()));
            mhtcet.setMaths(Float.parseFloat(values[24].trim()));
            student.setMhtcet(mhtcet);
            
            // DOB Details (columns 25-27)
            DOB dob = new DOB();
            dob.setDay(Integer.parseInt(values[25].trim()));
            dob.setMonth(Integer.parseInt(values[26].trim()));
            dob.setYear(Integer.parseInt(values[27].trim()));
            student.setDob(dob);
            
            // Initialize percentile object
            student.setPer(new MHTCETPercentileDetails());
            
        } catch (NumberFormatException e) {
            throw new Exception("Invalid number format in one of the fields: " + e.getMessage());
        } catch (Exception e) {
            throw new Exception("Error parsing student data: " + e.getMessage());
        }
        
        return student;
    }
    
    /**
     * Validate CSV headers match expected format
     */
    private static void validateHeaders(String[] headers) throws Exception {
        if (headers.length < EXPECTED_HEADERS.length) {
            throw new Exception("Invalid CSV format. Expected " + EXPECTED_HEADERS.length + " columns, found " + headers.length);
        }
        
        // Check if headers match (case-insensitive)
        for (int i = 0; i < EXPECTED_HEADERS.length; i++) {
            if (!headers[i].trim().equalsIgnoreCase(EXPECTED_HEADERS[i])) {
                throw new Exception("Invalid header at column " + (i + 1) + ". Expected '" + 
                    EXPECTED_HEADERS[i] + "', found '" + headers[i].trim() + "'");
            }
        }
    }
    
    /**
     * Validate CSV structure without fully parsing
     */
    public static List<String> validateCSVStructure(File csvFile) throws Exception {
        List<String> warnings = new ArrayList<>();
        BufferedReader br = null;
        
        try {
            br = new BufferedReader(new FileReader(csvFile));
            String line;
            
            // Check header
            String headerLine = br.readLine();
            if (headerLine == null) {
                throw new Exception("CSV file is empty!");
            }
            
            String[] headers = headerLine.split(",");
            try {
                validateHeaders(headers);
            } catch (Exception e) {
                throw e;
            }
            
            // Check at least one data row exists
            int lineCount = 0;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    lineCount++;
                    
                    // Quick validation of first row
                    if (lineCount == 1) {
                        String[] values = line.split(",", -1);
                        if (values.length < EXPECTED_HEADERS.length) {
                            warnings.add("First data row has insufficient columns (" + values.length + "/" + EXPECTED_HEADERS.length + ")");
                        }
                    }
                }
            }
            
            if (lineCount == 0) {
                warnings.add("CSV file contains no data rows");
            }
            
        } catch (IOException e) {
            throw new Exception("Error reading CSV file: " + e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return warnings;
    }
    
    /**
     * Create a CSV template file for users
     */
    public static void createTemplate(File templateFile) throws IOException {
        PrintWriter writer = null;
        
        try {
            writer = new PrintWriter(new FileWriter(templateFile));
            
            // Write headers
            writer.println(String.join(",", EXPECTED_HEADERS));
            
            // Write sample data row
            writer.println("12345678,Sharma_Raj_Kumar,9876543210,raj.sharma@email.com,Open,Male,No,No,No,No,None," +
                "85.5,90.0,88.5,82.0,78.5,80.0," +
                "75.0,80.5,78.0,85.5,72.0," +
                "45.5,48.0,49.5," +
                "15,8,2005");
            
            writer.println("23456789,Patil_Priya_Ramesh,9876543211,priya.patil@email.com,OBC,Female,No,No,Yes,No,None," +
                "92.0,88.5,90.0,85.5,80.0,82.5," +
                "82.0,85.0,83.5,88.0,79.5," +
                "47.0,49.5,48.5," +
                "22,3,2006");
            
            writer.println("34567890,Khan_Arif_Mohammed,9876543212,arif.khan@email.com,SC,Male,No,Yes,No,No,Religious Minority," +
                "80.0,85.5,83.0,78.5,75.0,77.0," +
                "78.5,82.0,80.0,84.5,76.0," +
                "44.5,47.0,48.0," +
                "10,12,2005");
            
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
    
    /**
     * Export results to CSV file
     */
    public static void exportResultsToCSV(List<Detail> students, File outputFile) throws IOException {
        PrintWriter writer = null;
        
        try {
            writer = new PrintWriter(new FileWriter(outputFile));
            
            // Write headers
            writer.println("Rank,EN_Number,Name,Category,Gender,SSC_Percentage,HSC_Percentage," +
                "HSC_PCM_Percentage,MHTCET_Total,MHTCET_Percentile,Physics_Percentile," +
                "Chemistry_Percentile,Maths_Percentile,DOB");
            
            // Write student data
            for (Detail student : students) {
                writer.printf("%d,EN%d,%s,%s,%s,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f,%02d/%02d/%d%n",
                    student.getRank(),
                    student.getEN(),
                    student.getName(),
                    student.getCategory(),
                    student.getGender(),
                    student.getSsc_per(),
                    student.getHsc_per(),
                    student.getHsc_pcm_per(),
                    student.getMhtcet().getTotal(),
                    student.getPer().getTotal(),
                    student.getPer().getPhysics(),
                    student.getPer().getChemistry(),
                    student.getPer().getMaths(),
                    student.getDob().getDay(),
                    student.getDob().getMonth(),
                    student.getDob().getYear()
                );
            }
            
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
