package com.alexhades.leetCode.normal;
import org.junit.Test;

import java.util.*;
public class OneSevenOneOne {
    @Test
    public void fn(){
        System.out.println(countPairs(new int[]{1,3,5,7,9}));
    }

    public int countPairs(int[] deliciousness) {
        int MOD = 1000000007;
        int res = 0;
        int maxVal = 0;
        for (int i : deliciousness) {
            maxVal = Math.max(maxVal, i);
        }
        maxVal = maxVal << 1;
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i : deliciousness) {
            for (int j = 1; j <= maxVal; j <<= 1) {
                res = (res + cache.getOrDefault(j - i, 0)) % MOD;
            }
            cache.put(i, cache.getOrDefault(i, 0) + 1);
        }
        return res;
    }
}
