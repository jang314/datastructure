package chapter04;

import common.Node;

public class SimpleListMain {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.insert(2);
        list.insert(4);
        list.insert(6);
        list.insert(8);

        list.read();
        System.out.println();
        list.remove();
        System.out.println();
        list.read();
    }

    static class LinkedList<T> {
        private Node head;
        private Node tail;
        private Node cur;

        protected void insert(T data) {
            Node<T> newNode = new Node<>(data);
            newNode.next = null;

            if(this.head == null) {
                this.head = newNode;
            } else {
                this.tail.next = newNode;
            }
            this.tail = newNode;
        }

        protected void read() {
            this.cur = head;
            if(this.head == null) {
                System.out.println("empty data.");
                return;
            }
            System.out.printf("%d ", this.cur.data);

            while(this.cur.next!=null) {
                this.cur = this.cur.next;
                System.out.printf("%d ", this.cur.data);
            }
        }

        protected void remove1() {
            if(head == null) return;
            else {
                Node delNode = this.head;
                Node delNextNode = this.head.next;

                System.out.printf("%d을 삭제합니다. ", delNode.data);
                System.out.println();
                delNode = null;

                while(delNextNode != null) {
                    delNode = delNextNode;
                    delNextNode = delNextNode.next;

                    System.out.printf("%d을 삭제합니다. ", delNode.data);
                    System.out.println();
                    delNode = null;
                }
            }
        }
        protected void remove() {
            if(head == null) return;
            else {
                Node delNode = this.head;
                Node delNextNode = this.head.next;

                System.out.printf("%d을 삭제합니다. ", delNode.data);
                System.out.println();
                this.head = delNextNode;

                while(delNextNode != null) {
                    delNode = delNextNode;
                    delNextNode = delNextNode.next;

                    System.out.printf("%d을 삭제합니다. ", delNode.data);
                    System.out.println();
                    this.head = delNextNode;
                }
            }
        }
    }
}
