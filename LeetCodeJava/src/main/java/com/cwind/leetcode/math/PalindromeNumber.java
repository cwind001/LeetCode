package com.cwind.leetcode.math;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: wchen
 * Date: 3/18/15
 * Time: 2:45 PM
 * #9 - Easy
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int originNum = x;
        int num = x % 10;
        x = x / 10;
        while(x != 0){
            num *= 10;
            num += x%10;
            x /= 10;
        }
        return num==originNum;
    }

    PalindromeNumber tester;

    @Before
    public void setUp(){
        tester = new PalindromeNumber();
    }

    @Test
    public void testIsPalindrome(){
        assertFalse(tester.isPalindrome(-2147447412));
        assertTrue(tester.isPalindrome(1000000001));

    }
}
