package org.csystem.homework.solution.homework_4_5;

public class PerfectNumbers {
    public static void run() {

        for (int i = 2; i < 10000; ++i)
            if (isPerfect(i))
                System.out.printf("%d sayısı mükemmel sayıdır.\n", i);

    }

    public static boolean isPerfect(int val) {

        return sumFactors(val) == val;
    }

    public static int sumFactors(int val) {

        int sum = 1;
        for (int i = 2; i <= val / 2; ++i)
            if (val % i == 0)
                sum += i;
        return sum;

    }
}
