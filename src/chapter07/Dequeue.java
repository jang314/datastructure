package chapter07;

import common.Node;

public class Dequeue<T> {
    private Node<T> head;
    private Node<T> tail;

    public boolean dqIsEmpty() {
        return head == null;
    }

    public void dqAddFirst(T data){
        Node<T> newNode = new Node<>(data);
        newNode.next=head;
        if(head == null) {
            this.tail = newNode;
        } else {
            this.head.prev = newNode;
        }
        newNode.prev = null;
        this.head =newNode;
    }

    public void dqAddLast() {

    }

//    public T dqRemoveFirst() {
//
//    }
//
//    public T dqRemoveLast() {
//
//    }
//
//    public T dqGetFirst() {
//
//    }
//
//    public T dqGetLast() {
//
//    }
}
