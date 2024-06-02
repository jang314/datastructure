package chapter07;

import common.Node;

public class ListQueue<T> extends Queue<T>{
    private Node<T> front;
    private Node<T> rear;

    public ListQueue() {
        super();
    }

    @Override
    public boolean qIsEmpty() {
        return this.front == null;
    }

    @Override
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if(this.front == null)  {
            this.front = newNode;
            this.rear = newNode;
        } else {
            this.rear.next = newNode;
            this.rear = newNode;
        }
    }

    @Override
    public T dequeue() {
        if(this.qIsEmpty()) {
            throw new IllegalStateException("queue is empty.");
        }
        T data = this.front.data;
        this.front = this.front.next;
        return data;
    }

    @Override
    public T qpeek() {
        return this.front.data;
    }
}
