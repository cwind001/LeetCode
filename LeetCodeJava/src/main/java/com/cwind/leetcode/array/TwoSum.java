package com.cwind.leetcode.array;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/6/27
 * Email: billchen01@163.com
 * #1 - Medium
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=1; i<=nums.length-1; i++){
            for(int j=i+1; j<=nums.length;j++){
                if(nums[i-1]+nums[j-1]==target){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        TwoSum tester = new TwoSum();
        int[] indexes = tester.twoSum(nums, target);
        System.out.println("index1="+indexes[0]+", index2="+indexes[1]);
        int[] nums2 = {3, 2, 4};
        target = 6;
        indexes = tester.twoSum(nums2, target);
        System.out.println("index1="+indexes[0]+", index2="+indexes[1]);
    }
}
