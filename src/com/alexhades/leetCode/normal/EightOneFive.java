package com.alexhades.leetCode.normal;

import org.junit.Test;

import java.util.*;

public class EightOneFive {

    @Test
    public void fn() {
        System.out.println(numBusesToDestination(new int[][]{
                {0,1,6,16,22,23},{14,15,24,32},{4,10,12,20,24,28,33},{1,10,11,19,27,33},{11,23,25,28},{15,20,21,23,29},{29}


        },4,21));
    }

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        List<List<Integer>> lineList = new ArrayList<>();
        int l = routes.length;
        for (int i = 0; i < l; i++) {
            lineList.add(new ArrayList<>());
        }
        //将线路交差放入一个线路中
        for (int i = 0; i < l - 1; i++) {
            for (int j = i + 1; j < l; j++) {
                if (func(routes[i], routes[j])) {
                    //i 与 j 线路相交，则 放入对方线路
                    lineList.get(i).add(j);
                    lineList.get(j).add(i);
                }
            }
        }
        Set<Integer> startSet=new HashSet<>();
        Set<Integer> endSet=new HashSet<>();
        Queue<LineTime> queue=new LinkedList<>();
        //找到所有线路中的起点重点
        for (int i = 0; i <l ; i++) {
            if(Arrays.binarySearch(routes[i],source)>=0){
                startSet.add(i);
                queue.offer(new LineTime(i,0));
            }
            if(Arrays.binarySearch(routes[i],target)>=0){
                endSet.add(i);
            }
        }
        while(!queue.isEmpty()){
            LineTime current = queue.poll();
            //当前线处理
            int line = current.line;
            int times = current.times;
            if(endSet.contains(line)){
                return ++times;
            }
            //需要换成的线路
            for (Integer li:lineList.get(line)) {
                if(!startSet.contains(li)){
                    startSet.add(li);
                    queue.offer(new LineTime(li,times+1));
                }
            }

        }


        return -1;
    }

    public boolean func(int[] a, int[] b) {
        int la = 0;
        int lb = 0;
        while (la < a.length && lb < b.length) {
            if (a[la] == b[lb]) {
                return true;
            }
            if(a[la]>b[lb]){
                lb++;
            }else {
                la++;
            }
        }

        return false;
    }
}

 class LineTime {
    int line;
    int times;

    public LineTime(int line, int times) {
        this.line = line;
        this.times = times;
    }
}

