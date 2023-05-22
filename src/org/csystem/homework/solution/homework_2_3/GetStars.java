package org.csystem.homework.solution.homework_2_3;

class GetStars {
    public static void run() {
        java.util.Scanner kb = new java.util.Scanner(System.in);
        System.out.print("Bir sayı giriniz : ");
        int n = kb.nextInt();
        getAsterisk(n * 2);
        getAsteriskReverse(n * 2);
    }
    public static void getAsterisk(int n) {
        int i, j, k;

        for (i = 1; i < n; i += 2) {
            for (k = n - 2; k > i; --k)
                System.out.print(" ");
            for (j = 1; j <= i; ++j)
                System.out.print("*");
            System.out.println();
        }
    }
    public static void getAsteriskReverse(int n) {
        int i, j, k;

        for (i = 1; i < n; i += 2) {
            for (k = 1; k <= i; ++k)
                System.out.print(" ");
            for (j = n - 2; j > i; --j)
                System.out.print("*");
            System.out.println();
        }
    }
}