package com.cwind.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/6/28
 * Email: billchen01@163.com
 * #3 - Medium
 */
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1){
            return s.length();
        }
        String temp = s.substring(0,1);
        int maxlength = 1;

        for(int i=1;i<s.length();i++){
            if(!temp.contains(String.valueOf(s.charAt(i)))){
                temp += s.charAt(i);
            }else{
                if(maxlength<temp.length()){
                    maxlength = temp.length();
                }
                temp = temp.substring(temp.indexOf(s.charAt(i))+1) + String.valueOf(s.charAt(i));
            }
        }
        if(maxlength < temp.length()){
            maxlength = temp.length();
        }

        return maxlength;
    }

    public static void main(String[] args){
        LongestSubstring tester = new LongestSubstring();
        System.out.println(tester.lengthOfLongestSubstring("cdd"));
    }
}
