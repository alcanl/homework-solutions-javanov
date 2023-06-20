package org.csystem.homework.solution.homework10;

import static org.csystem.util.numeric.NumberUtil.getDigits;

public class App {

    public static boolean isPossible(int val1, int val2)
    {
        int [] firstNumDigits = getDigits(val1);
        int [] secondNumDigits = getDigits(val2);
        int count = 0;

        for (int i = 0; i < secondNumDigits.length; ++i)
            for (int k = 0; k < firstNumDigits.length; ++k)
                if (firstNumDigits[k] == secondNumDigits[i]) {
                    ++count;
                    break;
                }


        return count == secondNumDigits.length;
    }

    public static int mod(int [] a) {
        int mod = 0, maxCount = 0, count;

        for (int i = 0; i < a.length; i++) {
            count = 0;
            for (int k = 0; k < a.length; k++)
                if (a[k] == a[i])
                    count++;

            if (count > maxCount) {
                maxCount = count;
                mod = a[i];
            }
        }
        return mod;
    }


}
