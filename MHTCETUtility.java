public class MHTCETUtility {
    
    // For calculating percentage
    public static float calculatePercentage(float a, float b) {
        float per = (a / b) * 100;
        return per;
    }
    
    // For counting digits
    public static int countDigit(long EN) {
        int count = 0;
        while (EN > 0) {
            EN /= 10;
            count++;
        }
        return count;
    }
    
    // To sort and assign Total Percentile
    public static void sortAndAssignTotalPercentile(Detail[] stud) {
        int n = stud.length;

        // Sorting according to total marks
        Detail tempT;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (stud[j].getMhtcet().getTotal() < stud[j + 1].getMhtcet().getTotal()) {
                    tempT = stud[j];
                    stud[j] = stud[j + 1];
                    stud[j + 1] = tempT;
                }
            }
        }

        // Assigning Percentile for Total
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && stud[i].getMhtcet().getTotal() == stud[i + 1].getMhtcet().getTotal()) {
                stud[i].getPer().setTotal(((double) (n - i) / (double) n) * 100);
                stud[i + 1].getPer().setTotal(((double) (n - i) / (double) n) * 100);
                i++;
            } else {
                stud[i].getPer().setTotal(((double) (n - i) / (double) n) * 100);
            }
        }
    }
    
    // To sort and assign Maths Percentile
    public static void sortAndAssignMathsPercentile(Detail[] stud) {
        int n = stud.length;

        // Sorting according to maths marks
        Detail tempM;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (stud[j].getMhtcet().getMaths() < stud[j + 1].getMhtcet().getMaths()) {
                    tempM = stud[j];
                    stud[j] = stud[j + 1];
                    stud[j + 1] = tempM;
                }
            }
        }

        // Assigning Percentile for maths
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && stud[i].getMhtcet().getMaths() == stud[i + 1].getMhtcet().getMaths()) {
                stud[i].getPer().setMaths(((double) (n - i) / (double) n) * 100);
                stud[i + 1].getPer().setMaths(((double) (n - i) / (double) n) * 100);
                i++;
            } else {
                stud[i].getPer().setMaths(((double) (n - i) / (double) n) * 100);
            }
        }
    }
    
    // To sort and assign Physics Percentile
    public static void sortAndAssignPhysicsPercentile(Detail[] stud) {
        int n = stud.length;

        // Sorting according to Physics marks
        Detail tempP;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (stud[j].getMhtcet().getPhysics() < stud[j + 1].getMhtcet().getPhysics()) {
                    tempP = stud[j];
                    stud[j] = stud[j + 1];
                    stud[j + 1] = tempP;
                }
            }
        }

        // Assigning Percentile for Physics
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && stud[i].getMhtcet().getPhysics() == stud[i + 1].getMhtcet().getPhysics()) {
                stud[i].getPer().setPhysics(((double) (n - i) / (double) n) * 100);
                stud[i + 1].getPer().setPhysics(((double) (n - i) / (double) n) * 100);
                i++;
            } else {
                stud[i].getPer().setPhysics(((double) (n - i) / (double) n) * 100);
            }
        }
    }
    
    // To sort and assign Chemistry Percentile
    public static void sortAndAssignChemistryPercentile(Detail[] stud) {
        int n = stud.length;

        // Sorting according to Chemistry marks
        Detail tempC;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (stud[j].getMhtcet().getChemistry() < stud[j + 1].getMhtcet().getChemistry()) {
                    tempC = stud[j];
                    stud[j] = stud[j + 1];
                    stud[j + 1] = tempC;
                }
            }
        }

        // Assigning Percentile for Chemistry
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && stud[i].getMhtcet().getChemistry() == stud[i + 1].getMhtcet().getChemistry()) {
                stud[i].getPer().setChemistry(((double) (n - i) / (double) n) * 100);
                stud[i + 1].getPer().setChemistry(((double) (n - i) / (double) n) * 100);
                i++;
            } else {
                stud[i].getPer().setChemistry(((double) (n - i) / (double) n) * 100);
            }
        }
    }
    
    public static void sortByMathsPercentile(int a, int b, Detail[] stud) {
        // Sorting according to Maths Percentile
        Detail tempPerM;
        if (stud[a].getPer().getMaths() < stud[b].getPer().getMaths()) {
            tempPerM = stud[a];
            stud[a] = stud[b];
            stud[b] = tempPerM;
        }
    }

    public static void sortByPhysicsPercentile(int a, int b, Detail[] stud) {
        // Sorting according to Physics Percentile
        Detail tempPerP;
        if (stud[a].getPer().getPhysics() < stud[b].getPer().getPhysics()) {
            tempPerP = stud[a];
            stud[a] = stud[b];
            stud[b] = tempPerP;
        }
    }

    public static void sortByChemistryPercentile(int a, int b, Detail[] stud) {
        // Sorting according to Chemistry Percentile
        Detail tempPerC;
        if (stud[a].getPer().getChemistry() < stud[b].getPer().getChemistry()) {
            tempPerC = stud[a];
            stud[a] = stud[b];
            stud[b] = tempPerC;
        }
    }

    // To sort according to HSC PCM
    public static void sortByPCM(int a, int b, Detail[] stud) {
        // Sorting according to HSC PCM marks
        Detail tempPCM;
        if (stud[a].getHsc_pcm() < stud[b].getHsc_pcm()) {
            tempPCM = stud[a];
            stud[a] = stud[b];
            stud[b] = tempPCM;
        }
    }

    // To sort according to HSC Maths
    public static void sortHscMaths(int a, int b, Detail[] stud) {
        // Sorting according to HSC Maths marks
        Detail tempHscMaths;
        if (stud[a].getHsc().getMaths() < stud[b].getHsc().getMaths()) {
            tempHscMaths = stud[a];
            stud[a] = stud[b];
            stud[b] = tempHscMaths;
        }
    }

    // To sort according to HSC Physics
    public static void sortHscPhysics(int a, int b, Detail[] stud) {
        // Sorting according to HSC Physics marks
        Detail tempHscPhysics;
        if (stud[a].getHsc().getPhysics() < stud[b].getHsc().getPhysics()) {
            tempHscPhysics = stud[a];
            stud[a] = stud[b];
            stud[b] = tempHscPhysics;
        }
    }

    // To sort according to HSC Total
    public static void sortHscTotal(int a, int b, Detail[] stud) {
        // Sorting according to HSC Total marks
        Detail tempHscTotal;
        if (stud[a].getHsc().getTotal() < stud[b].getHsc().getTotal()) {
            tempHscTotal = stud[a];
            stud[a] = stud[b];
            stud[b] = tempHscTotal;
        }
    }

    // To sort according to SSC Total
    public static void sortSscTotal(int a, int b, Detail[] stud) {
        // Sorting according to SSC Total marks
        Detail tempSscTotal;
        if (stud[a].getSsc().getTotal() < stud[b].getSsc().getTotal()) {
            tempSscTotal = stud[a];
            stud[a] = stud[b];
            stud[b] = tempSscTotal;
        }
    }

    // To sort according to SSC Maths Marks
    public static void sortSscMaths(int a, int b, Detail[] stud) {
        // Sorting according to SSC Maths marks
        Detail tempSscMaths;
        if (stud[a].getSsc().getMaths() < stud[b].getSsc().getMaths()) {
            tempSscMaths = stud[a];
            stud[a] = stud[b];
            stud[b] = tempSscMaths;
        }
    }

    // To sort according to SSC Science Marks
    public static void sortSscScience(int a, int b, Detail[] stud) {
        // Sorting according to SSC Science marks
        Detail tempSscScience;
        if (stud[a].getSsc().getScience() < stud[b].getSsc().getScience()) {
            tempSscScience = stud[a];
            stud[a] = stud[b];
            stud[b] = tempSscScience;
        }
    }

    // To sort according to SSC English Marks
    public static void sortSscEnglish(int a, int b, Detail[] stud) {
        // Sorting according to SSC English marks
        Detail tempSscEnglish;
        if (stud[a].getSsc().getEng() < stud[b].getSsc().getEng()) {
            tempSscEnglish = stud[a];
            stud[a] = stud[b];
            stud[b] = tempSscEnglish;
        }
    }

    // To sort according to Year
    public static void sortYear(int a, int b, Detail[] stud) {
        // Sorting according to year of birth
        Detail tempDobYear;
        if (stud[a].getDob().getYear() < stud[b].getDob().getYear()) {
            tempDobYear = stud[a];
            stud[a] = stud[b];
            stud[b] = tempDobYear;
        }
    }

    // To sort according to Month
    public static void sortMonth(int a, int b, Detail[] stud) {
        // Sorting according to month of birth
        Detail tempDobMonth;
        if (stud[a].getDob().getMonth() < stud[b].getDob().getMonth()) {
            tempDobMonth = stud[a];
            stud[a] = stud[b];
            stud[b] = tempDobMonth;
        }
    }

    // To sort according to Day
    public static void sortDay(int a, int b, Detail[] stud) {
        // Sorting according to day of birth
        Detail tempDobDay;
        if (stud[a].getDob().getDay() < stud[b].getDob().getDay()) {
            tempDobDay = stud[a];
            stud[a] = stud[b];
            stud[b] = tempDobDay;
        }
    }
}
