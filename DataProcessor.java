import java.util.*;

/**
 * Data Processor for validating, calculating, and ranking student data
 */
public class DataProcessor {
    
    /**
     * Validate all student data for correctness
     */
    public static void validateStudentData(List<Detail> students) throws Exception {
        for (int i = 0; i < students.size(); i++) {
            Detail student = students.get(i);
            
            // Validate EN Number (8 digits)
            if (MHTCETUtility.countDigit(student.getEN()) != 8) {
                throw new Exception("Student " + (i + 1) + ": Invalid EN Number. Must be 8 digits.");
            }
            
            // Validate Contact Number (10 digits)
            if (MHTCETUtility.countDigit(student.getPh()) != 10) {
                throw new Exception("Student " + (i + 1) + ": Invalid Contact Number. Must be 10 digits.");
            }
            
            // Validate SSC Marks (0-100)
            validateMarks(student.getSsc().getEng(), "SSC English", i + 1);
            validateMarks(student.getSsc().getMaths(), "SSC Maths", i + 1);
            validateMarks(student.getSsc().getScience(), "SSC Science", i + 1);
            validateMarks(student.getSsc().getSs(), "SSC Social Studies", i + 1);
            validateMarks(student.getSsc().getHindi(), "SSC Hindi", i + 1);
            validateMarks(student.getSsc().getMarathi(), "SSC Marathi", i + 1);
            
            // Validate HSC Marks (0-100)
            validateMarks(student.getHsc().getEng(), "HSC English", i + 1);
            validateMarks(student.getHsc().getPhysics(), "HSC Physics", i + 1);
            validateMarks(student.getHsc().getChemistry(), "HSC Chemistry", i + 1);
            validateMarks(student.getHsc().getMaths(), "HSC Maths", i + 1);
            validateMarks(student.getHsc().getVocational(), "HSC Biology", i + 1);
            
            // Validate MHT-CET Marks (0-50)
            validateMHTCETMarks(student.getMhtcet().getPhysics(), "MHT-CET Physics", i + 1);
            validateMHTCETMarks(student.getMhtcet().getChemistry(), "MHT-CET Chemistry", i + 1);
            validateMHTCETMarks(student.getMhtcet().getMaths(), "MHT-CET Maths", i + 1);
            
            // Validate Date of Birth
            validateDOB(student.getDob(), i + 1);
        }
    }
    
    private static void validateMarks(float marks, String subject, int studentNum) throws Exception {
        if (marks < 0 || marks > 100) {
            throw new Exception("Student " + studentNum + ": Invalid " + subject + " marks (" + marks + "). Must be between 0 and 100.");
        }
    }
    
    private static void validateMHTCETMarks(float marks, String subject, int studentNum) throws Exception {
        if (marks < 0 || marks > 50) {
            throw new Exception("Student " + studentNum + ": Invalid " + subject + " marks (" + marks + "). Must be between 0 and 50.");
        }
    }
    
    private static void validateDOB(DOB dob, int studentNum) throws Exception {
        // Validate day
        if (dob.getDay() < 1 || dob.getDay() > 31) {
            throw new Exception("Student " + studentNum + ": Invalid day in DOB (" + dob.getDay() + ")");
        }
        
        // Validate month
        if (dob.getMonth() < 1 || dob.getMonth() > 12) {
            throw new Exception("Student " + studentNum + ": Invalid month in DOB (" + dob.getMonth() + ")");
        }
        
        // Validate year (reasonable range)
        if (dob.getYear() < 1990 || dob.getYear() > 2015) {
            throw new Exception("Student " + studentNum + ": Invalid year in DOB (" + dob.getYear() + ")");
        }
        
        // Validate day according to month
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        // Check for leap year
        boolean isLeapYear = (dob.getYear() % 4 == 0 && dob.getYear() % 100 != 0) || (dob.getYear() % 400 == 0);
        if (isLeapYear && dob.getMonth() == 2) {
            daysInMonth[1] = 29;
        }
        
        if (dob.getDay() > daysInMonth[dob.getMonth() - 1]) {
            throw new Exception("Student " + studentNum + ": Invalid day for month " + dob.getMonth());
        }
    }
    
