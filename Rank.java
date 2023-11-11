import java.util.*;

public class Rank {

//for calculating percentage
public static float calculatePercentage(float a, float b) {
    float per = (a / b) * 100;
    return per;
}

//for counting
public static int countDigit(long EN) {
    int count = 0;
    while (EN > 0) {
        EN /= 10;
        count++;
    }
    return count;
}


//to store ssc details
public class SSCDetails {
    private float eng;
    private float maths;
    private float science;
    private float ss;
    private float hindi;
    private float marathi;
    private float total;
    public float getEng() {
        return eng;
    }
    public void setEng(float eng) {
        this.eng = eng;
    }
    public float getMaths() {
        return maths;
    }
    public void setMaths(float maths) {
        this.maths = maths;
    }
    public float getScience() {
        return science;
    }
    public void setScience(float science) {
        this.science = science;
    }
    public float getSs() {
        return ss;
    }
    public void setSs(float ss) {
        this.ss = ss;
    }
    public float getHindi() {
        return hindi;
    }
    public void setHindi(float hindi) {
        this.hindi = hindi;
    }
    public float getMarathi() {
        return marathi;
    }
    public void setMarathi(float marathi) {
        this.marathi = marathi;
    }
    public float getTotal() {
        return total;
    }
    public void setTotal(float total) {
        this.total = total;
    }
}


//to store hsc details
public class HSCDetails {
    private float eng;
    private float physics;
    private float chemistry;
    private float maths;
    private float vocational;
    private float total;
    public float getEng() {
        return eng;
    }
    public void setEng(float eng) {
        this.eng = eng;
    }
    public float getPhysics() {
        return physics;
    }
    public void setPhysics(float physics) {
        this.physics = physics;
    }
    public float getChemistry() {
        return chemistry;
    }
    public void setChemistry(float chemistry) {
        this.chemistry = chemistry;
    }
    public float getMaths() {
        return maths;
    }
    public void setMaths(float maths) {
        this.maths = maths;
    }
    public float getVocational() {
        return vocational;
    }
    public void setVocational(float vocational) {
        this.vocational = vocational;
    }
    public float getTotal() {
        return total;
    }
    public void setTotal(float total) {
        this.total = total;
    }
}


//to store mhtcet details
public class MHTCETDetails {
    private float physics;
    private float chemistry;
    private float maths;
    private float total;
    public float getPhysics() {
        return physics;
    }
    public void setPhysics(float physics) {
        this.physics = physics;
    }
    public float getChemistry() {
        return chemistry;
    }
    public void setChemistry(float chemistry) {
        this.chemistry = chemistry;
    }
    public float getMaths() {
        return maths;
    }
    public void setMaths(float maths) {
        this.maths = maths;
    }
    public float getTotal() {
        return total;
    }
    public void setTotal(float total) {
        this.total = total;
    }
}


//to store DOB
public class DOB {
    private int day;
    private int month;
    private int year;
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
}


//to store percentile
public class MHTCETPercentileDetails {
    private double physics;
    private double chemistry;
    private double maths;
    private double total;
    public double getPhysics() {
        return physics;
    }
    public void setPhysics(double physics) {
        this.physics = physics;
    }
    public double getChemistry() {
        return chemistry;
    }
    public void setChemistry(double chemistry) {
        this.chemistry = chemistry;
    }
    public double getMaths() {
        return maths;
    }
    public void setMaths(double maths) {
        this.maths = maths;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
}


//to store details of student
public class Detail {
    private long EN;
    private long ph;
    private String name;
    private String email;
    private String category;
    private String gender;
    private String pwd_def;
    private String ews;
    private String tfws;
    private String orphan;
    private String minority;
    private SSCDetails ssc;
    private float ssc_per;
    private HSCDetails hsc;
    private float hsc_per;
    private float hsc_pcm;
    private MHTCETDetails mhtcet;
    private DOB dob;
    private MHTCETPercentileDetails per;
    private int no; // Test purpose
    public long getEN() {
        return EN;
    }
    public void setEN(long eN) {
        EN = eN;
    }
    public long getPh() {
        return ph;
    }
    public void setPh(long ph) {
        this.ph = ph;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getPwdDef() {
        return pwd_def;
    }
    public void setPwdDef(String pwd_def) {
        this.pwd_def = pwd_def;
    }
    public String getEws() {
        return ews;
    }
    public void setEws(String ews) {
        this.ews = ews;
    }
    public String getTfws() {
        return tfws;
    }
    public void setTfws(String tfws) {
        this.tfws = tfws;
    }
    public String getOrphan() {
        return orphan;
    }
    public void setOrphan(String orphan) {
        this.orphan = orphan;
    }
    public String getMinority() {
        return minority;
    }
    public void setMinority(String minority) {
        this.minority = minority;
    }
    public SSCDetails getSsc() {
        return ssc;
    }
    public void setSsc(SSCDetails ssc) {
        this.ssc = ssc;
    }
    public float getSsc_per() {
        return ssc_per;
    }
    public void setSsc_per(float ssc_per) {
        this.ssc_per = ssc_per;
    }
    public HSCDetails getHsc() {
        return hsc;
    }
    public void setHsc(HSCDetails hsc) {
        this.hsc = hsc;
    }
    public float getHsc_per() {
        return hsc_per;
    }
    public void setHsc_per(float hsc_per) {
        this.hsc_per = hsc_per;
    }
    public float getHsc_pcm() {
        return hsc_pcm;
    }
    public void setHsc_pcm(float hsc_pcm) {
        this.hsc_pcm = hsc_pcm;
    }
    public MHTCETDetails getMhtcet() {
        return mhtcet;
    }
    public void setMhtcet(MHTCETDetails mhtcet) {
        this.mhtcet = mhtcet;
    }
    public DOB getDob() {
        return dob;
    }
    public void setDob(DOB dob) {
        this.dob = dob;
    }
    public MHTCETPercentileDetails getPer() {
        return per;
    }
    public void setPer(MHTCETPercentileDetails per) {
        this.per = per;
    }
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getPwd_def() {
        return pwd_def;
    }
    public void setPwd_def(String pwd_def) {
        this.pwd_def = pwd_def;
    }
}


//to sort and assign Total Percentile
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


//to sort and assign Maths Percentile
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


//to sort and assign Physics Percentile
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


//to sort and assign Chemistry Percentile
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


//to sort according to HSC PCM
public static void sortByPCM(int a, int b, Detail[] stud) {
    // Sorting according to HSC PCM marks
    Detail tempPCM;
    if (stud[a].getHsc_pcm() < stud[b].getHsc_pcm()) {
        tempPCM = stud[a];
        stud[a] = stud[b];
        stud[b] = tempPCM;
    }
}


//to sort according to HSC Maths
public static void sortHscMaths(int a, int b, Detail[] stud) {
    // Sorting according to HSC Maths marks
    Detail tempHscMaths;
    if (stud[a].getHsc().getMaths() < stud[b].getHsc().getMaths()) {
        tempHscMaths = stud[a];
        stud[a] = stud[b];
        stud[b] = tempHscMaths;
    }
}


//to sort according to HSC Physics
public static void sortHscPhysics(int a, int b, Detail[] stud) {
    // Sorting according to HSC Physics marks
    Detail tempHscPhysics;
    if (stud[a].getHsc().getPhysics() < stud[b].getHsc().getPhysics()) {
        tempHscPhysics = stud[a];
        stud[a] = stud[b];
        stud[b] = tempHscPhysics;
    }
}


//to sort according to HSC Total
public static void sortHscTotal(int a, int b, Detail[] stud) {
    // Sorting according to HSC Total marks
    Detail tempHscTotal;
    if (stud[a].getHsc().getTotal() < stud[b].getHsc().getTotal()) {
        tempHscTotal = stud[a];
        stud[a] = stud[b];
        stud[b] = tempHscTotal;
    }
}


//to sort according to SSC Total
public static void sortSscTotal(int a, int b, Detail[] stud) {
    // Sorting according to SSC Total marks
    Detail tempSscTotal;
    if (stud[a].getSsc().getTotal() < stud[b].getSsc().getTotal()) {
        tempSscTotal = stud[a];
        stud[a] = stud[b];
        stud[b] = tempSscTotal;
    }
}


//to sort according to SSC Maths Marks
public static void sortSscMaths(int a, int b, Detail[] stud) {
    // Sorting according to SSC Maths marks
    Detail tempSscMaths;
    if (stud[a].getSsc().getMaths() < stud[b].getSsc().getMaths()) {
        tempSscMaths = stud[a];
        stud[a] = stud[b];
        stud[b] = tempSscMaths;
    }
}


//to sort according to SSC Science Marks
public static void sortSscScience(int a, int b, Detail[] stud) {
    // Sorting according to SSC Science marks
    Detail tempSscScience;
    if (stud[a].getSsc().getScience() < stud[b].getSsc().getScience()) {
        tempSscScience = stud[a];
        stud[a] = stud[b];
        stud[b] = tempSscScience;
    }
}


//to sort according to SSC English Marks
public static void sortSscEnglish(int a, int b, Detail[] stud) {
    // Sorting according to SSC English marks
    Detail tempSscEnglish;
    if (stud[a].getSsc().getEng() < stud[b].getSsc().getEng()) {
        tempSscEnglish = stud[a];
        stud[a] = stud[b];
        stud[b] = tempSscEnglish;
    }
}


//to sort according to Year
public static void sortYear(int a, int b, Detail[] stud) {
    // Sorting according to year of birth
    Detail tempDobYear;
    if (stud[a].getDob().getYear() < stud[b].getDob().getYear()) {
        tempDobYear = stud[a];
        stud[a] = stud[b];
        stud[b] = tempDobYear;
    }
}


//to sort according to Month
public static void sortMonth(int a, int b, Detail[] stud) {
    // Sorting according to month of birth
    Detail tempDobMonth;
    if (stud[a].getDob().getMonth() < stud[b].getDob().getMonth()) {
        tempDobMonth = stud[a];
        stud[a] = stud[b];
        stud[b] = tempDobMonth;
    }
}


//to sort according to Day
public static void sortDay(int a, int b, Detail[] stud) {
    // Sorting according to day of birth
    Detail tempDobDay;
    if (stud[a].getDob().getDay() < stud[b].getDob().getDay()) {
        tempDobDay = stud[a];
        stud[a] = stud[b];
        stud[b] = tempDobDay;
    }
}

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    Rank rank = new Rank();
    System.out.println("\n---------------- WELCOME TO MHT-CET JAVA PROGRAM ----------------");
    System.out.print("\nEnter the Number of Students: ");
    int n = scanner.nextInt();
    Detail[] s = new Detail[n];
    float[] ssc_arr = new float[6];
    float min; 


