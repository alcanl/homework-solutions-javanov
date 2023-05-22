package org.csystem.homework.solution.homework_4_5;

public class SumFactors {
    public static void run() {
        java.util.Scanner kb = new java.util.Scanner(System.in);

        for (;;) {
            System.out.print("Bir sayı giriniz : ");
            int val = Integer.parseInt(kb.nextLine());
            if (val == 0)
                break;
            if (val < 0) {
                System.out.println("Geçersiz giriş.");
                continue;
            }

            System.out.println(sumFactors(val));
        }
    }

    public static int sumFactors(int val) {


        int sum = 1;
        for (int i = 2; i <= val / 2; ++i)
            if (val % i == 0)
                sum += i;
        return sum;

    }
}
