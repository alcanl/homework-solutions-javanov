/*------------------------------------------------------------------
	FILE		: Month.java
	AUTHOR		: Java-Nov-2022 Group
	LAST UPDATE	: 05.06.2023

	enum class for months

	Copyleft (c) 1993 by C and System Programmers Association
	All Rights Free
------------------------------------------------------------------ */
package org.csystem.homework.solution.datetime;

public enum Month {
	JAN(31, "January", "Ocak"), FEB(28, "February", "Şubat"), MAR(31, "March", "Mart"), APR(30, "April", "Nisan"), MAY(31, "May", "Mayıs"), JUN(30, "June","Haziran"), JUL(31, "July", "Temmuz"), AUG(31,"August", "Ağustos"), SEP(30, "September", "Eylül"), OCT(31, "October", "Ekim"), NOV(30, "November","Kasım"), DEC(31, "December", "Aralık");
	private final int m_days;
	private final String m_monthEN;
	private final String m_monthTR;

	Month(int days, String monthEN, String monthTR)
	{
		m_days = days;
		m_monthEN = monthEN;
		m_monthTR = monthTR;
	}
	public static boolean isLeapYear(int year)
	{
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}
	public String getMonthFullNameEN()
	{
		return m_monthEN;
	}
	public String getMonthFullNameTR()
	{
		return m_monthTR;
	}
	public int getDays(int year)
	{
		return ordinal() == 1 && isLeapYear(year) ? 29 : m_days;
	}
	public int getMonth()
	{
		return ordinal() + 1;
	}
}