    /**
     * Calculate percentages and totals for all students
     */
    public static void calculatePercentagesAndTotals(List<Detail> students) {
        for (Detail student : students) {
            // Calculate SSC Total (Best of 5)
            float[] sscMarks = {
                student.getSsc().getEng(),
                student.getSsc().getMaths(),
                student.getSsc().getScience(),
                student.getSsc().getSs(),
                student.getSsc().getHindi(),
                student.getSsc().getMarathi()
            };
            
            // Find minimum mark to exclude
            float minMark = sscMarks[0];
            for (float mark : sscMarks) {
                if (mark < minMark) {
                    minMark = mark;
                }
            }
            
            // Calculate total (sum all marks except minimum)
            float sscTotal = 0;
            boolean excludedMin = false;
            for (float mark : sscMarks) {
                if (mark == minMark && !excludedMin) {
                    excludedMin = true;
                    continue;
                }
                sscTotal += mark;
            }
            
            student.getSsc().setTotal((int) sscTotal);
            student.setSsc_per(MHTCETUtility.calculatePercentage(sscTotal, 500));
            
            // Calculate HSC Total and Percentage
            float hscTotal = student.getHsc().getEng() + 
                           student.getHsc().getPhysics() + 
                           student.getHsc().getChemistry() + 
                           student.getHsc().getMaths() + 
                           student.getHsc().getVocational();
            
            student.getHsc().setTotal((int) hscTotal);
            student.setHsc_per(MHTCETUtility.calculatePercentage(hscTotal, 500));
            
            // Calculate HSC PCM (Physics, Chemistry, Maths)
            float hscPCM = student.getHsc().getPhysics() + 
                          student.getHsc().getChemistry() + 
                          student.getHsc().getMaths();
            
            student.setHsc_pcm_per(MHTCETUtility.calculatePercentage(hscPCM, 300));
            
            // Calculate MHT-CET Total
            float mhtcetTotal = student.getMhtcet().getPhysics() + 
                               student.getMhtcet().getChemistry() + 
                               student.getMhtcet().getMaths();
            
            student.getMhtcet().setTotal(mhtcetTotal);
        }
    }
    
    /**
     * Calculate percentiles for all subjects
     */
    public static void calculatePercentiles(List<Detail> students) {
        Detail[] studentArray = students.toArray(new Detail[0]);
        
        // Calculate percentiles for each subject
        MHTCETUtility.sortAndAssignTotalPercentile(studentArray);
        MHTCETUtility.sortAndAssignMathsPercentile(studentArray);
        MHTCETUtility.sortAndAssignPhysicsPercentile(studentArray);
        MHTCETUtility.sortAndAssignChemistryPercentile(studentArray);
        
        // Update the list with the calculated percentiles
        students.clear();
        students.addAll(Arrays.asList(studentArray));
    }
    
    /**
     * Generate final rankings based on multiple criteria
     */
    public static void generateRankings(List<Detail> students) {
        Detail[] studentArray = students.toArray(new Detail[0]);
        int n = studentArray.length;
        
        // Sort students according to ranking criteria
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (shouldSwap(studentArray[j], studentArray[j + 1])) {
                    Detail temp = studentArray[j];
                    studentArray[j] = studentArray[j + 1];
                    studentArray[j + 1] = temp;
                }
            }
        }
        
        // Assign ranks
        for (int i = 0; i < n; i++) {
            studentArray[i].setRank(i + 1);
        }
        
        // Update the list
        students.clear();
        students.addAll(Arrays.asList(studentArray));
    }
    
    /**
     * Determine if two students should be swapped based on ranking criteria
     * Ranking criteria hierarchy:
     * 1. Total MHT-CET Percentile (higher is better)
     * 2. Maths Percentile (higher is better)
     * 3. Physics Percentile (higher is better)
     * 4. Chemistry Percentile (higher is better)
     * 5. HSC PCM Percentage (higher is better)
     * 6. HSC Percentage (higher is better)
     * 7. SSC Percentage (higher is better)
     * 8. Date of Birth (older is better)
     */
    private static boolean shouldSwap(Detail s1, Detail s2) {
        // Compare Total Percentile
        if (s1.getPer().getTotal() != s2.getPer().getTotal()) {
            return s1.getPer().getTotal() < s2.getPer().getTotal();
        }
        
        // Compare Maths Percentile
        if (s1.getPer().getMaths() != s2.getPer().getMaths()) {
            return s1.getPer().getMaths() < s2.getPer().getMaths();
        }
        
        // Compare Physics Percentile
        if (s1.getPer().getPhysics() != s2.getPer().getPhysics()) {
            return s1.getPer().getPhysics() < s2.getPer().getPhysics();
        }
        
        // Compare Chemistry Percentile
        if (s1.getPer().getChemistry() != s2.getPer().getChemistry()) {
            return s1.getPer().getChemistry() < s2.getPer().getChemistry();
        }
        
        // Compare HSC PCM Percentage
        if (s1.getHsc_pcm_per() != s2.getHsc_pcm_per()) {
            return s1.getHsc_pcm_per() < s2.getHsc_pcm_per();
        }
        
        // Compare HSC Percentage
        if (s1.getHsc_per() != s2.getHsc_per()) {
            return s1.getHsc_per() < s2.getHsc_per();
        }
        
        // Compare SSC Percentage
        if (s1.getSsc_per() != s2.getSsc_per()) {
            return s1.getSsc_per() < s2.getSsc_per();
        }
        
        // Compare Date of Birth (older student ranks higher)
        return compareDOB(s1.getDob(), s2.getDob()) > 0;
    }
    
    /**
     * Compare two dates of birth
     * Returns: negative if dob1 < dob2 (dob1 is younger)
     *          positive if dob1 > dob2 (dob1 is older)
     *          zero if equal
     */
    private static int compareDOB(DOB dob1, DOB dob2) {
        if (dob1.getYear() != dob2.getYear()) {
            return dob1.getYear() - dob2.getYear();
        }
        if (dob1.getMonth() != dob2.getMonth()) {
            return dob1.getMonth() - dob2.getMonth();
        }
        return dob1.getDay() - dob2.getDay();
    }
}
