package com.alexhades.leetCode.normal;

import org.junit.Test;

import java.util.*;

public class FourFiveOne {
    @Test
    public void fn(){
        System.out.println(frequencySort("raaeaedere"));

    }
    public String frequencySort(String s) {
        Deque<Map<Character,Integer>> stack=new LinkedList<>();
        if(s.length()<2){
            return s;
        }
        StringBuilder res=new StringBuilder();
        Map<Character,Integer> maps=new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i <chars.length ; i++) {
            int num=maps.getOrDefault(chars[i],0);
            maps.put(chars[i],num+1);
        }
        Deque<Map<Character,Integer> > temp=new LinkedList<>();
        maps.forEach((k,v)->{
            Map<Character, Integer> peek = stack.peek();
            if(peek==null){
                peek=new HashMap<>();
                peek.put(k,v);
                stack.push(peek);
            }else {
                while(peek!=null&&peek.values().iterator().next()>v){
                    Map<Character, Integer> poll = stack.poll();
                    peek=stack.peek();
                    temp.push(poll);
                }
                Map<Character,Integer> newMap=new HashMap<>();
                newMap.put(k,v);
                stack.push(newMap);
                while(!temp.isEmpty()){
                    stack.push(temp.poll());
                }
            }
        });
        while(!stack.isEmpty()){
            stack.poll().forEach((k,v)->{
                for (int i = 0; i < v; i++) {
                    res.append(k);
                }
            });
        }
        return res.toString();
    }
}
