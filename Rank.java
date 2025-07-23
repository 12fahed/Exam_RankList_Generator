import java.util.*;

public class Rank {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n---------------- WELCOME TO MHT-CET JAVA PROGRAM ----------------");
        System.out.print("\nEnter the Number of Students: ");
        int n = scanner.nextInt();
        Detail[] s = new Detail[n];
        float[] ssc_arr = new float[6];
        float min; 

        System.out.println("\nEnter the Details of " + n + " Student(s): ");

        for(int i=0; i<n; i++){
            int ssctotal=0, c=0;
            s[i] = new Detail();
            s[i].setSsc(new SSCDetails());
            s[i].setHsc(new HSCDetails());
            s[i].setMhtcet(new MHTCETDetails());
            s[i].setDob(new DOB());
            s[i].setPer(new MHTCETPercentileDetails());

            while(true){
                System.out.print("\n------------ Student " + (i+1) + "/" + n + " ------------\n\n");
                System.out.print("EN Number (EN12345678): EN");
                s[i].setEN(scanner.nextLong());
                scanner.nextLine();

                if(MHTCETUtility.countDigit(s[i].getEN())==8){
                    
                    System.out.println("\nI. Personal Details");
                    System.out.print("1. Name (Surename_Name_Lastname): ");
                    s[i].setName(scanner.nextLine());

                    while(true){
                        System.out.print("2. Contact Number: ");
                        long ph = scanner.nextLong();

                        if(MHTCETUtility.countDigit(ph)==10){
                            s[i].setPh(ph);
                            scanner.nextLine();
                            
                            System.out.print("3. Email: ");
                            s[i].setEmail(scanner.nextLine());

                            char A;
                            do{
                                System.out.println("\n   a. Open  b. SC  c. ST  d. OBC  e. SBC");
                                System.out.print("4. Category: ");
                                A = scanner.next().charAt(0);
                                scanner.nextLine();

                                switch(A){
                                    case 'a':
                                        s[i].setCategory("Open");
                                        break;
                                    case 'b':
                                        s[i].setCategory("SC");
                                        break;
                                    case 'c':
                                        s[i].setCategory("ST");
                                        break;
                                    case 'd':
                                        s[i].setCategory("OBC");
                                        break;
                                    case 'e':
                                        s[i].setCategory("SBC");
                                        break;
                                    default:
                                        System.out.println("!!! Invaid Input, Try Again !!!");
                                }
                            }while(A!='a' && A!='b' && A!='c' && A!='d' && A!='e');
                            System.out.println("   "+s[i].getCategory());

                            char B;
                            do{
                                System.out.println("\n   a. Male  b. Female  c. Other");
                                System.out.print("5. Gender: ");
                                B = scanner.next().charAt(0);
                                scanner.nextLine();

                                switch(B){
                                    case 'a':
                                        s[i].setGender("Male");
                                        break;
                                    case 'b':
                                        s[i].setGender("Female");
                                        break;
                                    case 'c':
                                        s[i].setGender("Other");
                                        break;
                                    default:
                                        System.out.println("!!! Invaid Input, Try Again !!!");
                                }
                            }while(B!='a' && B!='b' && B!='c');
                            System.out.println("   "+s[i].getGender());

                            char C;
                            do{
                                System.out.println("\n   y. Yes  n. No");
                                System.out.print("6. PWD/DEF: ");
                                C = scanner.next().charAt(0);
                                scanner.nextLine();

                                switch(C){
                                    case 'y':
                                        s[i].setPwdDef("Yes");
                                        break;
                                    case 'n':
                                        s[i].setPwdDef("No");
                                        break;
                                    default:
                                        System.out.println("!!! Invaid Input, Try Again !!!");
                                }
                            }while(C!='y' && C!='n');
                            System.out.println("   "+s[i].getPwdDef());

                            char D;
                            do{
                                System.out.println("\n   y. Yes  n. No");
                                System.out.print("7. EWS: ");
                                D = scanner.next().charAt(0);
                                scanner.nextLine();

                                switch(D){
                                    case 'y':
                                        s[i].setEws("Yes");
                                        break;
                                    case 'n':
                                        s[i].setEws("No");
                                        break;
                                    default:
                                        System.out.println("!!! Invaid Input, Try Again !!!");
                                }
                            }while(D!='y' && D!='n');
                            System.out.println("   "+s[i].getEws()); 
                            
                            if(s[i].getEws().equals("Yes")){
                                System.out.println("\n8. TFWS: Not Eligible");
                                s[i].setTfws("Not Eligible");
                            } else {
                                char E;
                                do{
                                    System.out.println("\n   y. Yes  n. No");
                                    System.out.print("8. TFWS: ");
                                    E = scanner.next().charAt(0);
                                    scanner.nextLine();

                                    switch(E){
                                        case 'y':
                                            s[i].setTfws("Yes");
                                            break;
                                        case 'n':
                                            s[i].setTfws("No");
                                            break;
                                        default:
                                            System.out.println("!!! Invaid Input, Try Again !!!");
                                    }
                                }while(E!='y' && E!='n');
                                System.out.println("   "+s[i].getTfws()); 
                            }

                            char F;
                            do{
                                System.out.println("\n   y. Yes  n. No");
                                System.out.print("9. Orphan: ");
                                F = scanner.next().charAt(0);
                                scanner.nextLine();

                                switch(F){
                                    case 'y':
                                        s[i].setOrphan("Yes");
                                        break;
                                    case 'n':
                                        s[i].setOrphan("No");
                                        break;
                                    default:
                                        System.out.println("!!! Invaid Input, Try Again !!!");
                                }
                            }while(F!='y' && F!='n');
                            System.out.println("   "+s[i].getOrphan());

                            char G;
                            do{
                                System.out.println("\n   r. Religious Minority  l. Liguistic Minority  n. None");
                                System.out.print("10. Minority: ");
                                G = scanner.next().charAt(0);
                                scanner.nextLine();

                                switch(G){
                                    case 'r':
                                        s[i].setMinority("Religious Minority");
                                        break;
                                    case 'l':
                                        s[i].setMinority("Linguistic Minority");
                                        break;
                                    case 'n':
                                        s[i].setMinority("None");
                                        break;
                                    default:
                                        System.out.println("!!! Invaid Input, Try Again !!!");
                                }
                            }while(G!='r' && G!='l' && G!='n');
                            System.out.println("   "+s[i].getMinority());

                            // TAKING DETAILS OF SSC MARKS
                            System.out.println("\nII. SSC Marks");

                            do{
                                System.out.print("1. English: ");
                                s[i].getSsc().setEng(scanner.nextFloat());
                                ssc_arr[0]=s[i].getSsc().getEng();
                                if((s[i].getSsc().getEng()<0) || (s[i].getSsc().getEng()>100)){
                                    System.out.println("!!! Invalid Marks, Enter Again !!!\n");
                                }
                            }while((s[i].getSsc().getEng()<0) || (s[i].getSsc().getEng()>100));

                            do{
                                System.out.print("2. Maths: ");
                                s[i].getSsc().setMaths(scanner.nextFloat());
                                ssc_arr[1]=s[i].getSsc().getMaths();
                                if((s[i].getSsc().getMaths()<0) || (s[i].getSsc().getMaths()>100)){
                                    System.out.println("!!! Invalid Marks, Enter Again !!!\n");
                                }
                            }while((s[i].getSsc().getMaths()<0) || (s[i].getSsc().getMaths()>100));

                            do{
                                System.out.print("3. Science: ");
                                s[i].getSsc().setScience(scanner.nextFloat());
                                ssc_arr[2]=s[i].getSsc().getScience();
                                if((s[i].getSsc().getScience()<0) || (s[i].getSsc().getScience()>100)){
                                    System.out.println("!!! Invalid Marks, Enter Again !!!\n");
                                }
                            }while((s[i].getSsc().getScience()<0) || (s[i].getSsc().getScience()>100));

                            do{
                                System.out.print("4. Social Studies: ");
                                s[i].getSsc().setSs(scanner.nextFloat());
                                ssc_arr[3]=s[i].getSsc().getSs();
                                if((s[i].getSsc().getSs()<0) || (s[i].getSsc().getSs()>100)){
                                    System.out.println("!!! Invalid Marks, Enter Again !!!\n");
                                }
                            }while((s[i].getSsc().getSs()<0) || (s[i].getSsc().getSs()>100));

                            do{
                                System.out.print("5. Hindi: ");
                                s[i].getSsc().setHindi(scanner.nextFloat());
                                ssc_arr[4]=s[i].getSsc().getHindi();
                                if((s[i].getSsc().getHindi()<0) || (s[i].getSsc().getHindi()>100)){
                                    System.out.println("!!! Invalid Marks, Enter Again !!!\n");
                                }
                            }while((s[i].getSsc().getHindi()<0) || (s[i].getSsc().getHindi()>100));

                            do{
                                System.out.print("6. Marathi: ");
                                s[i].getSsc().setMarathi(scanner.nextFloat());
                                ssc_arr[5]=s[i].getSsc().getMarathi();
                                if((s[i].getSsc().getMarathi()<0) || (s[i].getSsc().getMarathi()>100)){
                                    System.out.println("!!! Invalid Marks, Enter Again !!!\n");
                                }
                            }while((s[i].getSsc().getMarathi()<0) || (s[i].getSsc().getMarathi()>100));

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

                            s[i].getSsc().setTotal(ssctotal);
                            System.out.println("7. Total (Best of 5 ): "+s[i].getSsc().getTotal());

                            s[i].setSsc_per(MHTCETUtility.calculatePercentage((s[i].getSsc().getTotal()), 500));
                            System.out.println("8. Percentage: "+s[i].getSsc_per());
                            
                            // TAKING DETAILS OF HSC MARKS
                            System.out.println("\nIII. HSC Marks");

                            do{
                                System.out.print("1. English: ");
                                s[i].getHsc().setEng(scanner.nextFloat());
                                if((s[i].getHsc().getEng()<0) || (s[i].getHsc().getEng()>100)){
                                    System.out.println("!!! Invalid Marks, Enter Again !!!\n");
                                }
                            }while((s[i].getHsc().getEng()<0) || (s[i].getHsc().getEng()>100));

                            do{
                                System.out.print("2. Physics: ");
                                s[i].getHsc().setPhysics(scanner.nextFloat());
                                if((s[i].getHsc().getPhysics()<0) || (s[i].getHsc().getPhysics()>100)){
                                    System.out.println("!!! Invalid Marks, Enter Again !!!\n");
                                }
                            }while((s[i].getHsc().getPhysics()<0) || (s[i].getHsc().getPhysics()>100));

                            do{
                                System.out.print("3. Chemistry: ");
                                s[i].getHsc().setChemistry(scanner.nextFloat());
                                if((s[i].getHsc().getChemistry()<0) || (s[i].getHsc().getChemistry()>100)){
                                    System.out.println("!!! Invalid Marks, Enter Again !!!\n");
                                }
                            }while((s[i].getHsc().getChemistry()<0) || (s[i].getHsc().getChemistry()>100));

                            do{
                                System.out.print("4. Maths: ");
                                s[i].getHsc().setMaths(scanner.nextFloat());
                                if((s[i].getHsc().getMaths()<0) || (s[i].getHsc().getMaths()>100)){
                                    System.out.println("!!! Invalid Marks, Enter Again !!!\n");
                                }
                            }while((s[i].getHsc().getMaths()<0) || (s[i].getHsc().getMaths()>100));

                            do{
                                System.out.print("5. Vocational: ");
                                s[i].getHsc().setVocational(scanner.nextFloat());
                                if((s[i].getHsc().getVocational()<0) || (s[i].getHsc().getVocational()>200)){
                                    System.out.println("!!! Invalid Marks, Enter Again !!!\n");
                                }
                            }while((s[i].getHsc().getVocational()<0) || (s[i].getHsc().getVocational()>200));
                            
                            s[i].setHsc_pcm(MHTCETUtility.calculatePercentage((s[i].getHsc().getPhysics() + s[i].getHsc().getChemistry() + s[i].getHsc().getMaths()), 300));
                            System.out.println("7. PCM: "+s[i].getHsc_pcm());

                            s[i].getHsc().setTotal(s[i].getHsc().getEng() + s[i].getHsc().getPhysics() + s[i].getHsc().getChemistry() + s[i].getHsc().getMaths() + s[i].getHsc().getVocational());
                            System.out.println("6. Total: "+s[i].getHsc().getTotal());

                            s[i].setHsc_per(MHTCETUtility.calculatePercentage(s[i].getHsc().getTotal(), 600));
                            System.out.println("8. Percentage: "+ s[i].getHsc_per());

                            // TAKING DETAILS OF MHT-CET MARKS
                            System.out.println("\nIV. MHT-CET Details");

                            do{
                                System.out.print("1. Physics: ");
                                s[i].getMhtcet().setPhysics(scanner.nextFloat());
                                if((s[i].getMhtcet().getPhysics()<0) || (s[i].getMhtcet().getPhysics()>50)){
                                    System.out.println("!!! Invalid Marks, Enter Again !!!\n");
                                }
                            }while((s[i].getMhtcet().getPhysics()<0) || (s[i].getMhtcet().getPhysics()>50));

                            do{
                                System.out.print("2. Chemistry: ");
                                s[i].getMhtcet().setChemistry(scanner.nextFloat());
                                if((s[i].getMhtcet().getChemistry()<0) || (s[i].getMhtcet().getChemistry()>50)){
                                    System.out.println("!!! Invalid Marks, Enter Again !!!\n");
                                }
                            }while((s[i].getMhtcet().getChemistry()<0) || (s[i].getMhtcet().getChemistry()>50));

                            do{
                                System.out.print("3. Maths: ");
                                s[i].getMhtcet().setMaths(scanner.nextFloat());
                                if((s[i].getMhtcet().getMaths()<0) || (s[i].getMhtcet().getMaths()>100)){
                                    System.out.println("!!! Invalid Marks, Enter Again !!!\n");
                                }
                            }while((s[i].getMhtcet().getMaths()<0) || (s[i].getMhtcet().getMaths()>100));
                            
                            s[i].getMhtcet().setTotal(s[i].getMhtcet().getPhysics() + s[i].getMhtcet().getChemistry() + s[i].getMhtcet().getMaths());
                            System.out.println("4. Total: "+s[i].getMhtcet().getTotal());

                            // BIRTH DATE DETAILS
                            System.out.println("\nV. Date of Birth");

                            // BIRTH YEAR
                            System.out.print("1. Year: ");
                            s[i].getDob().setYear(scanner.nextInt());
                            if ((s[i].getDob().getYear() % 4 == 0 || s[i].getDob().getYear() % 400 == 0) && (s[i].getDob().getYear() % 100 != 0)){  // LEAP YEAR CONDITION

                                // BIRTH MONTH
                                do{
                                    System.out.print("2. Month: ");
                                    s[i].getDob().setMonth(scanner.nextInt());
                                    if((s[i].getDob().getMonth()<0) || (s[i].getDob().getMonth()>12)){
                                        System.out.println("!!! Invalid Month, Enter Again !!!\n");
                                    }
                                }while((s[i].getDob().getMonth()<0) || (s[i].getDob().getMonth()>12));

                                if(s[i].getDob().getMonth() == 2){
                                    // BIRTH DAY
                                    do{
                                        System.out.print("3. Day: ");
                                        s[i].getDob().setDay(scanner.nextInt());
                                        if((s[i].getDob().getDay()<0) || (s[i].getDob().getDay()>29)){
                                            System.out.println("!!! Invalid Day, Enter Again !!!\n");
                                        }
                                    }while((s[i].getDob().getDay()<0) || (s[i].getDob().getDay()>29));
                                }
                                else if(s[i].getDob().getMonth() %2 != 0){
                                    // BIRTH DAY
                                    do{
                                        System.out.print("3. Day: ");
                                        s[i].getDob().setDay(scanner.nextInt());
                                        if((s[i].getDob().getDay()<0) || (s[i].getDob().getDay()>31)){
                                            System.out.println("!!! Invalid Day, Enter Again !!!\n");
                                        }
                                    }while((s[i].getDob().getDay()<0) || (s[i].getDob().getDay()>31));
                                }
                                else if(s[i].getDob().getMonth() %2 == 0){
                                    // BIRTH DAY
                                    do{
                                        System.out.print("3. Day: ");
                                        s[i].getDob().setDay(scanner.nextInt());
                                        if((s[i].getDob().getDay()<0) || (s[i].getDob().getDay()>30)){
                                            System.out.println("!!! Invalid Day, Enter Again !!!\n");
                                        }
                                    }while((s[i].getDob().getDay()<0) || (s[i].getDob().getDay()>30));
                                }
                            }
                            else{
                                // BIRTH MONTH
                                do{
                                    System.out.print("2. Month: ");
                                    s[i].getDob().setMonth(scanner.nextInt());
                                    if((s[i].getDob().getMonth()<0) || (s[i].getDob().getMonth()>12)){
                                        System.out.println("!!! Invalid Month, Enter Again !!!\n");
                                    }
                                }while((s[i].getDob().getMonth()<0) || (s[i].getDob().getMonth()>12));

                                if(s[i].getDob().getMonth() == 2){
                                    // BIRTH DAY
                                    do{
                                        System.out.print("3. Day: ");
                                        s[i].getDob().setDay(scanner.nextInt());
                                        if((s[i].getDob().getDay()<0) || (s[i].getDob().getDay()>28)){
                                            System.out.println("!!! Invalid Day, Enter Again !!!\n");
                                        }
                                    }while((s[i].getDob().getDay()<0) || (s[i].getDob().getDay()>28));
                                }
                                else if(s[i].getDob().getMonth() %2 != 0){
                                    // BIRTH DAY
                                    do{
                                        System.out.print("3. Day: ");
                                        s[i].getDob().setDay(scanner.nextInt());
                                        if((s[i].getDob().getDay()<0) || (s[i].getDob().getDay()>31)){
                                            System.out.println("!!! Invalid Day, Enter Again !!!\n");
                                        }
                                    }while((s[i].getDob().getDay()<0) || (s[i].getDob().getDay()>31));
                                }
                                else if(s[i].getDob().getMonth() %2 == 0){
                                    // BIRTH DAY
                                    do{
                                        System.out.print("3. Day: ");
                                        s[i].getDob().setDay(scanner.nextInt());
                                        if((s[i].getDob().getDay()<0) || (s[i].getDob().getDay()>30)){
                                            System.out.println("!!! Invalid Day, Enter Again !!!\n");
                                        }
                                    }while((s[i].getDob().getDay()<0) || (s[i].getDob().getDay()>30));
                                }
                            }

                            System.out.println(s[i].getDob().getDay() + "/" +s[i].getDob().getMonth() + "/" +s[i].getDob().getYear());
                        
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

        MHTCETUtility.sortAndAssignChemistryPercentile(s);
        MHTCETUtility.sortAndAssignPhysicsPercentile(s);
        MHTCETUtility.sortAndAssignMathsPercentile(s);
        MHTCETUtility.sortAndAssignTotalPercentile(s);

        for(int i=0; i<n-1; i++){
            if((s[i].getPer().getTotal())==(s[i+1].getPer().getTotal())){
                MHTCETUtility.sortByMathsPercentile(i,i+1,s);
                if((s[i].getPer().getMaths())==(s[i+1].getPer().getMaths())){
                    MHTCETUtility.sortByPhysicsPercentile(i,i+1,s);
                    if((s[i].getPer().getPhysics())==(s[i+1].getPer().getPhysics())){
                        MHTCETUtility.sortByChemistryPercentile(i,i+1,s);
                        if((s[i].getPer().getChemistry())==(s[i+1].getPer().getChemistry())){
                            MHTCETUtility.sortByPCM(i,i+1,s);
                            if((s[i].getHsc_pcm())==(s[i+1].getHsc_pcm())){
                                MHTCETUtility.sortHscMaths(i,i+1,s);
                                if((s[i].getHsc().getMaths())==(s[i+1].getHsc().getMaths())){
                                    MHTCETUtility.sortHscPhysics(i,i+1,s);
                                    if((s[i].getHsc().getPhysics())==(s[i+1].getHsc().getPhysics())){
                                       MHTCETUtility.sortHscTotal(i,i+1,s);
                                        if((s[i].getHsc().getTotal())==(s[i+1].getHsc().getTotal())){
                                           MHTCETUtility.sortSscTotal(i,i+1,s);
                                            if((s[i].getSsc().getTotal())==(s[i+1].getSsc().getTotal())){
                                                MHTCETUtility.sortSscMaths(i,i+1,s);
                                                if((s[i].getSsc().getMaths())==(s[i+1].getSsc().getMaths())){
                                                    MHTCETUtility.sortSscScience(i,i+1,s);
                                                    if((s[i].getSsc().getScience())==(s[i+1].getSsc().getScience())){
                                                        MHTCETUtility.sortSscEnglish(i,i+1,s);
                                                        if((s[i].getSsc().getEng())==(s[i+1].getSsc().getEng())){
                                                            MHTCETUtility.sortYear(i,i+1,s);
                                                            if((s[i].getDob().getYear())==(s[i+1].getDob().getYear())){
                                                                MHTCETUtility.sortMonth(i,i+1,s);
                                                                if((s[i].getDob().getMonth())==(s[i+1].getDob().getMonth())){
                                                                    MHTCETUtility.sortDay(i,i+1,s);
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
