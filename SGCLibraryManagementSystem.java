import java.util.Scanner;

class Book {
    String bookName;
    String bookId;
    String studentName;
    String studentId;
    boolean issued;
    int daysKept;

    void bookInfo() {
        System.out.println("\nBook Name    : " + bookName);
        System.out.println("Book ID      : " + bookId);
        System.out.println("Availability : " + (issued ? "Issued" : "Available"));
    }

    void issueBook(String name, String id) {
        if (!issued) {
            studentName = name;
            studentId = id;
            issued = true;
            System.out.println("Book issued successfully!");
        } else {
            System.out.println("Book is already issued.");
        }
    }

    void returnBook(int days) {
        if (issued) {
            daysKept = days;
            double fine = 0;

            if (daysKept > 14) {
                fine = (daysKept - 14) * 2;
            }

            System.out.println("\n----- Book Return Details -----");
            System.out.println("Book Name    : " + bookName);
            System.out.println("Student Name : " + studentName);
            System.out.println("Days Kept    : " + daysKept);
            System.out.printf("Fine         : Rs. %.2f%n", fine);

            issued = false;
            studentName = "";
            studentId = "";

            System.out.println("Book returned successfully!");
        } else {
            System.out.println("This book has not been issued.");
        }
    }
}

public class SGCLibraryManagementSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Book[] books = new Book[50];
        int bookCount = 0;
        int choice;

        do {
            System.out.println("\n=================================");
            System.out.println("     SGC LIBRARY MANAGEMENT");
            System.out.println("=================================");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Check Book Availability");
            System.out.println("6. Exit");
            System.out.println("=================================");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    if (bookCount < books.length) {
                        books[bookCount] = new Book();

                        System.out.print("Enter Book Name: ");
                        books[bookCount].bookName = sc.nextLine();

                        System.out.print("Enter Book ID: ");
                        books[bookCount].bookId = sc.nextLine();

                        books[bookCount].issued = false;

                        bookCount++;

                        System.out.println("Book added successfully!");
                    } else {
                        System.out.println("Library book limit reached!");
                    }
                    break;

                case 2:
                    if (bookCount == 0) {
                        System.out.println("No books available in the library.");
                    } else {
                        System.out.println("\n===== BOOK INVENTORY =====");

                        for (int i = 0; i < bookCount; i++) {
                            System.out.println("\nBook " + (i + 1));
                            books[i].bookInfo();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Book ID to issue: ");
                    String issueId = sc.nextLine();

                    int issueIndex = -1;

                    for (int i = 0; i < bookCount; i++) {
                        if (books[i].bookId.equalsIgnoreCase(issueId)) {
                            issueIndex = i;
                            break;
                        }
                    }

                    if (issueIndex == -1) {
                        System.out.println("Book not found.");
                    } else {
                        System.out.print("Enter Student Name: ");
                        String studentName = sc.nextLine();

                        System.out.print("Enter Student ID: ");
                        String studentId = sc.nextLine();

                        books[issueIndex].issueBook(studentName, studentId);
                    }
                    break;

                case 4:
                    System.out.print("Enter Book ID to return: ");
                    String returnId = sc.nextLine();

                    int returnIndex = -1;

                    for (int i = 0; i < bookCount; i++) {
                        if (books[i].bookId.equalsIgnoreCase(returnId)) {
                            returnIndex = i;
                            break;
                        }
                    }

                    if (returnIndex == -1) {
                        System.out.println("Book not found.");
                    } else {
                        System.out.print("Enter number of days the book was kept: ");
                        int days = sc.nextInt();
                        sc.nextLine();

                        books[returnIndex].returnBook(days);
                    }
                    break;

                case 5:
                    System.out.print("Enter Book ID to check: ");
                    String checkId = sc.nextLine();

                    boolean found = false;

                    for (int i = 0; i < bookCount; i++) {
                        if (books[i].bookId.equalsIgnoreCase(checkId)) {
                            books[i].bookInfo();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Book not found.");
                    }
                    break;

                case 6:
                    System.out.println("Thank you for using SGC Library Management System!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}