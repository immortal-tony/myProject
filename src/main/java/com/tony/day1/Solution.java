package com.tony.day1;

import com.tony.ListNode;

import java.io.Serializable;

public class Solution implements Serializable {
    public ListNode ReverseList(ListNode head) {
        int count = 0;
        ListNode newNode;
        ListNode tempNode = null;
        if (null != head) {
            newNode = new ListNode(head.val);
            while (head.next != null) {
                if (count != 0) {
                    newNode = tempNode;
                }
                tempNode = new ListNode(head.next.val);
                tempNode.next = newNode;
                head = head.next;
                count++;
            }
        } else {
            return null;
        }
        return tempNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode firstNode = new ListNode(1);
        ListNode secondNode = new ListNode(2);
        ListNode thirdNode = new ListNode(3);
        ListNode fourNode = new ListNode(5);
        ListNode fiveNode = new ListNode(7);
        ListNode sixNode = new ListNode(8);
        ListNode sevenNode = new ListNode(9);
        head.next = firstNode;
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourNode;
        fourNode.next = fiveNode;
        fiveNode.next = sixNode;
        sixNode.next = sevenNode;
        Solution solution = new Solution();
        System.out.println(solution.ReverseList(head));
    }
}
