package com.alexhades.leetCode.normal;

import org.junit.Test;

public class NineThreeZero {
    @Test
    public void fn() {
        System.out.println(numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0));
    }


    public int numSubarraysWithSum(int[] nums, int goal) {
        int res = 0;
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            int sum = 0;
            for (int j = i; j < l; j++) {
                sum += nums[j];
                if (sum == goal) {
                    res++;
                } else if (sum > goal) {
                    break;
                }
            }
        }
        return res;
    }
}
