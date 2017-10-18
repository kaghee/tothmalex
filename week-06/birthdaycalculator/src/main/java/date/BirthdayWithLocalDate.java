package date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class BirthdayWithLocalDate implements BirthdayCalculator<LocalDate> {

    @Override
    public LocalDate parseDate(String str) {
        LocalDate date = LocalDate.parse(str);
        return date;
    }

    @Override
    public String printMonthAndDay(LocalDate date) {
        // TODO - return the date formatted: month & day (MM. dd.)
        int month = date.getMonthValue();
        int dayOfMonth = date.getDayOfMonth();
        String monthDay = (month + ". " + dayOfMonth + ".");
        return monthDay;
    }

    @Override
    public boolean isAnniversaryToday(LocalDate date) {
        // TODO - return with true if today is the same month+day as date
        if (date.toString() == LocalDate.now().toString());
        return true;
    }

    @Override
    public int calculateAgeInYears(LocalDate birthday) {
        // TODO - return how many years age the input date 'birthday' was
        int years = LocalDate.now().getYear() - birthday.getYear();
        return years;
    }

    @Override
    public int calculateDaysToNextAnniversary(LocalDate date) {
        // TODO - the number of days remaining to the next anniversary of 'date' (e.g. if tomorrow, return 1)
        LocalDate now = LocalDate.now();
        int expected;
        if (now.getDayOfYear() == date.getDayOfYear()) {
            expected = 0;
        } else if (now.getDayOfYear() > date.getDayOfYear()) {
            return LocalDate.of(now.getYear(), 12, 31).getDayOfYear() - now.getDayOfYear() + date.getDayOfYear();
        } else {
            return date.getDayOfYear() - now.getDayOfYear();
        }
        return expected;
    }

    public static void main(String[] args) {
        new BirthdayWithLocalDate().run();
    }

    private void run() {

        print("Birthday with java.util.Date.");
        String birthdayStr = readInput("What day were you born (yyyy-mm-dd)?");

        LocalDate birthdayDate = parseDate(birthdayStr);
        print("Your birthday: " + printMonthAndDay(birthdayDate));

        if (isAnniversaryToday(birthdayDate)) {
            int ageInYears = calculateAgeInYears(birthdayDate);
            print("Congratulations! Today is your " + ageInYears + "th birthday!");
        } else {
            int daysLeft = calculateDaysToNextAnniversary(birthdayDate);
            print("You have to wait only " + daysLeft + " days for your next birthday.");
        }
    }

    private void print(String line) {
        System.out.println(line);
    }

    private String readInput(String message) {
        System.out.print(message + ": ");
        return input.nextLine();
    }

    private final Scanner input = new Scanner(System.in, "UTF-8");
}