package com.alexhades.leetCode.offer;

import org.junit.Test;

public class OfferFifteen {
    @Test
    public void fn(){
        int res = hammingWeight(3);
        System.out.println(res);
    }
    public int hammingWeight(int n) {
     int res=0;
     while(n!=0){
         n&=n-1;
         res++;
     }
        return res;
    }
}
