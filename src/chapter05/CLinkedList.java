package chapter05;

import common.Node;

public class CLinkedList<T> {
    private Node<T> tail;
    private Node<T> cur;
    private Node<T> before;
    private int numOfData;

    public CLinkedList() {
        this.numOfData = 0;
    }

    public void CRearInsert(T data) {
        Node<T> newNode = new Node<>(data);

        if(tail == null) {
            this.tail = new Node<>(data);
            newNode.next = newNode;
        } else {
            newNode.next = this.tail.next;
            this.tail.next = newNode;
        }
        numOfData++;
    }

    public void CFrontInsert(T data) {
        Node<T> newNode = new Node<>(data);

        if(tail == null) {
            this.tail = new Node<>(data);
            newNode.next = newNode;
        } else {
            newNode.next = this.tail;
            tail.next = newNode;
            tail = newNode;
        }
        numOfData++;
    }

    public boolean LFirst() {
        if(this.tail == null) {
            return false;
        }
        this.before = this.tail;
        this.cur = this.tail.next;
        return true;
    }

    public boolean LNext() {
        if(this.tail == null) {
            return false;
        }

        this.before = this.cur;
        this.cur = this.cur.next;
        return true;
    }

    public T LRemove() {
        Node<T> delNode = this.cur;
        if(delNode == this.tail) {
            if(this.tail == this.tail.next) {
                this.tail = null;
            } else {
                this.tail = this.before;
            }
        }

        this.cur = this.before;
        this.before.next = delNode.next;

        this.numOfData--;
        return delNode.data;
    }

    public T getData() {
        return this.cur.data;
    }

    public int LCount() {
        return this.numOfData;
    }
}
