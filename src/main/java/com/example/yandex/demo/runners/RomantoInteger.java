package com.example.yandex.demo.runners;

import java.util.HashMap;

/**
 * @author Ivanov Roman
 */
public class RomantoInteger {

    static int value(char r) {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return -1;
    }


    // III
    public static int romanToInt(String s) {
//        int res = 0;
//        int n = s.length();
//        for (int i = 0; i < n; i++) {
//            int curVal = value(s.charAt(i));
//
//            if (i + 1 < n) {
//                int nextVal = value(s.charAt(i + 1));
//                if (curVal >= nextVal) {
//                    res = res + curVal;
//                } else {
//                    res = res + nextVal - curVal;
//                    i++;
//                }
//            } else {
//                res += curVal;
//            }
//        }
//
//        return res;
        if (s == null || s.length() == 0)
            return -1;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int len = s.length(), result = map.get(s.charAt(len - 1));
        for (int i = len - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1)))
                result += map.get(s.charAt(i));
            else
                result -= map.get(s.charAt(i));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));      //        3
        System.out.println(romanToInt("LVIII"));    //        58
        System.out.println(romanToInt("MCMXCIV"));  //        1994
    }

}
