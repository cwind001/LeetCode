package com.cwind.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: wchen
 * Date: 3/17/15
 * Time: 1:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class SingleNumber {

    SingleNumber tester;
    @Before
    public void setUp(){
        tester = new SingleNumber();
    }

    @Test
    public void testSingleNumber() {
        int[] intArray = {2,2,3,3,4,5,5,6,6};
        assertEquals(tester.singleNumber(intArray), 4);
    }

    public int singleNumber(int[] A) {
        if(A.length==0) {
            return 0;
        }
        int singleNum = A[0];
        for(int i=1; i<A.length; i++) {
            singleNum = singleNum ^ A[i];
        }
        return singleNum;
    }
}
