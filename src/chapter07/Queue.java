package chapter07;

public abstract class Queue<T> {
    public Queue() {

    }
    public abstract boolean qIsEmpty();
    public abstract void enqueue(T data);
    public abstract T dequeue();
    public abstract T qpeek();
}
