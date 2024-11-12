package chapter06;

import common.Node;

public abstract class Stack<T> {
    public Node head;
    public int topIndex;

    public Stack() {
        this.topIndex = -1;
    } // 스택의 생성자로 초기화를 진행
    abstract public boolean SisEmpty(); // 스택이 비었는지 확인
    abstract public void SPush(T data);   // 스택의 PUSH연산
    abstract public T SPop();    // 스택의 POP 연산
    abstract public T SPeek();   // 스택의 peek 연산
}
