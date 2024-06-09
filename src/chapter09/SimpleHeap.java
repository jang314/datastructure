package chapter09;

import java.lang.reflect.Array;

public class SimpleHeap<T> extends Heap<T> {
    private HeapElement[] heapArray;

    public SimpleHeap(Class cls) {
        super();
        heapArray = (HeapElement[]) Array.newInstance(HeapElement.class, DEFAULT_ARRAY_SIZE);
    }

    @Override
    public boolean hIsEmpty() {
        return numOfData == 0;
    }

    @Override
    public void hInsert(HeapElement<T> lastElement) {
        int lastIdx = numOfData + 1;
        this.heapArray[lastIdx] = lastElement;

        while(lastIdx != 1) {
            if(heapArray[getParentIdx(lastIdx)].getPr() > lastElement.getPr()) {
                heapArray[lastIdx] = heapArray[getParentIdx(lastIdx)];
                lastIdx = getParentIdx(lastIdx);
            } else {
                // 새로 들어온 데이터의 우선순위가 더 높다면
                break;
            }
        }
        heapArray[lastIdx] = lastElement;
        numOfData++;
    }

    @Override
    public T hDelete(int idx) {
        // idx는 삭제하고자 하는 인덱스
        int lastIdx = numOfData; // 마지막 자식 노드
        HeapElement<T> deleteHeap = this.heapArray[idx];
        HeapElement<T> lastHeap =   this.heapArray[lastIdx];

        while(true) {
            System.out.println(heapArray[getHiPriChildIdx(idx)]);
            if(heapArray[getHiPriChildIdx(idx)].getPr() > heapArray[lastIdx].getPr()) {
                break;
            }
            heapArray[idx] = heapArray[getHiPriChildIdx(idx)];
            idx = getHiPriChildIdx(idx);
        }

        this.heapArray[idx] = lastHeap;
//        this.heapArray[lastIdx] = null;

        return deleteHeap.getData();
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

        // 오른쪽 노드가 없다는 뜻
        if(lChildIdx == numOfData) {
            return lChildIdx;
        }

        // 자식 노드가 존재하지 않으면
        else if(lChildIdx > numOfData) {
            return 0;
        }
        // 둘다 존재
        else {
            // 오른쪽 노드가 우선순위가 높다면
            if(this.heapArray[lChildIdx].getPr() > this.heapArray[getRChildIdx(idx)].getPr()) {
                return getRChildIdx(idx);
            } else {
                return lChildIdx;
            }
        }
    }
}
