
/*----------------------------------------------------------------------------------------------------------------------
	Sınıf Çalışması: Bir kesri temsil eden Fraction isimli sınıfı aşağıdaki açıklamalara göre yazınız
	Açıklamalar:
	+ Sınıf Matematikteki bir kesri temsil ettiğinden pay (numerator) ve payda (denominator) değerleri tutulacaktır

	+ Sınıfın ilgili set ve get metotları yazılacaktır

	+ Pay'ın sıfırdan farklı, paydanın sıfır olması durumunda tanımsızlığa ilişkin bir mesaj verilecektir, pay ve paydanın
	her ikisinin birden sıfır olması durumunda belirsizliğe ilişkin mesaj verilecektir. Her iki durumda da program
	sonlandırılacaktır

	+ Kesir her durumda sadeleşmiş bir biçimde tutulacaktır. Örneğin kesrin pay ve paydası sırasıyla 4 ve 18 olarak
	verildiğinde kesir 2 / 9 olarak tutulacaktır.

	+ Kesir negatif ise işaret payda bulunacaktır. Örneğin kesrin pay ve paydası sırasıyla 3 ve -4 olarak verilmişse
	kesir -3 / 4 biçiminde tutulacaktır

	+ Kesrin pay ve paydasının ikisinin birden negatif olması durumunda kesir pozitif olarak tutulacaktır

	+ Kesrin payının sıfır olması durumunda payda ne olursa olsun 1(bir) yapılacaktır

	+ Sınıfın iki kesri toplayan, bir kesir ile bir tamsayıyı toplayan metotları olacaktır. Aynı işlemler
	 çıkarma, çarpma ve bölme için de yapılacaktır

	+ Sınıfın kesri 1(bir) artıran ve bir azaltan inc ve dec metotları yazılacaktır

	+ Sınıfın toString metodu şu formatta yazı döndürecektir:
	    3 / 10 kesri için -> 3 / 10 = 3.333333
	    10 / 1 kesri için -> 10

	 + Sınıfın default ctor'u "0 / 1" kesrini temsil eden nesneyi yaratmak için kullanılabilecektir

	 + Sınıfın compareTo metodu iki kesrin büyüklük küçüklük karşılaştırmasını yapacaktır. String sınıfının compareTo
	 metodunun mantığına göre tasarlayınız

	 + Kesrin double türden ondalık değerini döndüren getRealValue metodu yazılacaktır

	 + Sınıfın public bölümünü değiştirmeden istediğiniz değişikliği ve eklemeleri yapabilirsiniz

	 + Sınıfın içerisinde bildirilen metotlarda
            throw new UnsupportedOperationException("TODO");
        biçimindeki deyim geri dönüş değeri olan metotlar error vermesin diye yazışmıştır. Bu konu ileride ele alınacaktır.
        Metodu yazarken bu deyimi kaldırınız
----------------------------------------------------------------------------------------------------------------------*/
/*----------------------------------------------------------------
	FILE		: Fraction.java
	AUTHOR		: Java-Nov-2022 Group
	LAST UPDATE	: 21.05.2023

	Fraction class that represents fraction

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.math;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static org.csystem.util.numeric.NumberUtil.isPrime;

public class Fraction {
    private int m_a;
    private int m_b;
    private static Fraction addEqualedFractions(int num1, int num2, int denominator1, int denominator2)
    {
        int [] multiplier = equalizeDenominators(denominator1, denominator2);
        return new Fraction(num1 * multiplier[0] + num2 * multiplier[1], denominator1 * multiplier[0]);
    }
    private static int [] equalizeDenominators(int denominator1, int denominator2) {

        int equalize = leastCommonMultiple(denominator1, denominator2);
        return new int[] {equalize / denominator1, equalize / denominator2};
    }
    private static int leastCommonMultiple(int val1, int val2)
    {
        int max = max(val1, val2), sum = 1;
        for (int i = 2; i <= max; ++i)
            if (isPrime(i) && val1 % i == 0 || val2 % i == 0)
                sum *= i;

        return sum;
    }
    private void simplifyFraction()
    {
        int min = min(m_a, m_b);

        for (int i = min; i >= 1; --i)
            if (m_a % i == 0 && m_b % i == 0) {
                m_a = m_a / i;
                m_b = m_b / i;
                break;
            }
    }
    public Fraction()
    {
        m_a = 0;
        m_b = 1;
    }

    public Fraction(int a)
    {
        m_a = a;
        m_b = 1;
    }

    public Fraction(int a, int b)
    {

        m_a = a;
        setDenominator(b);
        simplifyFraction();
    }

    public int getNumerator()
    {
        return m_a;
    }

    public void setNumerator(int val)
    {
        m_a = val;
    }

    public int getDenominator()
    {
        return m_b;
    }

    public void setDenominator(int val)
    {
        if (m_a != 0 && val == 0) {
            System.out.println("Undefined fraction!");
            System.exit(0);
        }
        if (m_a == 0 && val == 0) {
            System.out.println("Undetermined fraction!");
            System.exit(0);
        }
        if (val < 0) {
            m_a = -m_a;
            m_b = -val;
            return;
        }

        m_b = m_a == 0 ? 1 : val;
    }

    public double getRealValue()
    {
        return (double)m_a / m_b;
    }

    public Fraction add(Fraction other)
    {
        return addEqualedFractions(m_a, other.m_a, m_b, other.m_b);
    }

    public Fraction add(int val)
    {
        return new Fraction(m_a + m_a * val, m_b);
    }

    public Fraction subtract(Fraction other)
    {
        return addEqualedFractions(m_a, -other.m_a, m_b, other.m_b);
    }

    public Fraction subtract(int val)
    {
        return add(-val);
    }

    public Fraction multiply(Fraction other)
    {
        return new Fraction(m_a * other.m_a, m_b * other.m_b);
    }

    public Fraction multiply(int val)
    {
        return new Fraction(m_a * val, m_b);
    }

    public Fraction divide(Fraction other)
    {
        return new Fraction(m_a * other.m_b, m_b * other.m_a);
    }

    public Fraction divide(int val)
    {
        return new Fraction(m_a, m_b * val);
    }

    public void inc()
    {
        m_a += m_a * m_b;
        simplifyFraction();
    }

    public void dec()
    {
        m_a -= m_a * m_b;
        simplifyFraction();
    }

    public int compareTo(Fraction other)
    {
        int [] compare = equalizeDenominators(m_b, other.m_b);

        return m_a * compare[0] - other.m_a * compare[1];

    }

    public String toString()
    {
        return m_a % m_b == 0 ? String.format("%d / %d = % d", m_a, m_b, (int)getRealValue()) : String.format("%d / %d = % f", m_a, m_b, getRealValue());
    }
}
