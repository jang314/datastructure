package chapter09;

public class SimpleHeapMain {
    public static void main(String[] args) {
        Heap<Character> heap = new Heap<>(Character.class, ((o1, o2) ->  {
            char ch1 = (char) o1;
            char ch2 = (char) o2;
            return (int) ch2 - (int) ch1;
        }));

        heap.hInsert('A');
        heap.hInsert('B');
        heap.hInsert('C');

        while(!heap.hIsEmpty()) {
            char delete = heap.hDelete(1);
            System.out.printf("%c \n", delete);
        }
    }
}

//        heap.hInsert(new HeapElem<>('E'));
//        heap.hInsert(new HeapElem<>('D'));
//        heap.hInsert(new HeapElem<>('C'));
//        heap.hInsert(new HeapElem<>('F'));
//        heap.hInsert(new HeapElem<>('G'));
//        heap.hInsert(new HeapElem<>('A'));
//        heap.hInsert(new HeapElem<>('J'));
//        heap.hInsert(new HeapElem<>('H'));
//        heap.hInsert(new HeapElem<>('I'));
//        heap.hInsert(new HeapElem<>('B'));