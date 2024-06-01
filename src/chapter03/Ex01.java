package chapter03;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Ex01 {

    public static void main(String[] args) {
        ExList<Integer> list = new ExList(Integer.class);
        for(int i = 0 ; i < 9; i++ ) {
            list.LInsert(i+1);
        }

        System.out.println("total : " + list.getTotalCount());

        int totalCount=0;

        if(list.LFirst()) {
            totalCount += list.getData();
        }
            while(list.LNext()) {
                totalCount += list.getData();
            }

        System.out.println("sum = " + totalCount);

        if(list.LFirst()) {
            if(list.getData() % 2 == 0 || list.getData() % 3==0) {
                list.LRemove();
                System.out.println("삭제된 데이터 : " + list.getData());
            }
        }
        while(list.LNext()) {
            if(list.getData() % 2 == 0 || list.getData() % 3==0) {
                list.LRemove();
                System.out.println("삭제된 데이터 : " + list.getData());
            }
        }
        if(list.LFirst()) {
                System.out.print(list.getData());
        }
        while(list.LNext()) {
            if(list.getData() % 2 == 0 || list.getData() % 3==0) {
                System.out.print(", " + list.getData());
            }
        }
    }

    public static class ExList<T> {
        private final Integer MAX_DEFAULT_SIZE = 10;
        private T[] array;
        private T data;
        private int totalCount;
        private int idx ;

        public ExList (Class Cls) {
            this.array = (T[]) Array.newInstance(Integer.class, MAX_DEFAULT_SIZE);
            this.totalCount = 0;
            this. idx = -1;
        }

        public void LInsert(T t) {
            if(array.length <= totalCount) {
                System.out.println("Out Of Memory");
                return;
            }
            idx++;
            totalCount++;
            this.array[idx] = t;
            this.data = t;
        }

        public Boolean LNext() {
            if((idx+1) >= totalCount) {
                return false;
            }
            this.idx++;
            this.data = array[idx];
            return true;
        }

        public Boolean LFirst() {
            if(totalCount == 0) {
                return false;
            }
            this.idx = 0;
            this.data = array[0];
            return true;
        }

        public T LRemove() {
            int tmpTotalCount = totalCount;
            T rVal = this.array[idx];

            for(int i = this.idx; i < tmpTotalCount; i++ ) {
                this.array[i] = this.array[i+1];
            }
            totalCount--;
            idx--;
            return rVal;
        }

        public int getTotalCount() {
            return this.totalCount;
        }

        public T getData() {
            return this.data;
        }
    }
}
