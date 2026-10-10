import java.util.Scanner;

class Patient {
    String name, patientId, disease, doctor, appointmentDate, medicine;
    int age;
    double consultationFee, medicineCost, testCost;

    void patientInfo() {
        System.out.println("\n----- Patient Details -----");
        System.out.println("Patient Name : " + name);
        System.out.println("Patient ID   : " + patientId);
        System.out.println("Age          : " + age);
        System.out.println("Disease      : " + disease);
        System.out.println("Doctor       : " + doctor);
        System.out.println("Appointment Date : " + appointmentDate);
        System.out.println("Suggested Medicine Category : " + medicine);
    }

    void appointmentInfo() {
        System.out.println("\n----- Appointment Details -----");
        System.out.println("Doctor : " + doctor);
        System.out.println("Date   : " + appointmentDate);
    }

    void calculateFees() {
        consultationFee = 300;
        medicineCost = 0;
        testCost = 0;

        if (disease.equalsIgnoreCase("fever")) {
            doctor = "General Physician";
            medicine = "Fever assessment and appropriate treatment";
            medicineCost = 50;
        } else if (disease.equalsIgnoreCase("cough")) {
            doctor = "General Physician";
            medicine = "Cough assessment and appropriate treatment";
            medicineCost = 100;
        } else if (disease.equalsIgnoreCase("body pain")) {
            doctor = "General Physician";
            medicine = "Body pain assessment and appropriate treatment";
            medicineCost = 80;
        } else if (disease.equalsIgnoreCase("headache")) {
            doctor = "General Physician";
            medicine = "Headache assessment and appropriate treatment";
            medicineCost = 60;
        } else if (disease.equalsIgnoreCase("stomach pain")) {
            doctor = "General Physician";
            medicine = "Abdominal pain assessment and appropriate treatment";
            medicineCost = 100;
        } else {
            doctor = "General Physician";
            medicine = "Medical examination required";
            medicineCost = 0;
        }
    }

    double calculateBill() {
        return consultationFee + medicineCost + testCost;
    }

    void billingInfo() {
        System.out.println("\n----- Hospital Bill -----");
        System.out.printf("Consultation Fee : Rs. %.2f%n", consultationFee);
        System.out.printf("Estimated Medicine Cost : Rs. %.2f%n", medicineCost);
        System.out.printf("Test Cost : Rs. %.2f%n", testCost);
        System.out.println("--------------------------------");
        System.out.printf("Total Bill : Rs. %.2f%n", calculateBill());
        System.out.println("Note: Estimated costs are for project demonstration.");
    }

    void displayRecord() {
        System.out.println("\n=================================");
        System.out.println("       HOSPITAL PATIENT RECORD");
        System.out.println("=================================");
        patientInfo();
        appointmentInfo();
        billingInfo();
        System.out.println("=================================");
    }
}

public class SGCHospital {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Patient[] patients = new Patient[50];
        int count = 0;
        int choice;

        do {
            System.out.println("\n=================================");
            System.out.println("       WELCOME TO SGC HOSPITAL");
            System.out.println("=================================");
            System.out.println("1. Register Patient");
            System.out.println("2. Display Patient Records");
            System.out.println("3. Exit");
            System.out.println("=================================");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    if (count < patients.length) {
                        patients[count] = new Patient();

                        System.out.println("\n--- Patient Registration ---");

                        System.out.print("Enter Patient Name: ");
                        patients[count].name = sc.nextLine();

                        System.out.print("Enter Patient ID: ");
                        patients[count].patientId = sc.nextLine();

                        System.out.print("Enter Patient Age: ");
                        patients[count].age = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Disease/Symptoms: ");
                        patients[count].disease = sc.nextLine();

                        System.out.print("Enter Appointment Date: ");
                        patients[count].appointmentDate = sc.nextLine();

                        patients[count].calculateFees();

                        count++;

                        System.out.println("\nPatient registered successfully!");
                    } else {
                        System.out.println("\nPatient limit reached!");
                    }
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("\nNo patient records available.");
                    } else {
                        System.out.println("\n===== PATIENT RECORDS =====");

                        for (int i = 0; i < count; i++) {
                            System.out.println("\nPatient " + (i + 1));
                            patients[i].displayRecord();
                        }
                    }
                    break;

                case 3:
                    System.out.println("\nThank you for using SGC Hospital!");
                    break;

                default:
                    System.out.println("\nInvalid choice! Please try again.");
            }

        } while (choice != 3);

        sc.close();
    }
}