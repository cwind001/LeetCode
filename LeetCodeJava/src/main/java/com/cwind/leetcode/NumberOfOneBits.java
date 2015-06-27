package com.cwind.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: wchen
 * Date: 3/16/15
 * Time: 7:30 PM
 * #191 - Easy
 */
public class NumberOfOneBits {

    NumberOfOneBits tester;

    @Before
    public void setUp(){
        tester = new NumberOfOneBits();
    }

    @Test
    public void testHammingWeight(){
        assertEquals(2, tester.hammingWeight(12));
        assertEquals(1, tester.hammingWeight(32));
        assertEquals(1, tester.hammingWeight(Integer.MAX_VALUE + 1));
    }

    @Test
    public void testHammingWeight2(){
        assertEquals(2, tester.hammingWeight2(12));
        assertEquals(1, tester.hammingWeight2(32));
        assertEquals(1, tester.hammingWeight2(Integer.MAX_VALUE + 1));
    }

    public int hammingWeight(int n) {
        int sum = 0;

        while(n != 0) {
            sum += n & 1;
            n = n >>> 1;
        }
        return sum;
    }

    public int hammingWeight2(int n) {
        int sum = 0;
        while(n != 0) {
            sum += n % 2;
            n = n / 2;
        }
        return sum;
    }

}
