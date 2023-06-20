package org.csystem.homework.solution.homework_14;

import java.util.Arrays;
import java.util.Scanner;

import static org.csystem.util.matrix.MatrixUtil.transpose;

public class Sudoku {
    private final int[][] m_sdm;
    private static boolean[] ms_controlArr = new boolean[9];
    private static final Scanner kb = new Scanner(System.in);
    public Sudoku()
    {
        m_sdm = new int[9][9];
    }
    private static boolean areValidControlArr()
    {
        for (boolean i : ms_controlArr)
            if (!i)
                return false;

        return true;
    }

    private static void cleanControlArr()
    {
        Arrays.fill(ms_controlArr, false);
    }
    private static boolean isValidCols(int [][] arr)
    {
        return isValidRows(transpose(arr));
    }
    private static boolean isValidRows(int [][] arr)
    {
        for (int i = 0; i < arr.length; ++i) {
            for (int k = 0; k < arr[i].length; ++k)
                if (ms_controlArr[arr[i][k] - 1])
                    return false;
                else
                    ms_controlArr[arr[i][k] - 1] = true;
            if (!areValidControlArr())
                return false;

            cleanControlArr();
        }
        return true;
    }

    private static boolean isValidTripleMatrix(int [][] arr)
    {
        for (int i = 0; i < 9; i += 3) {

            for (int j = i; j < i + 3; ++j) {
                for (int k = i; k < i + 3; ++k)
                    if (ms_controlArr[arr[i][k] - 1])
                        return false;
                    else
                        ms_controlArr[arr[i][k] - 1] = true;
            cleanControlArr();
            }
        }
        return true;
    }
    public void read() {

        System.out.print("Sudoku şablonunu giriniz : ");

        for (int i = 0; i < m_sdm.length; ++i)
            for (int k = 0; k < m_sdm[i].length; ++k)
                m_sdm[i][k] = kb.nextInt();

    }
    public boolean isValid()
    {
        return isValidRows(m_sdm) && isValidCols(m_sdm) && isValidTripleMatrix(m_sdm);
    }
}