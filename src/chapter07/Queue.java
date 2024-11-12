package chapter07;

public abstract class Queue<T> {
    /**
     *   - 큐의 생성자로, 초기화 진행
     **/
    public Queue() { }
    /**
     *   - 큐가 빈 경우 true, 그렇지 않은 경우 false 반환
     **/
    public abstract boolean qIsEmpty();

    /**
     *   - 큐에 데이터 저장
     **/
    public abstract void enqueue(T data);

    /**
     *   - 저장순서가 가장 앞선 데이터 삭제되고, 삭제된 데이터 반환
     **/
    public abstract T dequeue();

    /**
     *   - 저장순서가 앞선 데이터를 반환하되 삭제 X
     *   - 데이터가 하나 이상 존재함이 보장되어야 함
     **/
    public abstract T qpeek();
}
