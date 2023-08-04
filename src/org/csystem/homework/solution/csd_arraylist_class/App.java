package org.csystem.homework.solution.csd_arraylist_class;
import patika.homework.MyList;

import java.util.Random;

public class App {
    public static void main(String [] args)
    {
        run();
    }
    public static void run()
    {
        var list = new CsdArrayList<>();
        var random = new Random();

        for (int i = 0; i < 45; ++i)
            list.add(random.nextInt(100));

        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.capacity());
        System.out.println(list.get(44));
        System.out.println(list.set(4,20));
        System.out.println(list.remove(4));
        System.out.println(list.size());
        System.out.println(list.get(4));
        System.out.print(list);
        System.out.println();
        list.clear();
        System.out.println(list);
    }
}