package chapter04;

public class SimpleList<T> {
    private Node<T> head;
    private Node<T> cur;
    private Node<T> tail;
    private int totalCount;


    public SimpleList() {
        this.totalCount = 0;
    }

    public void LInsert(T data) {
        Node<T> node = new Node<>(data);
        if(head == null) {
            this.head = node;
            this.head.next = node;
        } else {
            this.tail.next = node;
        }
        this.tail = node;
        totalCount++;
    }

    public boolean LFirst() {
        if(head == null) {
            return false;
        }
        this.cur = this.head;
        return true;
    }
    public boolean LNext() {
        if(this.cur.equals(this.head)) {
            this.cur = head.next;
        } else {
            this.cur = this.cur.next;
            if(this.cur == null) {
                return false;
            }
        }
        return true;
    }

    public Node getNode() {
        return this.cur;
    }

    // tail부터 삭제해야한다. 더미노드가 없기때문
    // 선택해서 삭제할 수 없다.
    public void LRemove(Node prevNode) {
        if(totalCount == 0) {
            System.out.println("Empty Data.");
            return ;
        }
        if(prevNode == null) {
            this.head = head.next;
        } else {
            prevNode.next = this.cur.next;
            this.cur = prevNode;
        }
       totalCount--;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public T getData() {
        return this.cur.data;
    }
}
