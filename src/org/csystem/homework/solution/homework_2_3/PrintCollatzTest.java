package org.csystem.homework.solution.homework_2_3;

public class PrintCollatzTest {
    public static void run() {

        java.util.Scanner kb = new java.util.Scanner(System.in);
        for (;;) {
            System.out.print("Bir sayı giriniz : ");
            int val = Integer.parseInt(kb.nextLine());
            if (val == 0)
                return;
            if (val < 0)
                System.out.println("Geçersiz bir sayı girdiniz.");
            else
                printCollatz(val);

        }
    }
    public static void printCollatz(int a) {

        while (a != 1) {
            System.out.printf("%d ", a);
            if (a % 2 == 0)
                a /= 2;
            else {
                a *= 3;
                ++a;
            }
        }
        System.out.println(a);
    }
}
