package com.alexhades.leetCode.normal;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class OneFourNine {

    @Test
    public void fn(){
        System.out.println(maxPoints(new int[][]{
                {0,1},{0,0},{0,4},{0,-2},{0,-1},{0,3},{0,-4}
        }));
    }

    public int maxPoints(int[][] points) {

        int l = points.length;
        if(l<3){
            return l;
        }
        int maxNum=0;

        for (int i = 0; i < l; i++) {
            Map<Double,Integer> cache=new HashMap<>();
            for (int j = i+1; j <l ; j++) {
                int dx=points[i][0]-points[j][0];
                int dy=points[i][1]-points[j][1];
                double x=1.0*dy/dx;
                System.out.println(x);
                if(x==0.0){
                    x=0;
                }
                if (cache.containsKey(x)) {
                    cache.put(x, cache.get(x)+1);
                }else {
                    cache.put(x,2);
                }
                maxNum=Math.max(maxNum,cache.get(x));
            }
        }
        return maxNum;
    }
}
