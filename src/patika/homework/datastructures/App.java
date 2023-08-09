package patika.homework.datastructures;

import java.lang.System.*;
import java.util.TreeSet;

import static java.lang.System.out;

public class App {
    public static void main(String[] args)
    {
        var book1 = new Book("Lordoftherings", 500);
        var book2 = new Book("harrypotter", 600);
        var book3 = new Book("karlarkraliçesi", 500);
        var book4 = new Book("alacakaranlık", 800);
        var book5 = new Book("sapiens", 450);

        TreeSet<Book> bookSet = new TreeSet<>();
        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        bookSet.add(book4);
        bookSet.add(book5);

        bookSet.forEach(out::println);
    }
}
