package com.cwind.leetcode.dp;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/7/18
 * Email: billchen01@163.com
 */
public class ClimblingStairs {

    public int climbStairs(int n) {
        if(n==0||n==1||n==2){
            return n;
        }

        int[] ways = new int[n+1];
        ways[0] = 0;
        ways[1] = 1;
        ways[2] = 2;

        for(int i=3; i<=n; i++){
            ways[i] = ways[i-1] + ways[i-2];
        }

        return ways[n];
    }

    public static void main(String[] args) {
        ClimblingStairs tester = new ClimblingStairs();
        System.out.println(tester.climbStairs(3));
        System.out.println(tester.climbStairs(4));
    }
}
