package org.csystem.homework.solution.homework_15;

public class App {
    public static void main(String [] args)
    {
        Card[] deck;
        deck = Card.getShuffledDeck();
        for (Card c : deck)
            System.out.println(c.toString());
    }
}
