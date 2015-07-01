package com.cwind.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/7/1
 * Email: billchen01@163.com
 * #66 - Easy
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        if(digits == null){
            return null;
        }
        // check if it is all 9
        boolean allNine = true;
        for(int digit : digits){
            if(digit!=9){
                allNine = false;
            }
        }

        if(allNine){
            int result[] = new int[digits.length+1];
            result[0] = 1;
            return result;
        }else {
            for(int i=digits.length-1;i>=0;i--){
                if(digits[i]<9){
                    digits[i]++;
                    break;
                }else{
                    digits[i]=0;

                }
            }
        }
        return digits;
    }

    public static void main(String[] args){
        PlusOne tester = new PlusOne();
        int[] input = {1,2,3,9};
        int[] output = tester.plusOne(input);
        for(int i:output){
            System.out.print(i);
        }
        int[] input2 = {9,9};
        output = tester.plusOne(input2);
        for(int i:output){
            System.out.print(i);
        }
    }
}
