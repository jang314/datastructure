package chapter09_20241022;

public abstract class Heap<T> {

    protected static final int DEFAULT_ARRAY_SIZE = 100;
    protected int numOfData;

    public Heap() {
        this.numOfData = 0;
    }

    public abstract boolean hIsEmpty(); // 힙이 비었는지 확인
    public abstract void hInsert(HeapElement<T> element); // 힙에서 데이터 삽입
    public abstract T hDelete(int idx);    // 힙에서 데이터 삭제
    public abstract int getParentIdx(int idx); //부모 노드의 인덱스 값 반환
    public abstract int getLChildIdx(int idx); // 왼쪽 자식 노드의 인덱스 값 반환
    public abstract int getRChildIdx(int idx); // 오른쪽 자식 노드의 인덱스 값 반환
    public abstract int getHiPriChildIdx(int idx);  // 두 개의 자식 노드 중 높은 우선순위의 자식노드 인덱스 값 반환
}
