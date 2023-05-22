package org.csystem.homework.solution.homework2;

public class GetPrimeTest {
        public static void run() {
            java.util.Scanner kb = new java.util.Scanner(System.in);
            System.out.print("Bir sayı giriniz : ");
            int n = kb.nextInt();
            System.out.printf("%d inci asal sayı : %d", n, getPrime(n));
        }
        public static int getPrime(int n) {
            int count = 0, i = 0;

            while (n != count) {
                i++;
                if (isPrime(i))
                    count++;
            }

            return i;
        }
    public static boolean isPrime(long a) {
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
