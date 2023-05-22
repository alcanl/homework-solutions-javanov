package org.csystem.homework.solution.homework_2_3;

public class CalculateDigitalRootTest {
        public static void run() {

            java.util.Scanner kb = new java.util.Scanner(System.in);

            for (;;) {
                System.out.print("Bir sayı giriniz : ");
                int val = Integer.parseInt(kb.nextLine());

                if (val == 0)
                    return;

                System.out.printf("%d sayısının basamaksal kökü = %d\n", val, calculateDigitalRoot(val));
            }
        }
        public static int calculateDigitalRoot(int a) {

            while (a / 10 != 0)
                a = sumDigits(a);

            return Math.abs(a);
        }

        public static int sumDigits(int a) {
            int sum = 0;

            while (a != 0) {
                sum += a % 10;
                a /= 10;
            }

            return Math.abs(sum);
        }
    }


