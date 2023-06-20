package org.csystem.homework.solution.homework_12;
import static java.lang.Math.*;
import org.csystem.util.array.ArrayUtil;

public class App {
    public static double standartDeviation(int [] a)
    {
        double avg = ArrayUtil.average(a);
        double sum = 0;

        for (int i = 0; i < a.length; ++i)
            sum += pow((int)(a[i] - avg), 2);

        return sqrt(sum / a.length);
    }

    public static int firstRepeated(int [] a)
    {
        for (int i = 0; i < a.length; ++i)
            for (int k = i + 1; k < a.length; ++k)
                if (a[i] == a[k])
                    return a[i];

        return a[0];
    }

}
