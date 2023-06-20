package org.csystem.homework.solution.homework_8;

import org.csystem.util.string.StringUtil;

class StringExamples {
    public String str;

    StringExamples(String s)
    {
        str = s;
    }

    StringExamples()
    {

    }

    public String getStringInCurlyBraces() {

        int temp1 = str.lastIndexOf('{');
        int temp2 = str.indexOf('}');

        if (temp1 != -1 && temp2 != -1)
            return str.substring(temp1 + 1, temp2);

        return "incorrect entry.";
    }

    public void printStringInLine() {

        int len = str.length();
        for (int i = len; i > 0; --i)
            System.out.println(str.substring(0, len - i + 1));

    }

    public String getStringInBracesWithoutWhiteSpaces() {

        return String.format("(%s)", str.trim());
    }

    public static String squeeze(String s1, String s2) {

        String str = "";
        int len = s1.length();
        for (int i = 0; i < len; ++i) {
            if (!s2.contains(s1.charAt(i) + ""))
                str += s1.charAt(i);
        }
        return str;

    }

    public static String changeCase(String str) {

        int len = str.length();
        String s = "";
        for (int i = 0; i < len; ++i) {

            if (Character.isUpperCase(str.charAt(i)))
                s += Character.toLowerCase(str.charAt(i));
            else
                s += Character.toUpperCase(str.charAt(i));
        }

        return s;
    }

    public static boolean isIdentifier(String str) {

        char ch = str.charAt(0);
        int len = str.length();

        if (!Character.isLetter(ch) && ch != '_' && ch != '$')
            return false;

        for (int i = 1; i < len; ++i)
            if (!Character.isLetter(str.charAt(i)) && !Character.isDigit(str.charAt(i)))
                if (str.charAt(i) != '_' && str.charAt(i) != '$')
                    return false;

        return true;
    }

    private static int getLongestPalindromeIndex(String s) {

        var len = s.length();

        for (var i = len; i > 1; --i)
            if (StringUtil.isPalindrome(s.substring(0, i)))
                return i;

        return 0;

    }

    private static int getShortestPalindromeIndex(String s) {

        var len = s.length();

        for (var i = 2; i <= len; ++i)
            if (StringUtil.isPalindrome(s.substring(0, i)))
                return i;

        return 0;

    }

    public static String getLastLongestPalindrome(String s) {

        return getFirstLongestPalindrome(StringUtil.reverse(s));
    }

    public static String getLastShortestPalindrome(String s) {

        return getFirstShortestPalindrome(StringUtil.reverse(s));
    }

    public static String getFirstLongestPalindrome(String s) {

        return s.substring(0, getLongestPalindromeIndex(s));
    }

    public static String getFirstShortestPalindrome(String s) {

        return s.substring(0, getShortestPalindromeIndex(s));
    }

}
