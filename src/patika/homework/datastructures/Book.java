package patika.homework.datastructures;

import java.util.Comparator;

public class Book implements Comparable<Book> {
    private String m_name;
    private int totalLetter;

    public Book(String m_name, int totalLetter) {
        this.m_name = m_name;
        this.totalLetter = totalLetter;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public int getTotalLetter() {
        return totalLetter;
    }

    public void setTotalLetter(int totalLetter) {
        this.totalLetter = totalLetter;
    }

    @Override
    public int compareTo(Book b) {
        return this.m_name.toUpperCase().compareTo(b.m_name.toUpperCase());
    }
    @Override
    public String toString()
    {
        return String.format("%s %d sayfa", m_name, totalLetter);
    }
}
