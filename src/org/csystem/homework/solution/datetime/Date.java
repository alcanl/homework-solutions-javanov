/*----------------------------------------------------------------------------------------------------------------------
    Aşağıda bildirilen Date sınıfını açıklamalara göre yazınız
    Açıklamalar:
        - Sınıf bir tarihi temsil edecektir (gün, ay ve yıl)

        - JavaSE'nin veya başka bir kütüphanenin tarih zaman işlemlerine ilişkin sınıfları ve metotları kullanılmayacaktır

        - Sınıfın public bölümünü değiştirmeden istediğiniz eklemeyi yapabilirsiniz

        - Sınıf geçersiz tarih durumunu kontrol edecektir. Geçersizlik durumunda bir mesaj vererek program sonlandırılacaktır

        - Sınıfın DayOfWeek ve Month enum class'larını kullanmaktadır. enum class'ların sabitlerini değiştirmeden istediğiniz
        eklemeyi yapabilirsiniz

        - Sınıfın içerisinde bildirilen metotlarda throw new UnsupportedOperationException("TODO"); biçimindeki deyim
        geri dönüş değeri olan metotlar error vermesin diye yazışmıştır. Bu konu ileride ele alınacaktır. Metodu
        yazarken bu deyimi kaldırınız

        - Daha önce yazılmış olan DateUtil sınıfı içerisinde metotlardan yararlanabilirsiniz. Ancak sınıf DateUtil
        sınıfını kullanmayacaktır

        - Ay bilgisini değer olarak alan veya değer olarak geri döndüren metotlar içinm değer [1, 12] aralığında olacaktır

        - Sınıfa ilişkin test kodlarını da yazınız
-----------------------------------------------------------------------------------------------------------------------*/
/*------------------------------------------------------------------
	FILE		: Date.java
	AUTHOR		: Java-Nov-2022 Group
	LAST UPDATE	: 05.06.2023

	Date class that represents a date

	Copyleft (c) 1993 by C and System Programmers Association
	All Rights Free
------------------------------------------------------------------ */
package org.csystem.homework.solution.datetime;

public class Date {
    private int m_day;
    private int m_month;
    private static final Month [] MONTH_INDEXES = Month.values();
    private static final DayOfWeek [] DAY_OF_WEEK_INDEXES = DayOfWeek.values();
    private int m_year;
    private static boolean isValidDate(int day, int month, int year)
    {
        return 1 <= day && day <= 31 && 1 <= month && month <= 12 && day <= getMonth(month).getDays(year);
    }
    private static boolean isLeapYear(int year)
    {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
    private static Month getMonth(int n)
    {
        return MONTH_INDEXES[n - 1];
    }
    private String getDaySuffix()
    {
        return switch (m_day) {
            case 1, 21, 31 -> "st";
            case 2, 22 -> "nd";
            case 3, 23 -> "rd";
            default -> "th";
        };
    }
    private int getTotalDays()
    {
        int totalDays = 0;

        for (int y = 1900; y < m_year; ++y)
            totalDays += isLeapYear(y) ? 366 : 365;

        return totalDays;
    }
    private int getDayOfYear()
    {
        int totalDays = 0;

        for (int m = m_month - 1; m >= 1; --m)
            totalDays += getMonth(m).getDays(m_year);

        return totalDays + m_day;
    }
    public Date(int day, int monthValue, int year)
    {
        if (!isValidDate(day, monthValue, year)) {
            System.out.println("Invalid Date!");
            System.exit(0);
        }
        m_day = day;
        m_month = monthValue;

        m_year = year;
    }

    public Date(int day, Month month, int year)
    {
        this(day, month.ordinal() + 1, year);
    }
    public int getDay()
    {
        return m_day;
    }

    public void setDay(int day)
    {
        if (!isValidDate(day, m_month, m_year)) {
            System.out.println("Invalid Date!");
            System.exit(0);
        }
        m_day = day;
    }

    public int getMonthValue()
    {
        return m_month;
    }

    public void setMonthValue(int monthValue)
    {
        if (!isValidDate(m_day, monthValue, m_year)) {
            System.out.println("Invalid Date!");
            System.exit(0);
        }
        m_month = monthValue;
    }
    public Month getMonth()
    {
        return getMonth(m_month);
    }
    public void setMonth(Month month)
    {
        m_month = month.getMonth();
    }
    public int getYear()
    {
        return m_year;
    }
    public void setYear(int year)
    {
        if (!isValidDate(m_day, m_month, year)) {
            System.out.println("Invalid Date!");
            System.exit(0);
        }
        m_year = year;
    }
    public DayOfWeek getDayOfWeek()
    {
        return DAY_OF_WEEK_INDEXES[(getTotalDays() + getDayOfYear()) % 7];
    }
    public String getDayOfWeekEN()
    {
        return getDayOfWeek().getDayFullNameEN();
    }
    public String getDayOfWeekTR()
    {
        return getDayOfWeek().getDayFullNameTR();
    }
    public boolean isLeapYear()
    {
        return isLeapYear(m_year);
    }
    public boolean isWeekDay()
    {
        return !isWeekend();
    }
    public boolean isWeekend()
    {
        return getDayOfWeek() == DayOfWeek.SUN || getDayOfWeek() == DayOfWeek.SAT;
    }
    public String toString()
    {
        return toString('/');
    }
    public String toString(char delimiter)
    {
        return String.format("%02d%c%02d%c%04d", m_day, delimiter, m_month, delimiter, m_year);
    }
    public String toLongDateStringTR()
    {
        return String.format("%s %s", toShortDateStringTR(), getDayOfWeekTR());
    }
    public String toLongDateStringEN()
    {
        return String.format("%s %s", toShortDateStringEN(), getDayOfWeekEN());
    }
    public String toShortDateStringTR()
    {
        return String.format("%d %s %d", m_day, getMonth(m_month).getMonthFullNameTR(), m_year);
    }
    public String toShortDateStringEN()
    {
        return String.format("%d%s %s %d", m_day, getDaySuffix(), getMonth(m_month).getMonthFullNameEN(), m_year);
    }
}
