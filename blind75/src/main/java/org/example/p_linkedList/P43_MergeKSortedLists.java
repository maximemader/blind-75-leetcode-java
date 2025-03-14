package org.example.p_linkedList;

/*
    Merge K Sorted Lists
    https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class P43_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;

        // Divide & conquer approach
        return DivideAndConquer(lists, 0, lists.length - 1);
    }

    private ListNode DivideAndConquer(ListNode[] lists, int start, int end) {
        if (start == end)
            return lists[start];

        if (start > end)
            return null;

        var mid = start + (end - start) / 2;
        var left = DivideAndConquer(lists, start, mid);
        var right = DivideAndConquer(lists, mid + 1, end);

        return MergeTwoLists(left, right);
    }

    // We can reuse P42_MergeTwoSortedLists.cs
    private ListNode MergeTwoLists(ListNode list1, ListNode list2) {
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
