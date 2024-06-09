package chapter10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class HeapSort {
    public static void main(String[] args) {
        Arrays.stream(heapSort((o1, o2) -> o1-o2, 3,4,2,1))
                .forEach(h -> System.out.printf("%d ", h));
    }

    private static int[] heapSort(Comparator<Integer> comp, int... arr) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(comp);
        Arrays.stream(arr).forEach(a -> queue.add(a));
        AtomicInteger i = new AtomicInteger();
        while(!queue.isEmpty()) {
            arr[i.getAndIncrement()] = queue.poll();
        }
        return arr;
    }
}
