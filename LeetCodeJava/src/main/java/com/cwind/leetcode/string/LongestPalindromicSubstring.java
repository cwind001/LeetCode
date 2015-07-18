package com.cwind.leetcode.string;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/6/29
 * Email: billchen01@163.com
 * #5 - Medium
 */
public class LongestPalindromicSubstring {

    //Dynamic Programming Solution
    public String longestPalindrome(String s){
        if(s.length()<=1){
            return s;
        }

        int start=0, end=0;
        int maxLen = 0;

        boolean[][] plain = new boolean[s.length()][s.length()];
        for(int i=s.length()-1;i>=0;i--){
            for(int j=i;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j)&&(j-i<=2||plain[i+1][j-1])){
                    plain[i][j]=true;
                    if(maxLen<j-i+1){
                        maxLen = j-i+1;
                        start = i;
                        end = j;
                    }
                }
            }
        }

        return s.substring(start, end+1);
    }

    public static void main(String[] args){
        LongestPalindromicSubstring tester = new LongestPalindromicSubstring();
        System.out.println(tester.longestPalindrome("zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez"));
        System.out.println(tester.longestPalindrome("abbac"));
        System.out.println(tester.longestPalindrome("caba"));
    }
}
