package org.csystem.homework.solution.homework1;

public class NumberSort {
    public static void findNums(int a, int b, int c) {
        int max = Math.max(Math.max(a, b), c);
        int min = Math.min(Math.min(a, b), c);
        int mid = a + b + c - max - min;
        if (max == mid && mid == min)
            System.out.printf("%d = %d = %d", min, mid, max);
        else if (max == mid || mid == min)
            NumberSort.sameNums(min, mid, max);
        else
            System.out.printf("%d < %d < %d", min, mid, max);
    }

    public static void sameNums(int min, int mid, int max) {
        if (max == mid && mid != min)
            System.out.printf("%d < %d = %d", min, mid, max);
        else
            System.out.printf("%d = %d < %d", min, mid, max);
    }
}



