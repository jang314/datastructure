package chapter10;

import chapter09.Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Arrays.stream;

public class HeapSort {
    public static void main(String[] args) {
        stream(heapSort2(3,4,2,1))
                .forEach(arr -> System.out.printf("%d ", arr));
    }

    private static int[] heapSort(Comparator<Integer> comp, int... arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(comp);
        stream(arr).forEach(a -> queue.add(a));
        AtomicInteger i = new AtomicInteger();
        while(!queue.isEmpty()) {
            arr[i.getAndIncrement()] = queue.poll();
        }
        return arr;
    }
    private static int[] heapSort2(int... arr) {
        Comparator<Integer> comp = (o1, o2) -> o2 -o1;
        Heap<Integer> heap = new Heap<>(Integer.class, comp);

        stream(arr).forEach(num -> heap.hInsert(num));

        int idx = 0;
        while(!heap.hIsEmpty()) {
            int num = heap.hDelete(1);
            arr[idx] = num;
            idx++;
        }

        return arr;
    }
}
