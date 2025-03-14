package org.example.p_linkedList;

/*
    Remove Nth Node From End of List
    https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class P44_RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        var node = head;
        var nStepForwardNode = head;

        // We can think of the tortoise and hare approach here
        // but with two tortoises, one of them with a head start
        // of n steps.
        for (var i = 0; i < n; ++i)
            nStepForwardNode = nStepForwardNode.next;

        if (nStepForwardNode == null)
            return head.next;

        while (nStepForwardNode.next != null) {
            nStepForwardNode = nStepForwardNode.next;
            node = node.next;
        }

        node.next = node.next.next;

        return head;
    }
}
