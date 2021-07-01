package com.alexhades.leetCode.normal;

import org.junit.Test;

import java.util.*;

public class SevenFiveTwo {
    @Test
    public void fn() {
        System.out.println(openLock(new String[]{
                "8888"
        }, "0009"));
    }

    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) {
            return 0;
        }
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        if (deadSet.contains("0000")||deadSet.contains(target)) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>(Collections.singletonList("0000"));
        Set<String> lastSet = new HashSet<>(Arrays.asList("0000"));
        int step = 0;



        while (!queue.isEmpty()) {
            step++;
            int s=queue.size();
            for (int i = 0; i < s; i++) {
                String current = queue.poll();
                for (String next : getNext(current)) {
                    if (!lastSet.contains(next) && !deadSet.contains(next)) {
                        if (next.equals(target)) {
                            return step;
                        }
                        lastSet.add(next);
                        queue.offer(next);
                    }

                }
            }

        }
        return -1;
    }

    public List<String> getNext(String current) {
        List<String> res = new ArrayList<>();
        char[] chars = current.toCharArray();
        for (int i = 0; i < 4; i++) {
            char num = chars[i];
            chars[i] = next(num);
            res.add(new String(chars));
            chars[i] = pre(num);
            res.add(new String(chars));
            chars[i] = num;
        }
        return res;
    }

    public char pre(char n) {
        return n == '0' ? '9' : (char) (n - 1);
    }

    public char next(char n) {
        return n == '9' ? '0' : (char) (n + 1);
    }
}
