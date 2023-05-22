package org.csystem.homework.solution.homework_11;

import java.util.Random;
public class CentralLimitTheorem
{
    public int [] counts;
    public static Random r;
    public CentralLimitTheorem()
    {
        counts = new int[10];
        r = new Random();
    }
    public CentralLimitTheorem(int [] arr, Random generator)
    {
        counts = arr;
        r = generator;
    }
    public void run()
    {
        int n, sum, avg;

        for (int i = 1; i <= 5000; ++i)
        {
            sum = 0; avg = 0; n = 5;

            while (n-- > 0){
                sum+= r.nextInt(1, 10001);
            }
            avg = sum / 5;
            getArrayData(avg);
        }
        drawHistogram( 50, 'X');
    }
    public void getArrayData(double avg)
    {
        for (int i = 0; i < counts.length; ++i)
            if (avg <= (i + 1) * 1000 && avg > i * 1000)
                ++counts[i];
    }
    public void drawHistogram(int n, char ch)
    {
        for (int i = 0; i < counts.length; ++i) {
            System.out.printf("(%d - %d) aralığı : ", i * 1000, (i + 1) * 1000);
            for (int k = 0; k < counts[i] / n; ++k)
                System.out.print(ch);
            System.out.println();
        }
    }
}
