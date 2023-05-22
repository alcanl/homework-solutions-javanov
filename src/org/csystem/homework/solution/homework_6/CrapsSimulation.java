package org.csystem.homework.solution.homework_6;

public class CrapsSimulation {

    public static void run() {

        Craps newGame = new Craps();
        java.util.Random generator = new java.util.Random();

        Craps.dice = generator;

        for (int i = 1; i <= 100_000; ++i)
            newGame.startPlay();

        System.out.printf("Kazanma yüzdesi = %%%.02f", Craps.count / 100_000 * 100);

        }
    }
    class Craps {
        public int totalDiceVal;
        public static double count;
        public static java.util.Random dice;

        public void startPlay() {

            throwDices(dice);
            winControl();
        }

        public boolean isWin() {

            return switch (totalDiceVal) {
                case 7, 11 -> true;
                case 2, 3, 12 -> false;
                default -> isNextDiceWin();
            };
        }

        public boolean isNextDiceWin() {

            int temp = totalDiceVal;
            do {
                throwDices(dice);
                if (temp == totalDiceVal)
                    return true;
            } while (totalDiceVal != 7);
            return false;
        }

        public void throwDices(java.util.Random dice) {

            totalDiceVal = dice.nextInt(1, 7) + dice.nextInt(1, 7);

        }

        public void winControl() {

            if (isWin())
                ++count;
        }
    }


