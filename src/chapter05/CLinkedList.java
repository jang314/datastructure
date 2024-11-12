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

        if(this.tail == null) {
            this.tail = newNode;
            newNode.next = newNode;
        } else {
            newNode.next = this.tail.next;
            this.tail.next = newNode;
            this.tail = newNode;
        }
        numOfData++;
    }

    public void CFrontInsert(T data) {
        Node<T> newNode = new Node<>(data);

        if(tail == null) {
            this.tail = newNode;
            newNode.next = newNode;
        } else {
            newNode.next = this.tail.next;
            this.tail.next = newNode;
        }
        numOfData++;
    }

    public boolean LFirst() {
        if(this.tail == null) { // 저장된 노드가 없다면
            return false;
        }

        this.before = this.tail;    // before가 꼬리를 가리키게함
        this.cur = this.tail.next;  // cur이 머리를 가리키게함
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
        if(delNode == this.tail) {              // 삭제 대상을 tail이 가리킨다면
            if(this.tail == this.tail.next) {   // 마지막 남은 노드라면
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
