package org.csystem.homework.solution.homework_16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayListExam {
    private static final Scanner kb = new Scanner(System.in);
    private final ArrayList<ArrayList<String>> ms_arrayList;
    public ArrayListExam()
    {
        ms_arrayList = new ArrayList<>();
    }

    private void fillArrayList(String[] str, ArrayList<String> arrayList)
    {
        arrayList.addAll(Arrays.asList(str));
        ms_arrayList.add(arrayList);
    }
    private void displayList()
    {
        System.out.println("<Names>");
        for (var arr : ms_arrayList) {
            System.out.print("\t<Line>\n");
            for (String str : arr)
                System.out.printf("\t\t<Name>%s</Name>\n", str);
            System.out.print("\t</Line>\n");
        }
        System.out.println("</Names>");
    }
    private String[] splitLine(String str)
    {
        return str.split("[ ]+");
    }
    public void run()
    {
        while (true) {
            System.out.print("Input the names in a line: ");
            String s = kb.nextLine();

            if (s.equalsIgnoreCase("exit"))
                break;

            fillArrayList(splitLine(s), new ArrayList<>());
        }
        displayList();
    }
}
