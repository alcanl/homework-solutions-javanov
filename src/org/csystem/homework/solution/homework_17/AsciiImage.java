package org.csystem.homework.solution.homework_17;

import org.csystem.util.array.ArrayUtil;
import java.util.Scanner;

public class AsciiImage {
    private static final Scanner kb = new Scanner(System.in);
    private String[] m_image;
    private String m_command;
    public AsciiImage(String[] img)
    {
        m_image = img;
    }
    private void display()
    {
        ArrayUtil.display(m_image);
        System.out.printf("%d %d\n", m_image[0].length(), m_image.length);
    }
    private void doCommand()
    {
        switch (m_command) {
            case "disp" -> display();
            case "transpose" -> transpose();
            case "flipv" -> flipV();
            case "quit" -> System.exit(1);
            default -> System.out.println("Invalid command!");
        }
    }
    private void flipV()
    {
        String [] temp = m_image.clone();

        for (var i = temp.length - 1; i >= 0; --i)
            m_image[m_image.length - 1 - i] = temp[i];
    }
    private void getCommand()
    {
        m_command = kb.nextLine().toLowerCase();
    }

    private char [][] getTransposed()
    {
        char [][] temp = new char [m_image[0].length()][m_image.length];

        for (var i = 0; i < temp.length; ++i)
            for (var k = 0; k < temp[0].length; ++k)
                temp[i][k] = m_image[k].charAt(i);

        return temp;
    }
    private boolean isValidImage()
    {
        int len = m_image[0].length();

        for (String str : m_image)
            if (str.length() != len)
                return false;

        return true;
    }
    private void transpose()
    {
        char [][] temp = getTransposed(); String [] arr = new String[temp.length]; int i = 0;

        for (char [] ch : temp)
            arr[i++] = String.valueOf(ch);

        m_image = arr;
    }
    public void run()
    {
        if (!isValidImage()) {
            System.out.println("INPUT MISMATCH");
            System.exit(1);
        }
        for (;;) {
            getCommand();
            doCommand();
        }
    }
}
