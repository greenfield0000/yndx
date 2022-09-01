package com.example.yandex.demo.runners;

/**
 * @author Ivanov Roman
 */
public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }

        String result = "";
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                final String s4Check = s.substring(i, j + 1);
                if (isPalyndrome(s4Check)) {
                    if (s4Check.length() > max) {
                        max = s4Check.length();
                        result = s4Check;
                    }
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
        System.out.println(longestPalindrome("a")); // a
        System.out.println(longestPalindrome("abc")); // a
        System.out.println(longestPalindrome("bb")); // a
        System.out.println(longestPalindrome("asdasfafz")); // a
        System.out.println(longestPalindrome("texet")); // a
        System.out.println(longestPalindrome("")); // a
    }

}
