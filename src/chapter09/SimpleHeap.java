package chapter09;

import java.lang.reflect.Array;

public class SimpleHeap<T> extends Heap<T> {
    private HeapElement[] heapArray;

    public SimpleHeap(Class cls) {
        super();
        heapArray = (HeapElement[]) Array.newInstance(cls, DEFAULT_ARRAY_SIZE);
    }

    @Override
    public boolean hIsEmpty() {
        return numOfData == 0;
    }

    @Override
    public void hInsert(T data, int priority) {

    }

    @Override
    public T hDelete() {
        return null;
    }

    @Override
    public int getParentIdx(int idx) {
        return idx / 2;
    }

    @Override
    public int getLChildIdx(int idx) {
        return idx * 2;
    }

    @Override
    public int getRChildIdx(int idx) {
        return (idx * 2) + 1;
    }

    /**
     *  두 개의 자식 노드 중 높은 우선순위의 자식 노드 인덱스 값 반환
    * */
    @Override
    public int getHiPriChildIdx(int idx) {
        int lChildIdx = getLChildIdx(idx);

        return 0;
    }
}
