package org.csystem.homework.solution.homework_15;

public enum CardValue {
    ACE("AS"), TWO("İKİ"), THREE("ÜÇ"), FOUR("DÖRT"),
    FIVE("BEŞ"), SIX("ALTI"), SEVEN("YEDİ"), EIGHT("SEKİZ"),
    NINE("DOKUZ"), TEN("ON"), KNAVE("VALE"), QUEEN("KIZ"), KING("PAPAZ");
    private String m_valueTR;
    CardValue(String valueTR)
    {
        m_valueTR = valueTR;
    }
    public static CardValue getCardValue(int value)
    {
        return values()[value - 1];
    }
    public static CardValue getCardValue(String nameTR)
    {
        CardValue [] temp = values();

        for (int i = 0; i < temp.length; ++i)
            if (temp[i].m_valueTR.equalsIgnoreCase(nameTR))
                return temp[i];

        throw new IllegalArgumentException("Invalid Card Value!");
    }
    public int getCardValue()
    {
        return ordinal() + 1;
    }
    public String getCardValueTR()
    {
        return m_valueTR;
    }
}
