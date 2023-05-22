package org.csystem.homework.solution.homework2;

public class DecimalHarshad {
    public static void run() {

        java.util.Scanner kb = new java.util.Scanner(System.in);
        for (;;) {
            System.out.print("Bir sayı giriniz : ");
            int val = Integer.parseInt(kb.nextLine());
            if (val == 0)
                return;

            if (isDecimalHarshad(val))
                System.out.printf("%d sayısı bir Harshad sayısıdır.\n", val);
            else
                System.out.printf("%d sayısı bir Harshad sayısı değildir.\n", val);
        }
    }
    public static boolean isDecimalHarshad(int a) {

        if (a < 0)
            return false;

        return a % sumDigits(a) == 0;

    }

    public static int sumDigits(int a) {
        int sum = 0;

        while (a != 0) {
            sum += a % 10;
            a /= 10;
        }

        return (sum);
    }

}
