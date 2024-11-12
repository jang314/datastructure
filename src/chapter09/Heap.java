package chapter09;


import java.lang.reflect.Array;
import java.util.Comparator;

public class Heap<T> {
    private final static int DEFAULT_ARRAY_SIZE = 100;
    private int numOfData = 0;
    private Comparator<T> comp;
    private T[] heapArray;

    public Heap(Class cls, Comparator comp) {
        heapArray = (T[]) Array.newInstance(cls, DEFAULT_ARRAY_SIZE);
        this.comp = comp;
    }
    // 힙이 비었는지 확인
    public boolean hIsEmpty(){
        return numOfData == 0;
    }

    // 힙에서 데이터 삽입
    public void hInsert(T element) {
        int childIdx = numOfData + 1;

        while(childIdx > 1) {
            int parentIdx = getParentIdx(childIdx);
            if(comp.compare(this.heapArray[parentIdx], element) > 0 ) break;
            this.heapArray[childIdx] = this.heapArray[parentIdx];
            childIdx = parentIdx;
        }
        this.heapArray[childIdx] = element;
        numOfData++;
    }

    // 힙에서 데이터 삭제
    public T hDelete(int idx) {
        int parentIdx = idx;
        T delData = this.heapArray[parentIdx];
        int lastIdx = numOfData;
        T lastData = this.heapArray[lastIdx];

        while(getHiPriChildIdx(parentIdx) != 0) {
            int childIdx = getHiPriChildIdx(parentIdx);
            if(comp.compare(lastData , this.heapArray[childIdx]) >= 0) {
                break;
            }

            this.heapArray[parentIdx] = this.heapArray[childIdx];
            parentIdx = childIdx;
        }

        this.heapArray[parentIdx] = lastData;
        this.numOfData--;

        return delData;
    }

    //부모 노드의 인덱스 값 반환
    public int getParentIdx(int idx) {
        return idx / 2;
    }

    // 왼쪽 자식 노드의 인덱스 값 반환
    public int getLChildIdx(int idx){
        return idx * 2;
    }
    // 오른쪽 자식 노드의 인덱스 값 반환
    public int getRLChildIdx(int idx){
        return (idx * 2) + 1;
    }

    // 두 개의 자식 노드 중 높은 우선순위의 자식노드 인덱스 값 반환
    public int getHiPriChildIdx(int idx) {
        int lIdx = getLChildIdx(idx);
        int rIdx = getRLChildIdx(idx);

        // 자식 노드가 존재하지 않는 다면
        if(lIdx > numOfData) {
            return 0;
        } else if (lIdx == numOfData) { // 자식 노드가 하나만 존재 한다면
            return lIdx;
        } else {    // 자식 노드가 둘 다 존재 한다면
            return comp.compare(this.heapArray[lIdx], this.heapArray[rIdx]) > 0 ? lIdx : rIdx;
        }
    }

}
