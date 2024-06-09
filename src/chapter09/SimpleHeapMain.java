package chapter09;

public class SimpleHeapMain {
    public static void main(String[] args) {
        Heap<Character> heap = new SimpleHeap<>(String.class);

        HeapElement<Character> element1 = new HeapElement<>('A', 1);
        HeapElement<Character> element2 = new HeapElement<>('B', 2);
        HeapElement<Character> element3 = new HeapElement<>('C', 3);

        heap.hInsert(element1);
        heap.hInsert(element2);
        heap.hInsert(element3);

        while(!heap.hIsEmpty()) {
            char delete = heap.hDelete(1);
            System.out.printf("%c " , delete);
        }
    }
}
