package chapter06;

import common.Node;

public class ListBaseStack<T> extends Stack<T> {

    public ListBaseStack() {
        super();
    }

    @Override
    public boolean SisEmpty() {
        return head == null;
    }

    @Override
    public void SPush(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }

    @Override
    public T SPop() {
        if(SisEmpty()) {
            System.out.println("Stack is empty. ");
            return null;
        }
        Node<T> rNode = head;
        T rData  = rNode.data;
        head = head.next;
        return rData;
    }

    @Override
    public T SPeek() {
        return (T) head.data;
    }
}
