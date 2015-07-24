package com.cwind.leetcode.dp;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/7/24
 * Email: billchen01@163.com
 * #198 - Easy
 */
public class HouseRobber {
    public int rob(int[] nums){
        if(nums==null||nums.length==0){
            return 0;
        }
        int[] maxMoney = new int[nums.length+1];
        maxMoney[nums.length] = 0;
        maxMoney[nums.length-1] = nums[nums.length-1];
        for(int i=nums.length-2; i>=0; i--){
            maxMoney[i]=(nums[i]+maxMoney[i+2]>maxMoney[i+1])?(nums[i]+maxMoney[i+2]):maxMoney[i+1];
        }
        return maxMoney[0];
    }

    public static void main(String[] args){
        int[] nums = {3, 4, 6, 7, 1, 9};
        HouseRobber tester = new HouseRobber();
        System.out.println(tester.rob(nums));
    }
}
