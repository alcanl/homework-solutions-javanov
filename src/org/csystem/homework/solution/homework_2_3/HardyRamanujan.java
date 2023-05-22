package org.csystem.homework.solution.homework_2_3;

public class HardyRamanujan {
    public static void run() {

        for (int i = 1; i < 100000; ++i)
            if (isHardyRamanujan(i))
                System.out.printf("%d\n", i);

    }
    public static boolean isHardyRamanujan(int a) {

        for (int i = 1; i < 47; ++i)
            for (int k = i; k < 47; ++k)
                if (i * i * i + k * k * k == a && i != k)
                    for (int j = 1; j < 47; ++j)
                        for (int m = j; m < 47; ++m)
                            if (j * j * j + m * m * m == a && j != m)
                                if (i != j && k != m)
                                    return true;
        return false;

    }
}
