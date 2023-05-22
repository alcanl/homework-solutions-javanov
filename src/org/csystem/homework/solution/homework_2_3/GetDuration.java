package org.csystem.homework.solution.homework_2_3;

public class GetDuration {

    public static void run() {
        java.util.Scanner kb = new java.util.Scanner(System.in);
        System.out.print("Saniye değerini giriniz : ");
        long n = kb.nextLong();
        printDuration(n);

    }
        public static void printDuration(long n) {
            long hours, minutes, seconds;
            hours = calculateHours(n);
            minutes = calculateMinutes(n);
            seconds = calculateSeconds(n);
            System.out.printf("%d saniye = ", n);
            if (hours != 0)
                System.out.print(hours + " saat ");
            if (minutes != 0)
                System.out.print(minutes + " dakika ");
            if (seconds != 0)
                System.out.print(seconds + " saniye ");
        }

        public static long calculateHours(long n) {
            int i = 2;
            while (i-- > 0)
                n /= 60;
            return n;
        }

        public static long calculateMinutes(long n) {
            n /= 60;
            return n % 60;
        }

        public static long calculateSeconds(long n) {
            return n % 60;
        }
}



