package com.cwind.leetcode.string;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/7/28
 * Email: billchen01@163.com
 * #38 - Easy
 */
public class CountAndSay {

    /**
     * Wrong answer - because of misunderstanding. The problem is not to count the parameter and say it,
     * but to find the nth element in the sequence. "Count and say" itself is a sequence, the nth element is the 'count and say' of (n-1)th element.
     * @param n
     * @return
     */
    private String countAndSayCurNum(String n) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n.length();){
            int count = 1;
            char cur = n.charAt(i);
            if(i==n.length()-1){
                sb.append(count).append(cur);
                break;
            }else {
                i++;
                while(i<n.length()&&n.charAt(i)==cur){
                    count++;
                    i++;
                }

            }
            sb.append(count).append(cur);
        }

        return sb.toString();
    }

    public String countAndSay(int n) {
        if(n<=0){
            return "";
        }
        if(n==1){
            return "1";
        }else {
            return countAndSayCurNum(countAndSay(n-1));
        }
    }

    public static void main(String[] args){
        CountAndSay tester = new CountAndSay();
        System.out.println(tester.countAndSay(1));
        System.out.println(tester.countAndSay(5));
        System.out.println(tester.countAndSay(10));
        System.out.println(tester.countAndSay(11));
    }
}
