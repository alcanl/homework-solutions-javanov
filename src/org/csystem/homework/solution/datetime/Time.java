/*----------------------------------------------------------------------------------------------------------------------
    Aşağıda bildirilen Time sınıfını açıklamalara göre yazınız
    Açıklamalar:
        - Sınıf bir zamanı temsil edecektir (saat, dakika, saniye ve milisaniye)

        - JavaSE'nin veya başka bir kütüphanenin tarih zaman işlemlerine ilişkin sınıfları ve metotları kullanılmayacaktır

        - Sınıfın public bölümünü değiştirmeden istediğiniz eklemeyi yapabilirsiniz

        - Sınıf geçersiz zaman durumunu kontrol edecektir. Geçersizlik durumunda bir mesaj vererek program sonlandırılacaktır.

        - Sınıf 24 saat dilimine göre değerleri ele alacaktır

        - Sınıfın içerisinde bildirilen metotlarda
            throw new UnsupportedOperationException("TODO");
        biçimindeki deyim geri dönüş değeri olan metotlar error vermesin diye yazışmıştır. Bu konu ileride ele alınacaktır.
        Metodu yazarken bu deyimi kaldırınız

        - Sınıfa ilişkin test kodlarını da yazınız
-----------------------------------------------------------------------------------------------------------------------*/

/*------------------------------------------------------------------
	FILE		: Time.java
	AUTHOR		: Java-Nov-2022 Group
	LAST UPDATE	: 21.05.2023

	Time class that represents a time

	Copyleft (c) 1993 by C and System Programmers Association
	All Rights Free
------------------------------------------------------------------ */
package org.csystem.homework.solution.datetime;

public class Time {
    private int m_hour;
    private int m_minute;
    private int m_second;
    private int m_millisecond;
    public static final int MAX_HOUR_PER_DAY = 24;
    public static final int MIN_HOUR_PER_DAY = 0;
    public static final int MAX_MINUTE_PER_HOUR = 60;
    public static final int MIN_MINUTE_PER_HOUR = 0;
    public static final int MAX_SECOND_PER_MINUTE = 60;
    public static final int MIN_SECOND_PER_MINUTE = 0;
    public static final int MAX_MILLISECOND_PER_SECOND = 1000;
    public static final int MIN_MILLISECOND_PER_SECOND = 0;
    private static boolean isValidHour(int hour)
    {
        return hour >= MIN_HOUR_PER_DAY && hour < MAX_HOUR_PER_DAY;
    }
    private static boolean isValidMinute(int minute)
    {
        return minute >= MIN_MINUTE_PER_HOUR && minute < MAX_MINUTE_PER_HOUR;
    }
    private static boolean isValidSecond(int second)
    {
        return second >= MIN_SECOND_PER_MINUTE && second < MAX_SECOND_PER_MINUTE;
    }
    private static boolean isValidMillisecond(int millisecond)
    {
        return millisecond >= MIN_MILLISECOND_PER_SECOND && millisecond < MAX_MILLISECOND_PER_SECOND;
    }
    private static boolean isValidTime(int hour, int minute, int second, int millisecond)
    {
        return isValidHour(hour) && isValidMinute(minute) && isValidSecond(second) && isValidMillisecond(millisecond);
    }
    public Time(int hour, int minute, int second, int millisecond)
    {
        if (!isValidTime(hour, minute, second, millisecond)) {
            System.out.println("Invalid Time Values!");
            System.exit(0);
        }

        m_hour = hour;
        m_minute = minute;
        m_second = second;
        m_millisecond = millisecond;
    }

    public int getHour()
    {
        return m_hour;
    }

    public void setHour(int hour)
    {
        if (!isValidHour(hour)) {
            System.out.println("Invalid hour value!");
            System.exit(0);
        }

        m_hour = hour;
    }

    public int getMinute()
    {
        return m_minute;
    }

    public void setMinute(int minute)
    {
        if (!isValidMinute(minute)) {
            System.out.println("Invalid minute value!");
            System.exit(0);
        }

        m_minute = minute;
    }

    public int getSecond()
    {
        return m_second;
    }

    public void setSecond(int second)
    {
        if (!isValidSecond(second)) {
            System.out.println("Invalid second value!");
            System.exit(0);
        }

        m_second = second;
    }

    public int getMillisecond()
    {
        return m_millisecond;
    }

    public void setMillisecond(int millisecond)
    {
        if (!isValidMillisecond(millisecond)) {
            System.out.println("Invalid millisecond value!");
            System.exit(0);
        }
        m_millisecond = millisecond;
    }
    public String toString()
    {
        return String.format("%02d:%02d:%02d", m_hour, m_minute, m_second);
    }

    public String toShortTimeString()
    {
        return String.format("%02d:02d", m_hour, m_minute);
    }

    public String toLongTimeString()
    {
        return String.format("%02d:%02d:%02d.%03d", m_hour, m_minute, m_second, m_millisecond);
    }
}
