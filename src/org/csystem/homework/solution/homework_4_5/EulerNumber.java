package org.csystem.homework.solution.homework_4_5;

public class EulerNumber {
    public static void run() {

        double e = 0;
        for (int i = 0; i < 1000000; ++i)
            e += 1. / factorial(i);

        System.out.printf("e number = %.20f\n", e);

    }
    public static int factorial(int a) {
        int result = 1;

        for (int i = 2; i <= a; ++i)
            result *= i;

        return result;
    }
}
