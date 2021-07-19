package com.alexhades.leetCode.normal;

import org.junit.Test;

import java.util.Arrays;


public class OneEightOneEight {

    @Test
    public void fn() {
        System.out.println(minAbsoluteSumDiff(new int[]{1, 7, 5}, new int[]{2, 3, 5}));
    }

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        final int mod = 1000000007;
        int sum = 0;
        int l = nums1.length;
        int[] cache = new int[l];
        System.arraycopy(nums1, 0, cache, 0, l);
        Arrays.sort(cache);
        int maxDif = 0;
        for (int i = 0; i < l; i++) {
            int dif = Math.abs(nums1[i] - nums2[i]);
            sum = (dif + sum) % mod;
            int x = binarySearch(cache, nums2[i]);
            if (x < l) {
                maxDif = Math.max(maxDif, dif - (cache[x] - nums2[i]));
            }
            if (x > 0) {
                maxDif = Math.max(maxDif, dif - (nums2[i] - cache[x - 1]));
            }
        }
        return (sum - maxDif + mod) % (mod);
    }

    private int binarySearch(int[] cache, int i) {
        int s = 0, end = cache.length - 1;
        if (cache[end] < i) {
            return end + 1;
        }
        while (s < end) {
            int mid = (end - s) / 2 + s;
            if (cache[mid] < i) {
                s = mid + 1;
            } else {
                end = mid;
            }
        }

        return s;

    }

}
