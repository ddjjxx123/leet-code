package com.alexhades.leetCode.base;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return val + (next != null ? "," + next.toString() : "");
    }

    public static void main(String[] args) {
        System.out.println(0.0==-0.0);
    }
}