package com.alexhades.leetCode.normal;

import org.junit.Test;

public class EightSevenSeven {

    @Test
    public void fn1(){
        String s=";";
        boolean res = stoneGame(new int[]{5,3,4,5});
        System.out.println(res);

    }

    public boolean stoneGame(int[] piles) {
        int l=piles.length-1;
        int[][] res=new int[l][l];
        for (int i = 0; i < l; i++) {
            res[i][i]=piles[i];
        }
        for (int i = 0; i < l; i++) {

        }

        return res[0][l-1]>0;
    }

    public void dfs(int a,int l,int s,int e,int[] pi){
        if(s>=e){
            return;
        }
    }
}
