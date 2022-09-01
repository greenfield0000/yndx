package com.example.yandex.demo.runners;

/**
 * @author Ivanov Roman
 */
public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        String result = "";
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j < s.length(); j++) {
                final String s4Check = s.substring(i, j);
                if (isPalyndrome(s4Check)) {
                    result = s4Check;
                    max = Math.max(max, s4Check.length());
                }
            }
        }
        return result;
    }

    public static boolean isPalyndrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            --j;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad")); // bab
        System.out.println(longestPalindrome("cbbd")); // bb
    }

}
