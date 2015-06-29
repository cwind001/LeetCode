package com.cwind.leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/6/29
 * Email: billchen01@163.com
 * #6 - Easy
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if(s==null){
            return null;
        }
        if(s.length()<=1||numRows==1){
            return s;
        }
        int distance = (numRows-1)*2;

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numRows; i++){
            int j = i;
            boolean oddColumn = true;
            while(j<s.length()){
                sb.append(s.charAt(j));
                if(i==0||i==numRows-1){
                    j+=distance;
                }else {
                    if(oddColumn){
                        j += distance - 2*i;
                    }else {
                        j += 2*i;
                    }
                    oddColumn=!oddColumn;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        ZigZagConversion tester = new ZigZagConversion();
        System.out.println(tester.convert("PAYPALISHIRING", 5));
        System.out.println(tester.convert("PAYPALISHIRING", 4));
        System.out.println(tester.convert("PAYPALISHIRING", 3));
        System.out.println(tester.convert("ABC", 2));
        System.out.println(tester.convert("AB", 1));
    }
}
