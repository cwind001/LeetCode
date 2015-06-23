package com.cwind.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: wchen
 * Date: 3/24/15
 * Time: 5:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class SingleNumber2 {
    SingleNumber2 tester;
    @Before
    public void setUp(){
        tester = new SingleNumber2();
    }

    @Test
    public void testSingleNumber() {
        int[] intArray = {2,2,2,3,3,3,4,5,5,5,6,6,6};
        assertEquals(tester.singleNumber(intArray), 4);
    }

    public int singleNumber(int[] A) {
        if(A.length==0) {
            return 0;
        }
        int ones=0, twos=0, threes=0;
        for (int i=0;i<A.length;i++){
            twos |= ones & A[i];
            ones = ones ^ A[i];
            threes = ones & twos;
            ones = ones & ~threes;
            twos = twos & ~threes;
        }
        return ones;
    }
}
