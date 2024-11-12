package chapter07;

import common.Node;

import java.util.Deque;

public class Dequeue<T> {
    private Node<T> head;
    private Node<T> tail;
    private Dequeue<T> deque;

    public boolean dqIsEmpty() {
        return head == null;
    }

    /**
     *  - 덱의 머리에 데이터 저장
     * */
    public void dqAddFirst(T data){
        Node<T> newNode = new Node<>(data);
        if(head == null) {
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
        }
        this.head = newNode;
    }

    /**
     *  - 덱의 꼬리에 데이터 저장
     * */
    public void dqAddLast(T data) {
        Node<T> newNode = new Node<>(data);

        if(this.head == null) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = tail;
        }

        this.tail = newNode;
    }

    /**
     *  - 덱의 머리에 데이터 소멸
     * */
    public T dqRemoveFirst() {
        T ret = this.head.data;
        // 머리와 꼬리가 동시에 가리키는 경우
        if(head.next == null) {
            this.tail = null;
        }
        this.head = head.next;
        return ret;
    }
    /**
     *  - 덱의 꼬리에 데이터 소멸
     * */
    public T dqRemoveLast() {
        T ret = this.tail.data;
        // 머리와 꼬리가 동시에 가리키는 경우
        if(this.tail.prev == null) {
            this.head = null;
        } else {
            this.tail.next = null;
        }
        this.tail = tail.prev;

        return ret;
    }

    /**
     *  - 덱의 머리의 데이터 조회
     * */
    public T dqGetFirst() {
        if(this.dqIsEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        return this.head.data;
    }
    /**
     *  - 덱의 꼬리의 데이터 조회
     * */
    public T dqGetLast() {
        if(this.dqIsEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        return this.tail.data;
    }
}
