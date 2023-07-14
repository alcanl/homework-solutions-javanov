package org.csystem.homework.solution.homework_17;

import java.util.Scanner;

public class App {
    public static void main(String [] args)
    {
        var kb = new Scanner(System.in);

        System.out.print("Input the line count: ");
        var lineVal = Integer.parseInt(kb.nextLine());

        System.out.println("Input the image :");
        var image = new String [lineVal];

        for (var i = 0; i < image.length; ++i)
            image[i] = kb.nextLine();

        var ai = new AsciiImage(image);
        ai.run();
    }
}