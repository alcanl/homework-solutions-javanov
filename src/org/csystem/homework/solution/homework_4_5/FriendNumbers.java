package org.csystem.homework.solution.homework_4_5;

public class FriendNumbers {
    public static void run() {

        EXIT_LOOP:
        for (int i = 1000; i < 10000; ++i)
            for (int k = i + 1; k < 10000; ++k)
                if (areFriends(i, k)) {
                    System.out.printf("%d ve %d sayıları arkadaş sayılardır.\n", i, k);
                    break EXIT_LOOP;
                }

    }

    public static boolean areFriends(int val1, int val2) {

        if (val1 <= 0 || val2 <= 0)
            return false;

        return sumFactors(val1) == val2 && sumFactors(val2) == val1;

    }

    public static int sumFactors(int val) {

        int sum = 1;
        for (int i = 2; i <= val / 2; ++i)
            if (val % i == 0)
                sum += i;
        return sum;

    }
}
