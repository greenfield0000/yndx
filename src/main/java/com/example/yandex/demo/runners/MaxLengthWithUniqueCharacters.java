package com.example.yandex.demo.runners;

import java.util.Arrays;
import java.util.List;

/**
 * @author Ivanov Roman
 */
public class MaxLengthWithUniqueCharacters {

    public static int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0) {
            return 0;
        }
        return maxLength(arr, "", 0);
    }

    private static int maxLength(List<String> arr, String path, int idx) {
        if (!isUniqueChars(path)) {
            return 0;
        }
        int maxLength = path.length();
        for (int i = idx; i < arr.size(); i++) {
            if (isUniqueChars(path)) {
                maxLength = Math.max(maxLength, maxLength(arr, path + arr.get(i), i + 1));
            }
        }
        return maxLength;
    }

    private static boolean isUniqueChars(String word) {
        int[] wChar = new int[256];
        for (int i = 0; i < word.length(); i++) {
            char symb = word.charAt(i);
            if (wChar[symb] != 0) {
                return false;
            }
            wChar[symb] += 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(maxLength(Arrays.asList("ab", "ba", "cd", "dc", "ef", "fe", "gh", "hg", "ij", "ji", "kl", "lk", "mn", "nm", "op", "po"))); // 16
        System.out.println(maxLength(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p"))); // 16
        System.out.println(maxLength(Arrays.asList("aa", "bb"))); // 0
        System.out.println(maxLength(Arrays.asList("ab", "ab"))); // 2
        System.out.println(maxLength(Arrays.asList("un", "iq", "ue"))); // 4
        System.out.println(maxLength(Arrays.asList("cha", "r", "act", "ers"))); // 6
    }

}
