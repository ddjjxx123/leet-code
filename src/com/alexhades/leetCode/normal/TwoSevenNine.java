package com.alexhades.leetCode.normal;

import org.junit.Test;

public class TwoSevenNine {
    @Test
    public void fn1() {
        int res = numSquares(12);
        System.out.println(res);
    }

    public int numSquares(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, res[i - j * j]);
            }
            res[i] = min + 1;
        }

        return res[n];
    }
}
