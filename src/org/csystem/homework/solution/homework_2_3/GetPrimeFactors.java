package org.csystem.homework.solution.homework_2_3;

public class GetPrimeFactors {

    public static void run() {
        java.util.Scanner kb = new java.util.Scanner(System.in);
        System.out.print("Bir sayı giriniz : ");
        long n = kb.nextLong();
        calculate(n);

    }
    public static void calculate(long n) {

        System.out.printf("%d sayısının asal çarpanları : ", n);

        for (long i = 2; i <= n / 2; ++i)
            if (n % i == 0) {
                if (GetPrimeFactors.isPrime(i))
                    System.out.printf("%d ", i);
            }
        if (isPrime(n))
            System.out.printf("%d ", n);
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



