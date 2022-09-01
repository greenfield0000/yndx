package com.example.yandex.demo.runners;

import java.util.Arrays;
import java.util.List;

/**
 * @author Ivanov Roman
 */
public class SmallestStringWithSwaps {

    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        return smallestStringWithSwaps(s, pairs, 0);
    }

    private static String smallestStringWithSwaps(String result, List<List<Integer>> pairs, int index) {
        System.out.println(result);
        if (isLexical(result.toCharArray())) {
            return result;
        }

        for (int i = index; i < pairs.size(); i++) {
            final List<Integer> pair = pairs.get(i);
            smallestStringWithSwaps(String.valueOf(swap(result.toCharArray(), pair.get(0), pair.get(1))), pairs, index + 1);
        }

        return result;
    }

    public static boolean isLexical(char[] str) {
        for (int i = 0; i < str.length; i++) {
            if (str[i] > str[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static char[] swap(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;

        return c;
    }

    public static void main(String[] args) {
        System.out.println(smallestStringWithSwaps("dcab", Arrays.asList(Arrays.asList(0, 3), Arrays.asList(1, 2)))); // bacd
        System.out.println(smallestStringWithSwaps("dcab", Arrays.asList(Arrays.asList(0, 3), Arrays.asList(1, 2), Arrays.asList(0, 2)))); // abcd
    }


}
