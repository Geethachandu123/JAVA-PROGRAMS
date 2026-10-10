import java.util.Scanner;

class Student {
    int id;
    String name;
    int totalClasses;
    int presentClasses;

    void addStudent(Scanner sc) {
        System.out.print("Enter Student ID: ");
        id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        name = sc.nextLine();

        totalClasses = 0;
        presentClasses = 0;

        System.out.println("Student Added Successfully!");
    }

    void markAttendance(Scanner sc) {
        System.out.print("Enter Total Classes Conducted: ");
        int total = sc.nextInt();

        System.out.print("Enter Classes Attended: ");
        int present = sc.nextInt();

        if (total < 0 || present < 0 || present > total) {
            System.out.println("Invalid Attendance Details!");
            return;
        }

        totalClasses = total;
        presentClasses = present;

        System.out.println("Attendance Recorded Successfully!");
    }

    double getPercentage() {
        if (totalClasses == 0) {
            return 0;
        }

        return (presentClasses * 100.0) / totalClasses;
    }

    void displayReport() {
        System.out.println("\n----- ATTENDANCE REPORT -----");
        System.out.println("Student ID: " + id);
        System.out.println("Student Name: " + name);
        System.out.println("Total Classes: " + totalClasses);
        System.out.println("Classes Attended: " + presentClasses);
        System.out.printf("Attendance Percentage: %.2f%%\n", getPercentage());

        if (totalClasses == 0) {
            System.out.println("Status: Attendance Not Recorded");
        } else if (getPercentage() < 75) {
            System.out.println("Status: LOW ATTENDANCE");
        } else {
            System.out.println("Status: GOOD ATTENDANCE");
        }
    }
}

public class SGCAttendanceManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[50];
        int count = 0;
        int choice;

        do {
            System.out.println("\n===== SGC ATTENDANCE MANAGEMENT =====");
            System.out.println("1. Add Student");
            System.out.println("2. Mark Attendance");
            System.out.println("3. Display Attendance Reports");
            System.out.println("4. Low Attendance Report");
            System.out.println("5. Exit");
            System.out.print("Enter Your Choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (count == students.length) {
                        System.out.println("Student limit reached!");
                        break;
                    }

                    students[count] = new Student();
                    students[count].addStudent(sc);
                    count++;
                    break;

                case 2:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    boolean found = false;

                    for (int i = 0; i < count; i++) {
                        if (students[i].id == id) {
                            students[i].markAttendance(sc);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student Not Found!");
                    }
                    break;

                case 3:
                    if (count == 0) {
                        System.out.println("No Students Registered!");
                    }

                    for (int i = 0; i < count; i++) {
                        students[i].displayReport();
                    }
                    break;

                case 4:
                    boolean low = false;

                    for (int i = 0; i < count; i++) {
                        if (students[i].totalClasses > 0 &&
                            students[i].getPercentage() < 75) {

                            students[i].displayReport();
                            low = true;
                        }
                    }

                    if (!low) {
                        System.out.println("No Students With Low Attendance!");
                    }
                    break;

                case 5:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}