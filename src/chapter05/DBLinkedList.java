package chapter05;

import common.Node;

public class DBLinkedList<T> {
    private Node<T> head;
    private Node<T> cur;
    private int numOfData = 0;

    private Node<T> data;

    protected void lInsert(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = this.head;   // 새 노드가 기존 노드를 가리키게 함

        if(this.head != null) {
            this.head.prev = newNode; // 기존 노드가 새 노드를 가리키게 함
        }

        newNode.prev = null;
        this.head = newNode;
        this.numOfData++;
    }
    protected boolean lFirst() {
        if(this.head == null) return false;
        this.cur = this.head;
        return true;
    }
    protected boolean lNext() {
        if(this.cur.next == null) return false;
        this.cur = this.cur.next;

        return true;
    }

    protected boolean lPrevious() {
        if(this.cur.prev == null) return false;
        this.cur = this.cur.prev;
        return true;
    }

    public Node getData() {
        return this.cur;
    }
}
