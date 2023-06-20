package org.csystem.homework.solution.homework_15;

public enum CardType {
    SPADE("MAÇA"), CLUB("SİNEK"), DIAMOND("KARO"), HEART("KUPA");
    private String m_nameTR;
    CardType(String nameTR)
    {
        m_nameTR = nameTR;
    }
    public static CardType getCardType(String nameTR)
    {
        CardType [] temp = values();
        for (int i = 0; i < temp.length; ++i)
            if (temp[i].m_nameTR.equalsIgnoreCase(nameTR))
                return temp[i];

        throw new IllegalArgumentException("CardType can be one of these : MAÇA, SİNEK, KUPA, KARO");
    }
    public String getCardTypeTR()
    {
        return m_nameTR;
    }

}
