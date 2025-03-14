package org.example.p_linkedList;

/*
    Reorder List
    https://leetcode.com/problems/reorder-list/
 */
public class P45_ReorderList {
    public void reorderList(ListNode head) {
        // 1. Break the list into two halves at the middle node
        var secondHalfHead = BreakTheListIntoTwoHalvesAtMiddleNode(head);

        // 2. Reverse the second half of the list
        var reversedSecondHalfHead = ReverseList(secondHalfHead);

        // 3. Merge the two halves
        MergeTwoHalves(head, reversedSecondHalfHead);
    }

    private static ListNode BreakTheListIntoTwoHalvesAtMiddleNode(ListNode head) {
        var tortoise = head;
        var hare = head;

        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
        }

        var middleOfTheList = tortoise;
        var secondHalfHead = middleOfTheList.next;
        middleOfTheList.next = null;
        return secondHalfHead;
    }

    private void MergeTwoHalves(ListNode first, ListNode second) {
        while (second != null) {
            var firstNext = first.next;
            var secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }
    }

    // We can reuse P40_ReverseALinkedList.java
    private ListNode ReverseList(ListNode head) {
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
