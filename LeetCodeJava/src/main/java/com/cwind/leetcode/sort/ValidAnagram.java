package com.cwind.leetcode.sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/8/8
 * Email: billchen01@163.com
 * #242 - Easy
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if(s==null||t==null||s.length()!=t.length()){
            return false;
        }
        char[] array1 = s.toCharArray();
        char[] array2 = t.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);

        return Arrays.equals(array1, array2);
    }

    public static void main(String[] args) {
        ValidAnagram tester = new ValidAnagram();
        System.out.println(tester.isAnagram("abc", "cab"));
        System.out.println(tester.isAnagram("anagram", "nagaram"));
        System.out.println(tester.isAnagram("rat", "car"));
    }
}
