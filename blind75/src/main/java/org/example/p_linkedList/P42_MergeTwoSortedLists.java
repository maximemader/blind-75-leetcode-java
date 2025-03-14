package org.example.p_linkedList;

/*
    Merge Two Sorted Lists
    https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class P42_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;

        if (list2 == null)
            return list1;

        ListNode current;
        if (list1.val < list2.val) {
            current = list1;
            list1 = list1.next;
        } else {
            current = list2;
            list2 = list2.next;
        }

        var head = current;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;
        }

        if (list1 != null)
            current.next = list1;
        else
            current.next = list2;

        return head;
    }
}
