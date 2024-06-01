package chapter03;


import java.lang.reflect.Array;

public class SimpleList<T> {
    private static int DEFAULT_SIZE = 8;
    private T data;
    private T[] list;
    private int numOfData;
    private int curPosition;


    public SimpleList (Class clazz) {
        this.list = (T[]) Array.newInstance(clazz, DEFAULT_SIZE);
        this.numOfData = 0;
        this.curPosition = -1;
    }
    public SimpleList (Class clazz, int size) {
        this.list = (T[]) Array.newInstance(clazz, size <= 0 ? DEFAULT_SIZE : size);
        this.numOfData = 0;
        this.curPosition = -1;
    }
    public void LInsert(T data) {
        if(list.length <= numOfData) {
            System.out.println("저장이 불가능합니다.");
            return ;
        }
        this.list[numOfData] = data;
        numOfData++;
    }


    // 초기화
    public boolean LFirst() {
        if(numOfData == 0) {
            return false;
        }
        this.curPosition = 0;
        this.data = list[0];
        return true;
    }

    public boolean LNext() {
        if(this.curPosition >= this.numOfData-1) {
            return false;
        }
        this.curPosition++;
        this.data = list[this.curPosition];
        return true;
    }

    public void LRemove() {
        int pos = this.curPosition;
        int num = numOfData;
        for(int i = pos; i<num-1; i++) {
            list[i] = list[i+1];
        }
        this.curPosition--;
        this.numOfData--;
    }

    public int LCount() {
        return this.numOfData;
    }

    public T getData() {
        return this.data;
    }
}