    System.out.println("\nEnter the Details of " + n + " Student(s): ");

    for(int i=0; i<n; i++){
        int ssctotal=0, c=0;
        s[i]= rank.new Detail();
        s[i].ssc = rank.new SSCDetails(); // Initialize the SSCDetails object for the student
        s[i].hsc = rank.new HSCDetails(); // Initialize the HSCDetails object for the student
        s[i].mhtcet = rank.new MHTCETDetails(); // Initialize the MHT-CET object for the student
        s[i].dob = rank.new DOB(); // Initialize the MHT-CET object for the student
        s[i].per = rank.new MHTCETPercentileDetails(); // Initialize the MHTCETPercentileDetails object for the student

        while(true){
        System.out.print("\n------------ Student " + (i+1) + "/" + n + " ------------\n\n");
        System.out.print("EN Number (EN12345678): EN");
        s[i].EN = scanner.nextLong();
        scanner.nextLine();

            if(countDigit(s[i].EN)==8){
                
                System.out.println("\nI. Personal Details");
                System.out.print("1. Name (Surename_Name_Lastname): ");
                s[i].name = scanner.nextLine();

                while(true){
                    System.out.print("2. Contact Number: ");
                    long ph = scanner.nextLong();

                    if(countDigit(ph)==10){
                        s[i].ph=ph;
                        scanner.nextLine();
                        
                        System.out.print("3. Email: ");
                        s[i].email= scanner.nextLine();

                        char A;

                        do{
                            System.out.println("\n   a. Open  b. SC  c. ST  d. OBC  e. SBC");
                            System.out.print("4. Category: ");
                            A = scanner.next().charAt(0);
                            scanner.nextLine();

                            switch(A){

                                case 'a':
                                    s[i].category="Open";
                                    break;
                                
                                case 'b':
                                    s[i].category="SC";
                                    break;
                                
                                case 'c':
                                    s[i].category="ST";
                                    break;

                                case 'd':
                                    s[i].category="OBC";
                                    break;

                                case 'e':
                                    s[i].category="SBC";
                                    break;
                                
                                default:
                                    System.out.println("!!! Invaid Input, Try Again !!!");
                            }

                        }while(A!='a' && A!='b' && A!='c' && A!='d' && A!='e');
                        System.out.println("   "+s[i].category);

                        char B;
                        do{
                            System.out.println("\n   a. Male  b. Female  c. Other");
                            System.out.print("5. Gender: ");
                            B = scanner.next().charAt(0);
                            scanner.nextLine();

                            switch(B){

                                case 'a':
                                    s[i].gender="Male";
                                    break;
                                
                                case 'b':
                                    s[i].gender="Female";
                                    break;
                                
                                case 'c':
                                    s[i].gender="Other";
                                    break;
                                
                                default:
                                    System.out.println("!!! Invaid Input, Try Again !!!");
                            }

                        }while(B!='a' && B!='b' && B!='c');
                        System.out.println("   "+s[i].gender);

                        char C;

                        do{
                            System.out.println("\n   y. Yes  n. No");
                            System.out.print("6. PWD/DEF: ");
                            C = scanner.next().charAt(0);
                            scanner.nextLine();

                            switch(C){

                                case 'y':
                                    s[i].pwd_def="Yes";
                                    break;
                                
                                case 'n':
                                    s[i].pwd_def="No";
                                    break;
                               
                                default:
                                    System.out.println("!!! Invaid Input, Try Again !!!");
                            }

                        }while(C!='y' && C!='n');
                        System.out.println("   "+s[i].pwd_def);

                        char D;
                        do{
                            System.out.println("\n   y. Yes  n. No");
                            System.out.print("7. EWS: ");
                            D = scanner.next().charAt(0);
                            scanner.nextLine();

                            switch(D){

                                case 'y':
                                    s[i].ews="Yes";
                                    break;
                                
                                case 'n':
                                    s[i].ews="No";
                                    break;
                               
                                default:
                                    System.out.println("!!! Invaid Input, Try Again !!!");
                            }

                        }while(D!='y' && D!='n');
                        System.out.println("   "+s[i].ews); 
                        
                        if(s[i].ews == "Yes"){
                            System.out.println("\n8. TFWS:Not Elligible");
                        }

                        else{
                            
                            char E;
                            do{
                                System.out.println("\n   y. Yes  n. No");
                                System.out.print("8. TFWS: ");
                                E = scanner.next().charAt(0);
                                scanner.nextLine();

                                switch(E){

                                    case 'y':
                                        s[i].tfws="Yes";
                                        break;
                                    
                                    case 'n':
                                        s[i].tfws="No";
                                        break;
                                
                                    default:
                                        System.out.println("!!! Invaid Input, Try Again !!!");
                                }

                            }while(E!='y' && E!='n');
                            System.out.println("   "+s[i].tfws); 
                            
                        }

                            char F;
                            do{
                                System.out.println("\n   y. Yes  n. No");
                                System.out.print("9. Orphan: ");
                                F = scanner.next().charAt(0);
                                scanner.nextLine();

                                switch(F){

                                    case 'y':
                                        s[i].orphan="Yes";
                                        break;
                                    
                                    case 'n':
                                        s[i].orphan="No";
                                        break;
                                
                                    default:
                                        System.out.println("!!! Invaid Input, Try Again !!!");
                                }

                            }while(F!='y' && F!='n');
                            System.out.println("   "+s[i].orphan);

                            char G;
                            do{
                                System.out.println("\n   r. Religious Minority  l. Liguistic Minority  n. None");
                                System.out.print("10. Minority: ");
                                G = scanner.next().charAt(0);
                                scanner.nextLine();

                                switch(G){

                                    case 'r':
                                        s[i].minority="Religious Minority";
                                        break;
                                    
                                    case 'l':
                                        s[i].minority="Linguistic Minority";
                                        break;

                                    case 'n':
                                        s[i].minority="None";
                                        break;
                                
                                    default:
                                        System.out.println("!!! Invaid Input, Try Again !!!");
                                }

                            }while(G!='r' && G!='l' && G!='n');
                            System.out.println("   "+s[i].minority);

                            //TAKING DETAILS OF SSC MARKS
                            System.out.println("\nII. SSC Marks");

                            do{
                                System.out.print("1. English: ");
                                s[i].ssc.eng = scanner.nextFloat();
                                ssc_arr[0]=s[i].ssc.eng;
                                if((s[i].ssc.eng<0) || (s[i].ssc.eng>100)){
                                    System.out.println("!!! Invalid Marks, Enter Again !!!\n");
                                }
                            }while((s[i].ssc.eng<0) || (s[i].ssc.eng>100));

                            do{
                                System.out.print("2. Maths: ");
                                s[i].ssc.maths = scanner.nextFloat();
                                ssc_arr[1]=s[i].ssc.maths;
                                if((s[i].ssc.maths<0) || (s[i].ssc.maths>100)){
                                    System.out.println("!!! Invalid Marks, Enter Again !!!\n");
                                }
                            }while((s[i].ssc.maths<0) || (s[i].ssc.maths>100));

                            do{
                                System.out.print("3. Science: ");
                                s[i].ssc.science = scanner.nextFloat();
                                ssc_arr[2]=s[i].ssc.science;
                                if((s[i].ssc.science<0) || (s[i].ssc.science>100)){
                                    System.out.println("!!! Invalid Marks, Enter Again !!!\n");
                                }
                            }while((s[i].ssc.science<0) || (s[i].ssc.science>100));

                            do{
                                System.out.print("4. Social Studies: ");
                                s[i].ssc.ss = scanner.nextFloat();
                                ssc_arr[3]=s[i].ssc.ss;
                                if((s[i].ssc.ss<0) || (s[i].ssc.ss>100)){
                                    System.out.println("!!! Invalid Marks, Enter Again !!!\n");
                                }
                            }while((s[i].ssc.ss<0) || (s[i].ssc.ss>100));

                            do{
                                System.out.print("5. Hindi: ");
                                s[i].ssc.hindi = scanner.nextFloat();
                                ssc_arr[4]=s[i].ssc.hindi;
                                if((s[i].ssc.hindi<0) || (s[i].ssc.hindi>100)){
                                    System.out.println("!!! Invalid Marks, Enter Again !!!\n");
                                }
                            }while((s[i].ssc.hindi<0) || (s[i].ssc.hindi>100));

                            do{
                                System.out.print("6. Marathi: ");
                                s[i].ssc.marathi = scanner.nextFloat();
                                ssc_arr[5]=s[i].ssc.marathi;
                                if((s[i].ssc.marathi<0) || (s[i].ssc.marathi>100)){
                                    System.out.println("!!! Invalid Marks, Enter Again !!!\n");
                                }
                            }while((s[i].ssc.marathi<0) || (s[i].ssc.marathi>100));

                            min=ssc_arr[0];
                            for(int j=0; j<6; j++){
                                if(ssc_arr[j]<min){
                                    min=ssc_arr[j];
                                    c=j;
                                }
                            }

                            ssc_arr[c]=0;
                            for(int j=0; j<6; j++){
                                ssctotal+=ssc_arr[j];
                            }

                            s[i].ssc.total=ssctotal;
                            System.out.println("7. Total (Best of 5 ): "+s[i].ssc.total);

                            s[i].ssc_per = calculatePercentage((s[i].ssc.total), 500);
                            System.out.println("8. Percentage: "+s[i].ssc_per);
                            
                            //TAKING DETAILS OF HSC MARKS
                            System.out.println("\nIII. HSC Marks");

                            do{
                                System.out.print("1. English: ");
                                s[i].hsc.eng = scanner.nextFloat();
                                if((s[i].hsc.eng<0) || (s[i].hsc.eng>100)){
                                    System.out.println("!!! Invalid Marks, Enter Again !!!\n");
                                }
                            }while((s[i].hsc.eng<0) || (s[i].hsc.eng>100));

                            do{
                                System.out.print("2. Physics: ");
                                s[i].hsc.physics = scanner.nextFloat();
                                if((s[i].hsc.physics<0) || (s[i].hsc.physics>100)){
                                    System.out.println("!!! Invalid Marks, Enter Again !!!\n");
                                }
                            }while((s[i].hsc.physics<0) || (s[i].hsc.physics>100));

                            do{
                                System.out.print("3. Chemistry: ");
                                s[i].hsc.chemistry = scanner.nextFloat();
                                if((s[i].hsc.chemistry<0) || (s[i].hsc.chemistry>100)){
                                    System.out.println("!!! Invalid Marks, Enter Again !!!\n");
                                }
                            }while((s[i].hsc.chemistry<0) || (s[i].hsc.chemistry>100));

                            do{
                                System.out.print("4. Maths: ");
                                s[i].hsc.maths = scanner.nextFloat();
                                if((s[i].hsc.maths<0) || (s[i].hsc.maths>100)){
                                    System.out.println("!!! Invalid Marks, Enter Again !!!\n");
                                }
                            }while((s[i].hsc.maths<0) || (s[i].hsc.maths>100));

                            do{
                                System.out.print("5. Vocational: ");
                                s[i].hsc.vocational = scanner.nextFloat();
                                if((s[i].hsc.vocational<0) || (s[i].hsc.vocational>200)){
                                    System.out.println("!!! Invalid Marks, Enter Again !!!\n");
                                }
                            }while((s[i].hsc.vocational<0) || (s[i].hsc.vocational>200));
                            
                            s[i].hsc_pcm = calculatePercentage((s[i].hsc.physics + s[i].hsc.chemistry + s[i].hsc.maths), 300);
                            System.out.println("7. PCM: "+s[i].hsc_pcm);

                            s[i].hsc.total = s[i].hsc.eng + s[i].hsc.physics + s[i].hsc.chemistry + s[i].hsc.maths + s[i].hsc.vocational;
                            System.out.println("6. Total: "+s[i].hsc.total);

                            s[i].hsc_per = calculatePercentage(s[i].hsc.total , 600);
                            System.out.println("8. Percentage: "+ s[i].hsc_per);

                            //TAKING DETAILS OF MHT-CET MARKS
                            System.out.println("\nIV. MHT-CET Details");

                            do{
                                System.out.print("1. Physics: ");
                                s[i].mhtcet.physics = scanner.nextFloat();
                                if((s[i].mhtcet.physics<0) || (s[i].mhtcet.physics>50)){
                                    System.out.println("!!! Invalid Marks, Enter Again !!!\n");
                                }
                            }while((s[i].mhtcet.physics<0) || (s[i].mhtcet.physics>50));

                            do{
                                System.out.print("2. Chemistry: ");
                                s[i].mhtcet.chemistry = scanner.nextFloat();
                                if((s[i].mhtcet.chemistry<0) || (s[i].mhtcet.chemistry>50)){
                                    System.out.println("!!! Invalid Marks, Enter Again !!!\n");
                                }
                            }while((s[i].mhtcet.chemistry<0) || (s[i].mhtcet.chemistry>50));

                            do{
                                System.out.print("3. Maths: ");
                                s[i].mhtcet.maths = scanner.nextFloat();
                                if((s[i].mhtcet.maths<0) || (s[i].mhtcet.maths>100)){
                                    System.out.println("!!! Invalid Marks, Enter Again !!!\n");
                                }
                            }while((s[i].mhtcet.maths<0) || (s[i].mhtcet.maths>100));
                            
                            s[i].mhtcet.total = s[i].mhtcet.physics + s[i].mhtcet.chemistry + s[i].mhtcet.maths;
                            System.out.println("4. Total: "+s[i].mhtcet.total);

                            //BIRTH DATE DETAILS
                            System.out.println("\nIV. Date of Birth");

                            //BIRTH YEAR
                            System.out.print("1. Year: ");
                            s[i].dob.year = scanner.nextInt();
                            if ((s[i].dob.year % 4 == 0 || s[i].dob.year % 400 == 0) && (s[i].dob.year % 100 != 0)){  // LEAP YEAR CONDITION

                                //BIRTH MONTH
                                do{
                                    System.out.print("2. Month: ");
                                    s[i].dob.month =scanner.nextInt();
                                    if((s[i].dob.month<0) || (s[i].dob.month>12)){
                                    System.out.println("!!! Invalid Month, Enter Again !!!\n");
                                }
                                }while((s[i].dob.month<0) || (s[i].dob.month>12));

                                if(s[i].dob.month == 2){

                                    //BIRTH DAY
                                    do{
                                        System.out.print("3. Day: ");
                                        s[i].dob.day =scanner.nextInt();
                                        if((s[i].dob.day<0) || (s[i].dob.day>29)){
                                        System.out.println("!!! Invalid Day, Enter Again !!!\n");
                                    }
                                    }while((s[i].dob.day<0) || (s[i].dob.day>29));
                                }

                                else if(s[i].dob.month %2 != 0){

                                    //BIRTH DAY
                                    do{
                                        System.out.print("3. Day: ");
                                        s[i].dob.day =scanner.nextInt();
                                        if((s[i].dob.day<0) || (s[i].dob.day>31)){
                                        System.out.println("!!! Invalid Day, Enter Again !!!\n");
                                    }
                                    }while((s[i].dob.day<0) || (s[i].dob.day>31));
                                }

                                else if(s[i].dob.month %2 == 0){

                                    //BIRTH DAY
                                    do{
                                        System.out.print("3. Day: ");
                                        s[i].dob.day =scanner.nextInt();
                                        if((s[i].dob.day<0) || (s[i].dob.day>30)){
                                        System.out.println("!!! Invalid Day, Enter Again !!!\n");
                                    }
                                    }while((s[i].dob.day<0) || (s[i].dob.day>30));
                                }
                            }

                            else{
                                //BIRTH MONTH
                                do{
                                    System.out.print("2. Month: ");
                                    s[i].dob.month =scanner.nextInt();
                                    if((s[i].dob.month<0) || (s[i].dob.month>12)){
                                    System.out.println("!!! Invalid Month, Enter Again !!!\n");
                                }
                                }while((s[i].dob.month<0) || (s[i].dob.month>12));

                                if(s[i].dob.month == 2){

                                    //BIRTH DAY
                                    do{
                                        System.out.print("3. Day: ");
                                        s[i].dob.day =scanner.nextInt();
                                        if((s[i].dob.day<0) || (s[i].dob.day>28)){
                                        System.out.println("!!! Invalid Day, Enter Again !!!\n");
                                    }
                                    }while((s[i].dob.day<0) || (s[i].dob.day>28));
                                }

                                else if(s[i].dob.month %2 != 0){

                                    //BIRTH DAY
                                    do{
                                        System.out.print("3. Day: ");
                                        s[i].dob.day =scanner.nextInt();
                                        if((s[i].dob.day<0) || (s[i].dob.day>31)){
                                        System.out.println("!!! Invalid Day, Enter Again !!!\n");
                                    }
                                    }while((s[i].dob.day<0) || (s[i].dob.day>31));
                                }

                                else if(s[i].dob.month %2 == 0){

                                    //BIRTH DAY
                                    do{
                                        System.out.print("3. Day: ");
                                        s[i].dob.day =scanner.nextInt();
                                        if((s[i].dob.day<0) || (s[i].dob.day>30)){
                                        System.out.println("!!! Invalid Day, Enter Again !!!\n");
                                    }
                                    }while((s[i].dob.day<0) || (s[i].dob.day>30));
                                }
                            }

                            System.out.println(s[i].dob.day + "/" +s[i].dob.month + "/" +s[i].dob.year);
                        

                        break;
                    }

                    else{
                        System.out.println("!!! Invalid Contact Number, Enter Again !!!\n");
                    }
                }

                break;
            }

            else{
                System.out.println("!!! Invalid EN Number, Enter Again !!!");
            }
        }

    }



