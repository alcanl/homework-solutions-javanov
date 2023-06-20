package org.csystem.homework.solution.homework_9;

import java.util.Random;
import java.util.Scanner;

import static org.csystem.util.numeric.NumberUtil.getDigits;

public class MasterMindApp {
    public static int [] determinedValue;
    public int [] guessedValue;
    public int countTrueLocation;
    public int countWrongLocation;
    public static Random r;
    public static Scanner kb;
    public MasterMindApp(Random generator, Scanner keyboard)
    {
        r = generator;
        kb = keyboard;
        new MasterMindApp();
    }
    public MasterMindApp()
    {
        r = new Random();
        kb = new Scanner(System.in);
        determinedValue = getDigits(r.nextInt(1000, 10000));
    }

    public void run()
    {
        int n = 10;
        System.out.println("Sayı belirlendi!");
        while (n-- > 0) {
            getGuess();
            checkTheGuess();
            if (isWin()) {
                System.out.println("Tebrikler kazandınız!");
                break;
            }
            System.out.println(results());
        }
        if (n == -1 && !isWin())
            System.out.println("Başka hakkınız kalmadı.Maalesef kaybettiniz!");
    }
    public void checkTheGuess()
    {
        countTrueLocation = 0;
        countWrongLocation = 0;

        for (int i = 0; i < determinedValue.length; ++i)
            for (int k = 0; k < guessedValue.length; ++k)
                if (determinedValue[i] == guessedValue[k])
                    if (i == k)
                        ++countTrueLocation;
                    else
                        --countWrongLocation;
    }
    public void getGuess()
    {
        System.out.print("Tahmininizi giriniz : ");
        guessedValue = getDigits(Integer.parseInt(kb.nextLine()));
        System.out.println();
    }
    public String results()
    {
        String str = "";
        if (countTrueLocation > 0)
            str += countTrueLocation == 1 ? "+ " : String.format("+%d ",countTrueLocation);

        if (countWrongLocation < 0)
            str += countWrongLocation == -1 ? "- " : String.format("%d ",countWrongLocation);

        return str;
    }
    public boolean isWin()
    {
        return countTrueLocation == 4;
    }

}