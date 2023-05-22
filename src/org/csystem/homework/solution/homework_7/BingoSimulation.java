package org.csystem.homework.solution.homework_7;

public class BingoSimulation {
    public static void run() {

        Bingo newGame = new Bingo();
        java.util.Random generator = new java.util.Random();

        double countDifference = 0, countLesser = 0, countIsPrime = 0;
        for (int i = 1; i <= 30000; ++i) {
            newGame.pullTokens(generator);

            if (newGame.difference())
                ++countDifference;
            if (newGame.areLesserThan())
                ++countLesser;
            if (newGame.isTotalPrime())
                ++countIsPrime;
        }
        System.out.printf(
                "1. oyun için kazanma yüzdesi = %%%.02f\n2. oyun için kazanma yüzdesi = %%%.02f\n3. oyun için kazanma yüzdesi = %%%.02f\n",
                countLesser / 30000 * 100, countIsPrime / 30000 * 100, countDifference / 30000 * 100);

    }
}

class Bingo {
    public int tokenVal1;
    public int tokenVal2;
    public int tokenVal3;

    public boolean difference() {

        int max = Math.max(Math.max(tokenVal1, tokenVal2), tokenVal3);
        int min = Math.min(Math.min(tokenVal1, tokenVal2), tokenVal3);
        int mid = tokenVal1 + tokenVal2 + tokenVal3 - max - min;

        return max - min > mid;

    }

    public boolean areLesserThan() {

        return tokenVal1 + tokenVal2 + tokenVal3 < 150;
    }

    public boolean isTotalPrime() {

        return isPrime(tokenVal1 + tokenVal2 + tokenVal3);
    }

    public void pullTokens(java.util.Random token) {

        tokenVal1 = token.nextInt(1, 100);
        tokenVal2 = token.nextInt(1, 100);
        tokenVal3 = token.nextInt(1, 100);

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

