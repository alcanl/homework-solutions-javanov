package org.csystem.homework.solution.homework2;

public class IsPrimeXTest {
    public static void run() {

        java.util.Scanner kb = new java.util.Scanner(System.in);

        for (; ; ) {
            System.out.print("Bir sayı giriniz : ");
            long val = Long.parseLong(kb.nextLine());

            if (val <= 0)
                return;

            if (isPrimeX(val))
                System.out.printf("%d sayısı ekstra asal bir sayıdır.\n", val);
            else
                System.out.printf("%d sayısı ekstra asal bir sayı değildir.\n", val);

        }
    }
    public static boolean isPrimeX(long a) {

        while (a / 10 != 0)
            if (isPrime(a))
                a = sumDigits(a);
            else
                return false;

        return isPrime(a);
    }

    public static int sumDigits(long a) {
        int sum = 0;

        while (a != 0) {
            sum += a % 10;
            a /= 10;
        }

        return sum;
    }
    public static boolean isPrime(long a) {
        if (a <= 1)
            return false;

        if (a % 2 == 0)
            return a == 2;

        if (a % 3 == 0)
            return a == 3;

        if (a % 5 == 0)
            return a == 5;

        if (a % 7 == 0)
            return a == 7;

        for (long i = 11; i * i <= a; i += 2)
            if (a % i == 0)
                return false;

        return true;

    }
}
