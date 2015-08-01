package com.cwind.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/7/5
 * Email: billchen01@163.com
 * #217 - Easy
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> uniqueSet = new HashSet<Integer>();

        for(int i=0; i<nums.length; i++){
            if(uniqueSet.contains(nums[i])){
                return true;
            }else {
                uniqueSet.add(nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args){
        ContainsDuplicate tester = new ContainsDuplicate();
        int[] nums = {1,3};
        System.out.println(tester.containsDuplicate(nums));
    }
}
