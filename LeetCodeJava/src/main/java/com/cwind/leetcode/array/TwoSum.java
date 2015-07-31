package com.cwind.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/6/27
 * Email: billchen01@163.com
 * #1 - Medium
 */
public class TwoSum {

    /**
     * This is very straight forward. Go through the array twice and will surely find the answer.
     * Time complexity: O(n2)
     * @param nums
     * @param target
     * @return
     */
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

    /**
     * Time complexity: O(n), Space complexity: O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Map map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], i+1);
        }

        for(int i=1; i<=nums.length; i++){
            if(map.containsKey(target-nums[i-1])&&((Integer)map.get(target-nums[i-1])>i)){
                return new int[] {i, (Integer)map.get(target-nums[i-1])};
            }
        }

        return new int[0];
    }

    public static void main(String[] args){
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        TwoSum tester = new TwoSum();
        int[] indexes = tester.twoSum2(nums, target);
        System.out.println("index1="+indexes[0]+", index2="+indexes[1]);
        int[] nums2 = {3, 2, 4};
        target = 6;
        indexes = tester.twoSum2(nums2, target);
        System.out.println("index1="+indexes[0]+", index2="+indexes[1]);
        int[] nums3 = {0, 4, 3, 0};
        target = 0;
        indexes = tester.twoSum2(nums3, target);
        System.out.println("index1="+indexes[0]+", index2="+indexes[1]);
    }
}
