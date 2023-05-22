package org.csystem.homework.solution;

import org.csystem.homework.solution.homework1.NumberSort;
import org.csystem.homework.solution.homework1.NumberUtil;

public class App {
    public static void main(String[] args) {
        runFindNums();
        runMid();
        runSignum();
    }
    public static void runFindNums() {
        java.util.Scanner kb = new java.util.Scanner(System.in);

        System.out.print("Üç adet sayı giriniz : ");
        int a = kb.nextInt();
        int b = kb.nextInt();
        int c = kb.nextInt();

        NumberSort.findNums(a, b, c);
    }

    public static void runMid() {
        java.util.Scanner kb = new java.util.Scanner(System.in);

        System.out.print("Üç adet sayı giriniz : ");
        int a = kb.nextInt();
        int b = kb.nextInt();
        int c = kb.nextInt();

        int result = NumberUtil.mid(a, b, c);
        System.out.printf("The middle number is %d.\n", result);
    }
    public static void runSignum() {
        java.util.Scanner kb = new java.util.Scanner(System.in);

        System.out.print("Bir sayı giriniz : ");
        int a = kb.nextInt();

        System.out.printf("%d", NumberUtil.signum(a));
    }
}

