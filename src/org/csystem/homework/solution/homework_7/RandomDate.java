package org.csystem.homework.solution.homework_7;

public class RandomDate {
    public static void run() {

        java.util.Random generator = new java.util.Random();
        Date newDate = new Date();

        newDate.createRandomDate(generator);
    }
}

class Date {
    public int year;
    public int month;
    public int day;

    public void printRandomDate() {

        String s = switch (month) {
            case 1 -> "Jan";
            case 2 -> "Feb";
            case 3 -> "Mar";
            case 4 -> "Apr";
            case 5 -> "May";
            case 6 -> "Jun";
            case 7 -> "Jul";
            case 8 -> "Aug";
            case 9 -> "Sep";
            case 10 -> "Oct";
            case 11 -> "Nov";
            case 12 -> "Dec";
            default -> null;
        };

        switch (day) {
            case 1, 21, 31 -> System.out.printf("%dst %s %d\n", day, s, year);
            case 2, 22 -> System.out.printf("%dnd %s %d\n", day, s, year);
            case 3, 23 -> System.out.printf("%drd %s %d\n", day, s, year);
            default -> System.out.printf("%dth %s %d\n", day, s, year);
        }

    }

    public void createRandomDate(java.util.Random generator) {

        year = generator.nextInt(1900, 2101);
        month = generator.nextInt(1, 13);

        day = switch (month) {
            case 4, 6, 9, 11 -> generator.nextInt(1, 31);
            case 2 -> {
                if (isLeapYear())
                    yield generator.nextInt(1, 30);
                yield generator.nextInt(1, 29);
            }
            default -> generator.nextInt(1, 32);
        };
        printRandomDate();
    }

    public boolean isLeapYear() {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
}