    sortAndAssignChemistryPercentile(s);
    sortAndAssignPhysicsPercentile(s);
    sortAndAssignMathsPercentile(s);
    sortAndAssignTotalPercentile(s);

    for(int i=0; i<n-1; i++){
        if((s[i].per.total)==(s[i+1].per.total)){
            sortByMathsPercentile(i,i+1,s);
            if((s[i].per.maths)==(s[i+1].per.maths)){
                sortByPhysicsPercentile(i,i+1,s);
                if((s[i].per.physics)==(s[i+1].per.physics)){
                    sortByChemistryPercentile(i,i+1,s);
                    if((s[i].per.chemistry)==(s[i+1].per.chemistry)){
                        sortByPCM(i,i+1,s);
                        if((s[i].hsc_pcm)==(s[i+1].hsc_pcm)){
                            sortHscMaths(i,i+1,s);
                            if((s[i].hsc.maths)==(s[i+1].hsc.maths)){
                                sortHscPhysics(i,i+1,s);
                                if((s[i].hsc.physics)==(s[i+1].hsc.physics)){
                                   sortHscTotal(i,i+1,s);
                                    if((s[i].hsc.total)==(s[i+1].hsc.total)){
                                       sortSscTotal(i,i+1,s);
                                        if((s[i].ssc.total)==(s[i+1].ssc.total)){
                                            sortSscMaths(i,i+1,s);
                                            if((s[i].ssc.maths)==(s[i+1].ssc.maths)){
                                                sortSscScience(i,i+1,s);
                                                if((s[i].ssc.science)==(s[i+1].ssc.science)){
                                                    sortSscEnglish(i,i+1,s);
                                                    if((s[i].ssc.eng)==(s[i+1].ssc.eng)){
                                                        sortYear(i,i+1,s);
                                                        if((s[i].dob.year)==(s[i+1].dob.year)){
                                                            sortMonth(i,i+1,s);
                                                            if((s[i].dob.month)==(s[i+1].dob.month)){
                                                                sortDay(i,i+1,s);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println("\n---------------- WELCOME TO MHT-CET MERIT LIST ----------------");
        System.out.println("MERIT NO\t\tAPPLICATION ID\t\tCANDIDATE'S FULL NAME\t\tCATEGORY\t\tGENDER\t\tPWD/DEF\t\tEWS\t\tTFWS\t\tORPHAN\t\tMINORITY(LM/RM)\t\tTOTAL PERCENTILE\t\tMATHS PERCENTILE\t\tPHYSICS PERCENTILE\t\tCHEMISTRY PERCENTILE\t\tHSC PCM\t\t\tHSC MATHS\t\tHSC PHYSICS\t\tHSC TOTAL\t\tSSC TOTAL\t\tSSC MATHS\t\tSSC SCIENCE\t\tSSC ENGLISH\t\tDOB\n");

        for (int i = 0; i < n; i++) {
            System.out.printf("%d\t\t\tEN%d\t\t%s\t\t\t%s\t\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t\t%.2f\t\t%.2f\t\t\t%.2f\t\t\t%.2f\t\t\t%.2f\t\t%.2f\t\t%.2f\t\t%.2f\t\t%.2f\t\t%.2f\t\t%.2f\t\t%.2f\t\t%d/%d/%d%n",
                i + 1, s[i].getEN(), s[i].getName(), s[i].getCategory(), s[i].getGender(), s[i].getPwdDef(), s[i].getEws(), s[i].getTfws(), s[i].getOrphan(),
                s[i].getMinority(), s[i].getPer().getTotal(), s[i].getPer().getMaths(), s[i].getPer().getPhysics(), s[i].getPer().getChemistry(),
                s[i].getHsc_pcm(), s[i].getHsc().getMaths(), s[i].getHsc().getPhysics(), s[i].getHsc_per(), s[i].getSsc_per(), s[i].getSsc().getMaths(), s[i].getSsc().getScience(), s[i].getSsc().getEng(), s[i].getDob().getDay(), s[i].getDob().getMonth(), s[i].getDob().getYear());
        }

        scanner.close();
    }

}
