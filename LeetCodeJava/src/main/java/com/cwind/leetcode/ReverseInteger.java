package com.cwind.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/6/26
 * Email: billchen01@163.com
 * #7 - Easy
 */
public class ReverseInteger {

    public static void main(String[] args){
        ReverseInteger tester = new ReverseInteger();
        System.out.println(tester.reverse(-321));
        System.out.println(tester.reverse(321));
        System.out.println(tester.reverse(0));
        System.out.println(tester.reverse(1534236469));
        System.out.println(tester.reverse(-2147483648));
        System.out.println("Max Integer: " + Integer.MAX_VALUE);
    }

    public int reverse(int x){
        if(x<0&&-x<0){
            return 0;
        }

        boolean isNegative = false;
        if(x<0){
            isNegative = true;
            x = -x;
        }

        int result = x%10;
        x/=10;
        while(x>0){
            result = result*10 + x%10;
            x/=10;
            if(x>0&&result>Integer.MAX_VALUE/10){
                return 0;
            }
        }
        return isNegative?-result:result;
    }
}
