package com.cwind.leetcode.math;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/7/20
 * Email: billchen01@163.com
 * #13 - Easy
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        for(int i=0; i<s.length(); i++){
            if(i<s.length()-1){
                if(map.get(s.charAt(i))<map.get(s.charAt(i+1))){
                    result += map.get(s.charAt(i+1))-map.get(s.charAt(i));
                    i++;
                }else{
                    result += map.get(s.charAt(i));
                }
            }else{
                result += map.get(s.charAt(i));
            }
        }
        return result;
    }

    public static void main(String[] args){
        RomanToInteger tester = new RomanToInteger();
        System.out.println(tester.romanToInt("I"));
        System.out.println(tester.romanToInt("II"));
        System.out.println(tester.romanToInt("III"));
        System.out.println(tester.romanToInt("IV"));
        System.out.println(tester.romanToInt("VI"));
        System.out.println(tester.romanToInt("VII"));
        System.out.println(tester.romanToInt("VIII"));
        System.out.println(tester.romanToInt("IX"));
        System.out.println(tester.romanToInt("X"));
    }
}
