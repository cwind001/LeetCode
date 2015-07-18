package com.cwind.leetcode.string;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 7/4/15
 * Time: 10:25 AM
 * Email: billchen01@163.com
 * #8 - Easy
 */
public class StringToInteger {
    public int myAtoi(String str) {
        if(str==null){
            return 0;
        }
        if(str.equals("")){
            return 0;
        }
        str = str.trim();
        int result = 1;
        int sign = 1;
        if(str.charAt(0)=='-'||str.charAt(0)=='+'){
            sign = str.charAt(0)=='-'?-1:1;
            str = str.substring(1);
        }

        for(int i=0;i<str.length();i++){
            if(i==0){
                result = str.charAt(i) - 48;
                if(result<0||result>9){
                    return 0;
                }
                continue;
            }
            int num = str.charAt(i) - 48;
            if(num < 0 || num > 9){
                break;
            }
            result *= 10;
            result += num;
            if(i>=10||result<0){
                if(sign>0){
                    return Integer.MAX_VALUE;
                }else {
                    return Integer.MIN_VALUE;
                }
            }
        }

        return result*sign;
    }

    public static void main(String[] args) {
        StringToInteger tester = new StringToInteger();
        System.out.println(tester.myAtoi("-123"));
        System.out.println(tester.myAtoi("+-123"));
        System.out.println(tester.myAtoi("    010"));
        System.out.println(tester.myAtoi("  -0012a42"));
        System.out.println(tester.myAtoi("2147483648"));
        System.out.println(tester.myAtoi("    10522545459"));

        System.out.println("Max integer= " + Integer.MAX_VALUE);
        System.out.println("Min integer= " + Integer.MIN_VALUE);
    }
}
