package org.example.p_linkedList;

/*
    Reverse A Linked List
    https://leetcode.com/problems/reverse-linked-list/
 */
public class P40_ReverseALinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = null;
        var current = head;

        while (current != null) {
            var temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        return prev;
    }
}
