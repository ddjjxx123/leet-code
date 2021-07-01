package com.alexhades.leetCode.normal;

import org.junit.Test;

import java.util.Arrays;

public class OneZeroFourNine {

    @Test
    public  void main() {
        System.out.println(lastStoneWeightII(new int[]{31,26,33,21,40}));
    }
    public int lastStoneWeightII(int[] stones) {
        if(stones.length==1){
            return stones[0];
        }
        Arrays.sort(stones);
        int[] res=new int[(stones.length+1)/2];
        for (int i = stones.length-1; i >=0 ; i-=2) {
            if(i==0){
                res[i]=stones[i];
            }else {
                res[i/2]= stones[i]-stones[i-1];
            }

        }
        print(res);
        return lastStoneWeightII(res);
    }

    public void print(int[] s){
        for (int i:
             s) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
