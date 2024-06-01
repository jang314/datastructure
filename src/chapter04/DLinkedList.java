package chapter04;

import java.util.Comparator;

public class DLinkedList<T> {
    private Node<T> head;
    private Node<T> cur;
    private Node<T> before;
    private int numOfData;
    private Comparator<T> comp;

    public DLinkedList() {
        this.head = new Node<>(null);
        this.numOfData = 0;
        this.comp = null;
    }

    public void LInsert(T data) {
        if(this.comp == null) {
            // 정렬기준 마련 X
            FInsert(data);
        } else {
            // 정렬기준 마련
            SInsert(data);


        }
        this.numOfData++;
    }

    private void SInsert(T data) {
        Node<T> newNode = new Node<>(data);
        Node<T> predNode = this.head;

        while(predNode.next != null && this.comp.compare(data, (T) predNode.next.data) == 1) {
            predNode = predNode.next;
        }

        newNode.next = predNode.next;
        predNode.next = newNode;
    }

    private void FInsert(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head.next;
        head.next = newNode;
    }

    public boolean LFirst() {
        if(this.head.next == null) {
            return false;
        }
        this.before = this.head;
        this.cur = this.head.next;
        return true;
    }

    public boolean LNext() {
        if(this.cur.next == null) {
            return false;
        }
        this.before = this.cur ;
        this.cur = this.cur.next;
        return true;
    }

    public T LRemove() {
        Node<T> rData = this.cur;

        if(numOfData == 0) {
            System.out.println("Out Of Memory");
            return null;
        }
        this.before.next = rData.next;
        this.cur = this.before;
        numOfData--;
        return rData.data;
    }

    public int LCount() {
        return this.numOfData;
    }

    public void SetSortRule(Comparator<T> comp) {
        this.comp = comp;
    }

    public T getData() {
        return this.cur.data;
    }

}
