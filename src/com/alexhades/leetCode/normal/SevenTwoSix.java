package com.alexhades.leetCode.normal;

import org.junit.Test;

import java.util.*;

public class SevenTwoSix {

    private int i, n;
    private String formula;

    @Test
    public void fn() {
        System.out.println(countOfAtoms("K4(ON(SO3)2)2"));


    }

    public String countOfAtoms(String formula) {
        StringBuilder res = new StringBuilder();
        this.i=0;
        this.n=formula.length();
        this.formula=formula;
        Deque<HashMap<String, Integer>> queue=new LinkedList<>();
        queue.push(new HashMap<>());
        while(i<n){
            char c=formula.charAt(i);
            if(c=='('){
                i++;
                queue.push(new HashMap<>());
            }else if(c==')'){
                i++;
                int num=parseNum();
                HashMap<String, Integer> pop = queue.pop();
                HashMap<String, Integer> peek = queue.peek();
                pop.forEach((k,v)->{
                    peek.put(k,peek.getOrDefault(k,0)+v*num);
                });

            }else {
                String str=parseString();
                int num=parseNum();
                HashMap<String, Integer> peek = queue.peek();
                peek.put(str,peek.getOrDefault(str,0)+num);
            }
        }
        TreeMap<String, Integer> cache=new TreeMap<>(queue.peek()) ;

        cache.forEach((k, v) -> {
            res.append(k);
            if (v > 1) {
                res.append(v);
            }
        });
        return res.toString();
    }

    private String parseString() {
        StringBuilder res=new StringBuilder();
        res.append(formula.charAt(i++));
        while(i<n&&Character.isLowerCase(formula.charAt(i))){
            res.append(formula.charAt(i++));
        }
        return res.toString();
    }

    private int parseNum() {
        if(i==n||!Character.isDigit(formula.charAt(i))){
            return 1;
        }
        int num=0;
        while(i<n&&Character.isDigit(formula.charAt(i))){
            num=num*10+(formula.charAt(i++)-'0');
        }
        return num;
    }

}
