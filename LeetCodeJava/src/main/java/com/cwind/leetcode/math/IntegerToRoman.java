package com.cwind.leetcode.math;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/7/21
 * Email: billchen01@163.com
 */
public class IntegerToRoman {

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int digit = num / 1000;
        if(digit > 0){
            for(int i=0; i<digit; i++){
                sb.append("M");
            }
        }
        num = num % 1000;
        digit = num / 100;
        if(digit > 0){
            if(digit < 4){
                for(int i=0; i<digit; i++){
                    sb.append("C");
                }
            }else if (digit == 4){
                sb.append("CD");
            }else if (digit < 9){
                sb.append("D");
                for(int i=0; i<digit-5; i++){
                    sb.append("C");
                }
            }else { //digit == 9
                sb.append("CM");
            }
        }
        num = num % 100;
        digit = num / 10;
        if(digit > 0){
            if(digit < 4){
                for(int i=0; i<digit; i++){
                    sb.append("X");
                }
            }else if (digit == 4){
                sb.append("XL");
            }else if (digit < 9){
                sb.append("L");
                for(int i=0; i<digit-5; i++){
                    sb.append("X");
                }
            }else { //digit == 9
                sb.append("XC");
            }
        }
        num = num % 10;
        digit = num;
        if(digit > 0){
            if(digit < 4){
                for(int i=0; i<digit; i++){
                    sb.append("I");
                }
            }else if (digit == 4){
                sb.append("IV");
            }else if (digit < 9){
                sb.append("V");
                for(int i=0; i<digit-5; i++){
                    sb.append("I");
                }
            }else { //digit == 9
                sb.append("IX");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        IntegerToRoman tester = new IntegerToRoman();
        System.out.println(tester.intToRoman(3999));
        System.out.println(tester.intToRoman(19));
    }
}
