package com.cwind.leetcode.string;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/7/23
 * Email: billchen01@163.com
 * #14 - Easy
 */
public class LongestCommonString {

    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0){
            return "";
        }
        int sLen = strs[0].length();
        for(int i=1; i<strs.length; i++){
            if(strs[i].length()<sLen){
                sLen = strs[i].length();
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<sLen; i++){
            boolean prefix = true;
            char cur = strs[0].charAt(i);
            for(int j=1; j<strs.length; j++){
                if(cur!=strs[j].charAt(i)){
                    prefix = false;
                    break;
                }
            }
            if(prefix){
                sb.append(cur);
            }else {
                break;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        LongestCommonString tester = new LongestCommonString();
        String[] strings = {"abc", "abcd", "abce"};
        System.out.println(tester.longestCommonPrefix(strings));
    }
}
