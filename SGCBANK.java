import java.util.Scanner;

public class SGCBANK {

    String accountNumber;
    String customerName;
    double balance;

    Scanner sc = new Scanner(System.in);

    void entry() {
        System.out.println("\n===== SGC BANK ACCOUNT MANAGEMENT SYSTEM =====");

        System.out.print("Enter Account Number: ");
        accountNumber = sc.nextLine();

        System.out.print("Enter Customer Name: ");
        customerName = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        balance = sc.nextDouble();

        while (balance < 0) {
            System.out.println("Initial balance cannot be negative.");
            System.out.print("Enter Initial Balance: ");
            balance = sc.nextDouble();
        }

        System.out.println("\nAccount created successfully!");
        System.out.println("Welcome, " + customerName + "!");
    }

    void deposit() {
        System.out.print("\nEnter amount to deposit: ");
        double amount = sc.nextDouble();

        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Amount deposited successfully!");
            System.out.println("Deposited Amount: Rs. " + amount);
        } else {
            System.out.println("Deposit amount must be greater than 0.");
        }
    }

    void withdraw() {
        System.out.print("\nEnter amount to withdraw: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than 0.");
        } else if (amount <= balance) {
            balance = balance - amount;
            System.out.println("Withdrawal successful!");
            System.out.println("Withdrawn Amount: Rs. " + amount);
        } else {
            System.out.println("Insufficient Balance.");
        }
    }

    void returnBalance() {
        System.out.println("\n===== ACCOUNT DETAILS =====");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Customer Name  : " + customerName);
        System.out.printf("Current Balance: Rs. %.2f%n", balance);
    }

    void exit() {
        System.out.println("\nThank you for using SGC Bank!");
        System.out.println("Have a nice day!");
    }

    public static void main(String[] args) {
        SGCBANK bank =
                new SGCBANK();

        Scanner input = bank.sc;

        bank.entry();

        int choice;

        do {
            System.out.println("\n===== WELCOME TO SGC BANK  =====");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    bank.deposit();
                    break;

                case 2:
                    bank.withdraw();
                    break;

                case 3:
                    bank.returnBalance();
                    break;

                case 4:
                    bank.exit();
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 4);

        bank.sc.close();
    }
}