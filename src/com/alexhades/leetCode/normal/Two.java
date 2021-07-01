package com.alexhades.leetCode.normal;

import com.alexhades.leetCode.base.ListNode;
import org.junit.Test;

public class Two {
    @Test
    public void fn() {
        ListNode res = addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3)))

                ,
                new ListNode(5, new ListNode(6, new ListNode(4))));
        System.out.println(res);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, temp = null;
        int add = 0;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int sum = a + b + add;
            if (head == null) {
                head = temp = new ListNode(sum % 10);
            } else {
                temp.next = new ListNode(sum % 10);
                temp = temp.next;
            }
            add = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

        }
        if (add > 0) {
            temp.next = new ListNode(add);
        }
        return head;
    }
}
