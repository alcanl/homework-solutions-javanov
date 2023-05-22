package org.csystem.homework.solution.homework_4_5;

public class GetStatistics {
    public static void run() {

        int min, max, sum, count, temp;
        double avg;
        min = max = sum = getVal();
        count = 1;
        for (;;)
            if (isContinue()) {
                ++count;
                temp = getVal();
                min = temp < min ? temp : min;
                max = temp > max ? temp : max;
                sum += temp;
            } else {
                avg = (double) sum / count;
                System.out.printf("Toplam %d değer girildi.\nMax = %d\nMin = %d\nOrtalama = %.4f\n", count, max, min,
                        avg);
                break;
            }
    }

    public static int getVal() {

        java.util.Scanner kb = new java.util.Scanner(System.in);

        System.out.print("Bir tamsayı giriniz : ");

        while (true) {
            int val = Integer.parseInt(kb.nextLine());
            if (val < 0 || val > 100) {
                System.out.printf("Geçersiz değer girdiniz!...\nYeni bir değer giriniz : ");
                continue;
            }
            return val;
        }
    }

    public static boolean isContinue() {

        java.util.Scanner kb = new java.util.Scanner(System.in);

        for (;;) {
            System.out.print(
                    "Yeni bir değer girmek istiyor musunuz? [Evet için 1(bir) Hayır için 0(sıfır) değerlerinden birini giriniz] ");
            int controlVal = Integer.parseInt(kb.nextLine());
            switch (controlVal) {
                case 1:
                    return true;
                case 0:
                    return false;
                default:
                    System.out.println("Geçersiz bir cevap girdiniz.");
            }
        }
    }
}
