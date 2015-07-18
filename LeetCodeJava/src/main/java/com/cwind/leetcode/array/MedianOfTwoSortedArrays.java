package com.cwind.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/6/28
 * Email: billchen01@163.com
 * #4 - Hard
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if((nums1.length == 0) && (nums2.length==0)){
            return 0;
        }
        List<Double> list = new ArrayList<Double>();
        if(nums1.length==0){
            for(int i=0;i<nums2.length;i++){
                list.add((double) nums2[i]);
            }
        }else if(nums2.length==0){
            for(int i=0;i<nums1.length;i++){
                list.add((double) nums1[i]);
            }
        }else{
            int i=0, j=0;
            for( ; i<nums1.length&&j<nums2.length ;){
                if(nums1[i]<nums2[j]){
                    list.add((double) nums1[i]);
                    i++;
                }else {
                    list.add((double) nums2[j]);
                    j++;
                }
            }
            if(i<nums1.length){
                for(;i<nums1.length;i++){
                    list.add((double) nums1[i]);
                }
            }else {
                for(;j<nums2.length;j++){
                    list.add((double) nums2[j]);
                }
            }
        }
        double result = 0;
        if(list.size()==1){
            result = list.get(0);
        }else if(list.size()%2==0){
            result = (list.get(list.size()/2-1) + list.get(list.size()/2))/2;
        }else {
            result = list.get(list.size()/2);
        }

        return result;
    }

    public static void main(String[] args){
        MedianOfTwoSortedArrays tester = new MedianOfTwoSortedArrays();
        int[] nums1 = {};
        int[] nums2 = {1,2,3,4,5};
        System.out.println(tester.findMedianSortedArrays(nums1, nums2));
    }
}
