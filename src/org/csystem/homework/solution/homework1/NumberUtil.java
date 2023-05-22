package org.csystem.homework.solution.homework1;

public class NumberUtil {
    public static int mid(int a, int b, int c) {

        if (a == b || b == c || a == c)
            return NumberUtil.sameNums(a, b, c);
        else
            return NumberUtil.differentNums(a, b, c);

    }

    public static int sameNums(int a, int b, int c) {
        if (a == b || a == c)
            return a;
        else
            return b;
    }

    public static int differentNums(int a, int b, int c) {
        if (a < b)
            if (b < c)
                return b;
            else if (a < c)
                return c;
            else
                return a;
        else if (b > c)
            return b;
        else if (a > c)
            return c;
        else
            return a;
    }
    public static int signum(int a) {
        if (Math.abs(a) == a)
            if (a != 0)
                return 1;
            else
                return 0;
        else
            return -1;

    }

}


