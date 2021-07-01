package com.alexhades.leetCode.lcp;

import org.junit.Test;

import java.util.Arrays;

public class LCPSeven {
    @Test
    public void fn() {
        System.out.println(numWays(5,
                new int[][]{{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}},
                3));
    }
    public int numWaysDp(int n, int[][] relation, int k) {
        //经过 I轮 到达J 的有几种方式
        int[][] dp=new int[k+1][n];
//        dp[0][0]=1;
        dp[0][0]=1;
        for (int i = 0; i < k; i++) {
            for (int[] real:relation) {
                int src=real[0];
                int dst=real[1];
                dp[i+1][dst]+=dp[i][src];
            }
        }
        return dp[k][n-1];
    }


    public int numWays(int n, int[][] relation, int k) {
        //经过 I轮 到达J 的有几种方式
//        int[][] dp=new int[k+1][n];
        int[] dp=new int[n];
//        dp[0][0]=1;
        dp[0]=1;
        for (int i = 0; i < k; i++) {
            int[] temp=new int[n];
            for (int[] real:relation) {
                int src=real[0];
                int dst=real[1];
                temp[dst]+=dp[src];
            }
            dp=temp;
        }
        return dp[n-1];
    }



}
