package org.csystem.homework.solution.homework2;

public class IsFactorianTest {
    public static void run() {


        for (int i = 1; i < 100000; ++i) {

            if (isFactorian(i))
                System.out.printf("%d sayısı factorian sayısıdır.\n", i);

        }
    }
    public static boolean isFactorian(int a) {

        return a == getDigitsFactorial(a);
    }

    public static int factorial(int a) {
        int result = 1;

        for (int i = 2; i <= a; ++i)
            result *= i;

        return result;
    }

    public static int getDigitsFactorial(int a) {

        int size = countDigits(a), sum = 0;
        int n[] = new int[size];

        for (int i = 0; i < size; ++i) {
            n[i] = a % 10;
            a /= 10;
        }
        for (int i = 0; i < size; ++i)
            sum += factorial(n[i]);

        return sum;

    }

    public static int countDigits(int a) {

        int count = 0;

        while (a != 0) {
            ++count;
            a /= 10;
        }

        return count;
    }
}



