package org.csystem.homework.solution.homework2;

public class ConditionalPrimeNumbers {
    public static void run() {

        for (int i = 1; i <= 9; ++i)
            for (int k = 1; k <= 9; ++k)
                for (int j = 1; j <= 9;  ++j)
                    if (isGreater(i, k, j) && isPrimeTotal(i, k, j) && isPrimeTotalReverse(i, k, j) && isPrimeDigits(i, k)
                            && isPrimeDigits(k, j) && isPrimeDigits(k, j) && isPrimeDigits(i, k))
                        System.out.printf("%d%d%d\n", i, k, j);
    }

    public static boolean isGreater(int a, int b, int c) {

        return 100 * c + 10 * b + a > 100 * a + 10 * b + c;
    }

    public static boolean isPrimeTotal(int a, int b, int c) {

        return isPrime(100 * a + 10 * b + c);
    }

    public static boolean isPrimeTotalReverse(int a, int b, int c) {

        return isPrime(100 * c + 10 * b + a);
    }

    public static boolean isPrimeDigits(int a, int b) {

        return isPrime(10 * a + b);
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
