package com.cwind.leetcode.string;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/7/28
 * Email: billchen01@163.com
 * #38 - Easy
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String tmp = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<tmp.length();){
            int count = 1;
            char cur = tmp.charAt(i);
            if(i==tmp.length()-1){
                sb.append(count).append(cur);
                break;
            }else {
                i++;
                while(tmp.charAt(i)==cur&&i<tmp.length()){
                    count++;
                    i++;
                }
            }
            sb.append(count).append(cur);
        }

        return sb.toString();
    }

    public static void main(String[] args){
        CountAndSay tester = new CountAndSay();
        System.out.println(tester.countAndSay(111221));
        System.out.println(tester.countAndSay(11));
    }
}
