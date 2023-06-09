/*------------------------------------------------------------------
	FILE		: DayOfWeek.java
	AUTHOR		: Java-Nov-2022 Group
	LAST UPDATE	: 05.06.2023

	enum class for day of weeks

	Copyleft (c) 1993 by C and System Programmers Association
	All Rights Free
------------------------------------------------------------------ */
package org.csystem.homework.solution.datetime;

public enum DayOfWeek {
	SUN(7, "Sunday", "Pazar"), MON(1, "Monday", "Pazartesi"), TUE(2, "Tuesday", "Salı"), WED(3, "Wednesday", "Çarşamba"), THU(4, "Thursday", "Perşembe"), FRI(5,"Friday", "Cuma"), SAT(6, "Saturday", "Cumartesi");
	private final int m_day;
	private final String m_dayEN;
	private final String m_dayTR;

	DayOfWeek(int dayVal, String dayEN, String dayTR)
	{
		m_day = dayVal;
		m_dayEN = dayEN;
		m_dayTR = dayTR;
	}
	public String getDayFullNameEN()
	{
		return m_dayEN;
	}
	public String getDayFullNameTR()
	{
		return m_dayTR;
	}
	public int getDayOfWeek()
	{
		return m_day;
	}

}