package org.example.p_linkedList;

/*
    Linked List Cycle
    https://leetcode.com/problems/linked-list-cycle/
*/
public class P41_DetectCycleInALinkedList {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        // Floyd's Cycle Detection Algorithm
        var hare = head;
        var tortoise = head;

        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;

            if (hare == tortoise)
                return true;
        }

        return false;
    }
}
