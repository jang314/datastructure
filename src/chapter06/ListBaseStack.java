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
        Node<T> newNode = new Node<>(data); // 새 노드 생성 및 데이터 저장
        newNode.next = head;    // 새 노드가 최근에 추가된 노드를 가리킴
        head = newNode;         // stack의 head가 새 노드를 가리킴
    }

    @Override
    public T SPop() {
        if(SisEmpty()) {
            System.out.println("Stack is empty. ");
            return null;
        }
        Node<T> rNode = head;       // 삭제할 노드를 임시로 저장
        T rData  = rNode.data;      // 삭제한 노드의 데이터를 임시로 저장
        head = head.next;           // head는 삭제할 노드의 다음 노드를 가리킴
        return rData;               // 삭제된 노드의 데이터 반환
    }

    @Override
    public T SPeek() {
        return (T) head.data;
    }
}
