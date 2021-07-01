package com.alexhades.leetCode.normal;

import org.junit.Test;

public class EightFiveTwo {
    @Test
    public void fn1() {
        int res = peakIndexInMountainArray(new int[]{0, 10, 5, 2});
        System.out.println(res);
    }

    public int peakIndexInMountainArray(int[] arr) {
        int l = 1;
        int r = arr.length - 1;


        while (r > l) {
            int m = (r + l + 1) / 2;

            if (arr[m] > arr[m - 1]) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return r;
    }
}
