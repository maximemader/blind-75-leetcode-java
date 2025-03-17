package org.example.p_heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
    Top K Frequent Elements
    https://leetcode.com/problems/top-k-frequent-elements/
 */
public class P75_TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        var frequencies = Arrays
                .stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        var heap = new PriorityQueue<Pair>((Pair l, Pair r) ->
                Integer.compare(l.k, r.k));

        for (var frequency : frequencies.entrySet()) {
            heap.add(new Pair(frequency.getKey(), frequency.getValue()));

            if (heap.size() > k)
                heap.poll();
        }

        return heap.stream().mapToInt(Pair::k).toArray();
    }

    record Pair(Integer k, Long v) {
    }
}
