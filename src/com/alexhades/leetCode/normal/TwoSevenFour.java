package com.alexhades.leetCode.normal;

import org.junit.Test;

import java.util.Arrays;

public class TwoSevenFour {
    @Test
    public void fn(){
        System.out.println(hIndex(new int[]{1,3,1}));
    }

    public int hIndex(int[] citations) {
        int l=citations.length;
        Arrays.sort(citations);
        if(citations[l-1]==0){
            return 0;
        }
        int left=0;
        int right=l-1;
        while(right>left){
            int mid= (right+left)/2;
            if(citations[mid]< (l-mid)){
                left=mid+1;
            }else {
                right=mid;
            }
        }
        return l-left;
    }


}
