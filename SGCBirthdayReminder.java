import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.DayOfWeek;
import java.time.MonthDay;

public class SGCBirthdayReminder {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LocalDate today = LocalDate.now();

        System.out.println("==================================");
        System.out.println("   SGC BIRTHDAY REMINDER SYSTEM");
        System.out.println("==================================");

        System.out.println("Current Date: " +
                today.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        System.out.print("Enter Person Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Birth Year: ");
        int year = sc.nextInt();

        System.out.print("Enter Birth Month: ");
        int month = sc.nextInt();

        System.out.print("Enter Birth Day: ");
        int day = sc.nextInt();

        try {
            LocalDate dob = LocalDate.of(year, month, day);

            if (dob.isAfter(today)) {
                System.out.println("Date of birth cannot be in the future.");
                sc.close();
                return;
            }

            Period age = Period.between(dob, today);

            System.out.println("\n========== BIRTHDAY DETAILS ==========");

            System.out.println("Name: " + name);

            System.out.println("Date of Birth: " +
                    dob.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

            System.out.println("Age: " + age.getYears() + " years, "
                    + age.getMonths() + " months, "
                    + age.getDays() + " days");

            DayOfWeek birthDay = dob.getDayOfWeek();

            System.out.println("Born On: " + birthDay);

            LocalDate nextBirthday = dob.withYear(today.getYear());

            if (nextBirthday.isBefore(today)) {
                nextBirthday = nextBirthday.plusYears(1);
            }

            long daysRemaining =
                    ChronoUnit.DAYS.between(today, nextBirthday);

            System.out.println("Next Birthday: " +
                    nextBirthday.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

            System.out.println("Days Remaining: " + daysRemaining);

            if (MonthDay.from(dob).equals(MonthDay.from(today))) {
                System.out.println("\n🎉 HAPPY BIRTHDAY, " +
                        name.toUpperCase() + "! 🎂");
                System.out.println("Wishing you a wonderful year ahead!");
            }

            System.out.println("======================================");

        } catch (Exception e) {
            System.out.println("Invalid date. Please enter a valid date of birth.");
        }

        sc.close();
    }
}