import java.util.Scanner;
class SGC{
    String name;
    String rollno;
    String dep;

    int totalclases;
    int attendclass;

    int marks1;
    int marks2;
    int marks3;
    

    void studentinfo(){
        System.out.println("\n ------Student Details-----");
        System.out.println("Student Name  : "+name);
        System.out.println("Student RollNo  : "+rollno);
        System.out.println("Department   : "+dep);
    }
    double attendance(){
        return ((double)attendclass/totalclases)*100;

    }
    int getTotalmarks(){
        return marks1+marks2+marks3;
    }
    double getAverage(){
        return getTotalmarks()/3.0;
    }
    String getGrade(){
        double avg = getAverage();


        if (avg>=80){
            return "A";
        }
        else if(avg>=70){
            return "B";

        }
        else if(avg>=60){
            return "C";
            
        }
        else if(avg>=50){
            return "D";
            
        }
        else {
            return "F";
            
        }


    }
    String getResult(){
        if (marks1>=40 && marks2>=40 && marks3>=40){
            return "PASS";
        }
        else{
            return "FAIL";
        }
    }
    void Report(){
        System.out.println("\n=====================================");
        System.out.println("    STUDENT REPORT CARD");
        System.out.println("\n=====================================");
        System.out.println("Student Name  : "+name);
        System.out.println("Student RollNo  : "+rollno);
        System.out.println("Department   : "+dep);
        System.out.println("\n------Attedence------");
        System.out.println("Total classes  : "+totalclases);
        System.out.println("Attendance  : "+attendance());
        System.out.println("\n--------marks--------- ");
        System.out.println("Subject 1  : "+marks1);
        System.out.println("Subject 2  : "+marks2);
        System.out.println("Subject 3  : "+marks3);
        System.out.println("Total Marks : " + getTotalmarks());
        System.out.printf("Average     : %.2f\n", getAverage());
        System.out.println("Grade       : " + getGrade());
        System.out.println("Result      : " + getResult());

        if (attendance() < 75) {
            System.out.println("\nWarning: Attendance is below 75%.");
        }

        System.out.println("=================================");
    }
}


public class SGCStudentRecordS {

    public static void main(String[] args) {
        

        Scanner sc = new Scanner(System.in);

        SGC[] students = new SGC[50];
        int count = 0;
        int choice;

        do {

            System.out.println("\n===== UNIVERSITY STUDENT RECORD SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    if (count < students.length) {

                        students[count] = new SGC();

                        System.out.println("\n--- Enter Student Details ---");

                        System.out.print("Enter Student Name: ");
                        students[count].name = sc.nextLine();

                        System.out.print("Enter Student ID: ");
                        students[count].rollno = sc.nextLine();

                        System.out.print("Enter Department: ");
                        students[count].dep = sc.nextLine();

                        System.out.print("Enter Total Classes: ");
                        students[count].totalclases = sc.nextInt();

                        System.out.print("Enter Classes Attended: ");
                        students[count].attendclass = sc.nextInt();

                        System.out.print("Enter Subject 1 Marks: ");
                        students[count].marks1 = sc.nextInt();

                        System.out.print("Enter Subject 2 Marks: ");
                        students[count].marks2 = sc.nextInt();

                        System.out.print("Enter Subject 3 Marks: ");
                        students[count].marks3 = sc.nextInt();

                        sc.nextLine();

                        count++;

                        System.out.println("\nStudent added successfully!");

                    } else {

                        System.out.println("Student limit reached!");
                    }

                    break;


                case 2:

                    if (count == 0) {

                        System.out.println("\nNo students available.");

                    } else {

                        System.out.println("\n===== STUDENT RECORDS =====");

                        for (int i = 0; i < count; i++) {

                            System.out.println("\nStudent " + (i + 1));

                            students[i].Report();
                        }
                    }

                    break;


                case 3:

                    System.out.println("\nThank you for using the system!");

                    break;


                default:

                    System.out.println("\nInvalid choice!");

            }

        } while (choice != 3);

        sc.close();
    }
}