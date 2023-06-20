package org.csystem.homework.solution.homework_15;

import java.util.Random;

public class Card {
    private CardType m_cardType;
    private CardValue m_cardValue;
    private static final Random random = new Random();
    private static String [] splitString(String str)
    {
        return str.strip().split("[ -]+");
    }
    private static void createDeck(Card [] deck)
    {
        int j = 0;
        for (int i = CardType.SPADE.ordinal() + 1; i <= CardType.HEART.ordinal() + 1; ++i)
            for (int k = CardValue.ACE.getCardValue(); k <= CardValue.KING.getCardValue(); ++k)
                deck[j++] = new Card(k, i);
    }
    private static Card [] shuffleDeck(Card [] deck)
    {
        Card temp = new Card(null, null);

        int count = 50, firstCard, secondCard;

        while (count-- > 0) {
            firstCard = random.nextInt(52);
            secondCard = random.nextInt(52);
            if (firstCard == secondCard)
                continue;
            temp = deck[firstCard];
            deck[firstCard] = deck[secondCard];
            deck[secondCard] = temp;
        }
        return deck;
    }
    private Card (int value, int type)
    {
        this(CardValue.getCardValue(value), CardType.values()[type - 1]);
    }
    public static Card [] getShuffledDeck()
    {
        Card [] deck = new Card[52];
        createDeck(deck);
        return shuffleDeck(deck);
    }
    public Card(CardValue value, CardType type)
    {
        m_cardValue = value;
        m_cardType = type;
    }
    public Card(String name)
    {
        String [] s = splitString(name);
        m_cardValue = CardValue.getCardValue(s[1]);
        m_cardType = CardType.getCardType(s[0]);
    }
    public String getName()
    {
        return m_cardValue.toString() + " " + m_cardType.toString();
    }
    public void setName(String name)
    {
        String [] s = splitString(name);

        m_cardValue = CardValue.getCardValue(s[1]);
        m_cardType = CardType.getCardType(s[0]);
    }
    public String toString()
    {
        return m_cardType.getCardTypeTR() + " " + m_cardValue.getCardValueTR();
    }
}
