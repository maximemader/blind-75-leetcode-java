package org.example.p_heap;

import java.util.PriorityQueue;
import java.util.Queue;

/*
    Find Median From Data Stream
    https://leetcode.com/problems/find-median-from-data-stream/
 */
public class P76_FindMedianFromDataStream {
    private Queue<Long> small = new PriorityQueue<>();
    private Queue<Long> large = new PriorityQueue<>();

    public void addNum(int num) {
        large.add((long) num);
        small.add(-large.poll());

        if (large.size() < small.size())
            large.add(-small.poll());
    }

    public double findMedian() {
        return large.size() > small.size()
                ? large.peek()
                : (large.peek() - small.peek()) / 2.0;
    }
}
