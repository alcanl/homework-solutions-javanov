package org.csystem.homework.solution.homework_2_3;

public class GoldbachTheory {
    public static void run() {
        java.util.Scanner kb = new java.util.Scanner(System.in);

        for (;;) {
            System.out.print("İkiden büyük çift bir sayı giriniz : ");
            int n = kb.nextInt();
            if (n <= 2 || n % 2 != 0)
                System.out.println("Geçersiz bir sayı girdiniz.");
            else if (n == 0)
                return;
            else
                getValue(n);
        }
    }
    public static void getValue(int n) {

        for (int i = 1; i < n; i += 2)
            for (int k = n + 1; k >= i; k -= 2)
                if (i + k == n)
                    if (isPrime(i) && isPrime(k))
                        System.out.printf("%d = %d + %d olarak iki asal sayının toplamı şelinde yazılabilir.\n", n, i, k);
        }

        public static boolean isPrime(int a) {
            if (a <= 1)
                return false;

            if (a % 2 == 0)
                return a == 2;

            if (a % 3 == 0)
                return a == 3;

            if (a % 5 == 0)
                return a == 5;

            if (a % 7 == 0)
                return a == 7;

            for (long i = 11; i * i <= a; i += 2)
                if (a % i == 0)
                    return false;

            return true;
        }

}



