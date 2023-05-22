package org.csystem.homework.solution.homework_2_3;

public class IsSuperPrimeTest {
    public static void run() {

        java.util.Scanner kb = new java.util.Scanner(System.in);

        for (;;) {
            System.out.print("Bir sayı giriniz : ");
            int val = Integer.parseInt(kb.nextLine());

            if (isSuperPrime(val))
                System.out.printf("%d sayısı süper asal bir sayıdır.\n", val);
            else
                System.out.printf("%d sayısı süper asal bir sayı değildir.\n", val);

        }
    }
    public static boolean isSuperPrime(int a) {

        return getPrimeNumber(a) && isPrime(a);
    }

    public static boolean getPrimeNumber(int a) {
        int count = 0, i = 0;

        while (a != i) {
            i++;
            if (isPrime(i))
                count++;
        }

        return isPrime(count);

    }

    public static boolean isPrime(int a) {
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
