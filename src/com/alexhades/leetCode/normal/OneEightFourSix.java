package com.alexhades.leetCode.normal;

import org.junit.Test;

import java.util.Arrays;

public class OneEightFourSix {

    @Test
    public void fn(){
        System.out.println(maximumElementAfterDecrementingAndRearranging(new int []{
                1,100,1000
        }));
    }
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        if(arr.length==1){
            return 1;
        }
        Arrays.sort(arr);
        arr[0]=1;
        int last=arr[0];
        for (int i = 1; i < arr.length; i++) {
            int dif=Math.abs(arr[i]-last);
                if(dif>1){
                    arr[i]=last+1;
                }
            last=arr[i];
        }
        return arr[arr.length-1];
    }
}
