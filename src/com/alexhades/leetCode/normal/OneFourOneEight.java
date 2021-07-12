package com.alexhades.leetCode.normal;

import org.junit.Test;

import java.util.*;

public class OneFourOneEight {
    @Test
    public void fn() {
        List<List<String>> in=new ArrayList<>();
        in.add(Arrays.asList("David","3","Ceviche"));
        in.add(Arrays.asList("Corina","10","Beef Burrito"));
        in.add(Arrays.asList("David","3","Fried Chicken"));
        in.add(Arrays.asList("Carla","5","Water"));
        in.add(Arrays.asList("Carla","5","Ceviche"));
        in.add(Arrays.asList("Rous","3","Ceviche"));
        List<List<String>> out=displayTable(in);
        out.forEach(l->{
            l.forEach(s-> System.out.print(s+" , "));
            System.out.println();
        });

    }

    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> res = new ArrayList<>();
        TreeMap<String, TreeMap<Integer, Integer>> tables = new TreeMap<>();
        TreeSet<Integer> tableNum = new TreeSet<>();
        for (List<String> list : orders) {
            Integer tNum = Integer.valueOf(list.get(1));
            tableNum.add(tNum);
            TreeMap<Integer, Integer> nums = tables.getOrDefault(list.get(2), new TreeMap<>());
            nums.put(tNum, nums.getOrDefault(tNum, 0) + 1);
            tables.put(list.get(2), nums);
        }
        List<String> tab = new ArrayList<>();
        tab.add("Table");
        res.add(tab);
        tableNum.forEach(num -> {
            List<String> temp = new ArrayList<>();
            temp.add(String.valueOf(num));
            res.add(temp);
        });
        tables.forEach((name, nums) -> {
            res.get(0).add(name);
            for (int i = 1; i < res.size(); i++) {
                List<String> tableMenu = res.get(i);
                tableMenu.add(String.valueOf(nums.getOrDefault(Integer.valueOf(tableMenu.get(0)), 0)));
            }
        });
        return res;
    }
}
