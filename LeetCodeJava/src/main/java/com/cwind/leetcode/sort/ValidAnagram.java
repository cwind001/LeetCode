package com.cwind.leetcode.sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Cwind
 * Date: 2015/8/8
 * Email: billchen01@163.com
 * #242 - Easy
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if(s==null||t==null||s.length()!=t.length()){
            return false;
        }
        char[] array1 = s.toCharArray();
        char[] array2 = t.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);

//        bubbleSort(array1);
//        bubbleSort(array2);

//        quickSort(array1,0,array1.length-1);
//        quickSort(array2,0,array2.length-1);

        return Arrays.equals(array1, array2);
    }

    /**
     * bubbleSort
     * @param array
     */
    public void bubbleSort(char[] array) {
        for(int i=0; i<array.length-1; i++){
            for(int j=0; j<array.length-i-1; j++){
                if(array[j]>array[j+1]){
                    char temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    /**
     * quickSort
     * @param array
     * @param low
     * @param high
     */
    public void quickSort(char[] array, int low, int high) {
        if(low>=high){
            return;
        }

        char paviot = array[low];
        int l = low+1, h = high;
        while(l<h){
            while(array[h]>=paviot && l<h){
                h--;
            }
            while(array[l]<=paviot && l<h){
                l++;
            }
            if(l<h){
                char tmp = array[l];
                array[l] = array[h];
                array[h] = tmp;
            }
        }
        if(array[low]>array[l]){
            array[low] = array[l];
            array[l] = paviot;
        }
        quickSort(array, low, l-1);
        quickSort(array, l+1, high);

    }

    public static void main(String[] args) {
        ValidAnagram tester = new ValidAnagram();
        System.out.println(tester.isAnagram("abc", "cab"));
        System.out.println(tester.isAnagram("anagram", "nagaram"));
        System.out.println(tester.isAnagram("rat", "car"));
    }
}
