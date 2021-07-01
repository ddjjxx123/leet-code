package com.alexhades.leetCode.normal;

import org.junit.Test;

public class Dp001 {
@Test
    public void  fn1(){
    int i = zeroOneKnapsack(4, 4, new int[]{4,1,2,3}, new int[]{5,2,4,4});

    System.out.println(i);
    }

    public int zeroOneKnapsack(int n, int w, int[] weights, int[] values){
        int[][] res=new int[n+1][w+1];

        for (int i = 1; i <=n ; i++) {
            int weight=weights[i-1];
            int val=values[i-1];
            for (int j = 1; j <=w ; j++) {
                if(j>=weight){
                    res[i][j]=Math.max(res[i-1][j],res[i-1][j-weight]+val);
                }else {
                    res[i][j]=res[i-1][j];
                }
            }
            }
        return  res[n][w];
        }

    }
