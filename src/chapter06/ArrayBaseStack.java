package chapter06;

import java.lang.reflect.Array;

public class ArrayBaseStack<T> extends Stack<T> {
    private static final int STACK_LEN = 10;
    private T[] stackArray;

    public ArrayBaseStack(Class clz) {
        super();
        this.stackArray = (T[]) Array.newInstance( clz, STACK_LEN);
    }

    @Override
    public boolean SisEmpty() {
        return topIndex == -1;
    }

    @Override
    public void SPush(T data) {
        this.stackArray[topIndex+1] = data;
        this.topIndex++;
    }

    @Override
    public T SPop() {
        T data = this.stackArray[topIndex];
        topIndex--;
        return data;
    }

    @Override
    public T SPeek() {
        if(SisEmpty()) {
            System.out.println("Stack Memory Error!");
            return null;
        }
        return this.stackArray[topIndex];
    }
}
