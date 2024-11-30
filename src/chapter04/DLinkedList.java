package chapter04;

import common.Node;
import java.util.Comparator;

public class DLinkedList<T> {
    private Node<T> head;       // 더미 노드를 가리키는 멤버
    private Node<T> cur;        // 참조 및 삭제를 돕는 멤버
    private Node<T> before;     // 삭제를 돕는 멤버
    private int numOfData;      // 저장된 데이터의 수를 기록하기 위한 멤버
    private Comparator<T> comp; // 정렬의 기준을 등록하기 위한 멤버

    /**
     *  - 리스트 생성자
    * */
    public DLinkedList() {
        this.head = new Node<>(null);
        this.numOfData = 0;
        this.comp = null;
    }

    /**
     * - 리스트에 데이터를 저장하고 매개변서 data에 전달된 값을 저장한다.
     * */
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
        Node<T> newNode = new Node<>(data); // 새 노드 생성
        Node<T> predNode = this.head; // 더미 노드를 가리킴

        // 새 노드가 들어갈 위치를 찾기 위한 반복문
        while(predNode.next != null && this.comp.compare(data, (T) predNode.next.data) > 0) {
            predNode = predNode.next;   // 다음 노드로 이동
        }

        newNode.next = predNode.next; // 새 노드의 오른쪽을 연결
        predNode.next = newNode;    // 새 노드의 왼쪽을 연결

        this.numOfData++;
    }

    private void FInsert(T data) {
        Node<T> newNode = new Node<>(data); // 새 노드 생성 및 데이터 저장
        newNode.next = head.next;           // 새 노드가 다른 노드를 가리키게 함
        head.next = newNode;                // 더미 노드가 새 노드를 가리키게 함
    }

    /**
     *  - 첫 번째 데이터를 가리키고 데이터의 참조를 위한 초기화가 진행된다.
     *  - 참조 성공 시 true, 실패 시 false 반환
     * */
    public boolean LFirst() {
        if(this.head.next == null) {    // 더미 노드가 NULL을 가리킨다면 반환할 데이터 없음
            return false;
        }
        this.before = this.head;        // before는 더미 노드를 가리키게 함
        this.cur = this.head.next;      // cur은 첫 번째 노드를 가리키게 함.
        return true;
    }

    /**
     * - 참조된 데이터의 다음데이터를 가리킨다.
     * - 순차적인 참조를 위해 반복 호출이 가능하다.
     * - 참조를 새로 시작하려면 먼저 LFirst() 호출해야 한다.
     * - 참조 성공 시 true, 실패 시 false 반환
     * */
    public boolean LNext() {
        if(this.cur.next == null) {
            return false;
        }
        this.before = this.cur ;
        this.cur = this.cur.next;
        return true;
    }

    /**
     * - LFirst()또는 LNext()의 마지막 반환 데이터를 삭제하고 삭제된 데이터를 반환한다.
     * - 참조 성공 시 true, 실패 시 false를 반환한다.
     * */
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

    /**
     * - 리스트에 저장되어 있는 데이터의 수를 반환
     * */
    public int LCount() {
        return this.numOfData;
    }

    /**
     * - 리스트 정렬의 기준이 되는 함수를 등록한다.
     * */
    public void SetSortRule(Comparator<T> comp) {
        this.comp = comp;
    }

    public T getData() {
        return this.cur.data;
    }

}
