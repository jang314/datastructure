package chapter07;

import java.lang.reflect.Array;

public class CQueue<T> extends Queue<T>{
    private static final int DEFAULT_LENG = 100;

    private int front;
    private int rear;
    private T[] array;


    public CQueue(Class cls) {
        this.array = (T[]) Array.newInstance(cls, DEFAULT_LENG);
        this.rear = 0;
        this.front = 0;
    }
    @Override
    public boolean qIsEmpty() {
        return this.rear==this.front;
    }

    @Override
    public void enqueue(T data) {
        // 꽉 찼을 때
        if(getNextPosition(this.rear) == front) {
            System.out.println("Queue is full.");
            return ;
        }
        this.rear = getNextPosition(this.rear);
        this.array[rear] = data;
    }

    @Override
    public T dequeue() {
        if(this.qIsEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        this.front = getNextPosition(this.front);
        return array[this.front];
    }

    @Override
    public T qpeek() {
        return this.array[getNextPosition(this.front)];
    }

    public int getNextPosition(int pos) {
        return pos + 1 == DEFAULT_LENG ? 0 : pos + 1;
    }
}
