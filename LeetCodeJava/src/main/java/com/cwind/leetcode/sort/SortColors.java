package com.cwind.leetcode.sort;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/8/12
 * Email: billchen01@163.com
 * #75 - Medium
 */
public class SortColors {

    //Counting sort, 2-pass
    public void sortColors(int[] nums){
        int red=0, white=0, blue=0;
        for(int i=0;i<nums.length;i++){
            switch (nums[i]){
                case 0:
                    red++;
                    break;
                case 1:
                    white++;
                    break;
                case 2:
                    blue++;
                    break;
            }
        }
        for(int i=0;i<red;i++){
            nums[i]=0;
        }
        for(int i=red;i<red+white;i++){
            nums[i]=1;
        }
        for (int i=red+white;i<nums.length;i++){
            nums[i]=2;
        }
    }

    //1-pass, with two pointers
    public void sortColors1pass(int[] nums){
        int p1=0, p2=nums.length-1, cur=0;
        while (cur<=p2){
            if(nums[cur]==0){
                nums[cur]=nums[p1];
                nums[p1]=0;
                p1++;
            }
            if(nums[cur]==2){
                nums[cur]=nums[p2];
                nums[p2]=2;
                p2--;
                cur--;
            }
            cur++;
        }
    }

    public void printColors(int[] nums){
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {0,2,1,0,0,1,2,2,2,2,1};
        SortColors tester = new SortColors();
        System.out.println("--- Before sorting ---");
        tester.printColors(nums);
//        tester.sortColors(nums);
        tester.sortColors1pass(nums);
        System.out.println("--- After sorting ---");
        tester.printColors(nums);

        int[] nums2 = {1,2,0};
        tester.printColors(nums2);
        tester.sortColors1pass(nums2);
        tester.printColors(nums2);
    }
}
