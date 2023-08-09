package patika.homework.mylist;

import java.util.Random;

public class App {
    public static void main(String [] args)
    {
        run();
    }
    public static void run()
    {
        var list = new MyList<Integer>();
        var random = new Random();

        for (int i = 0; i < 45; ++i)
            list.add(random.nextInt(100));

        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.capacity());
        System.out.println(list.getIndex(44));
        System.out.println(list.setIndex(4,20));
        System.out.println(list.removeIndex(4));
        System.out.println(list.size());
        System.out.println(list.getIndex(4));
        System.out.print(list);
    }
}
