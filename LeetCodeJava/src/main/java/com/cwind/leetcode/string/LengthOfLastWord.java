package com.cwind.leetcode.string;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/7/28
 * Email: billchen01@163.com
 * #58 - Easy
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        s=s.trim();
        return s.substring(s.lastIndexOf(' ')+1).length();
    }

    public static void main(String[] args) {
        LengthOfLastWord tester = new LengthOfLastWord();
        System.out.println(tester.lengthOfLastWord("Hello World"));
        System.out.println(tester.lengthOfLastWord("abc  "));
    }
}
