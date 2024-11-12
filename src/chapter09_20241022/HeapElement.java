package chapter09_20241022;

public class HeapElement<T> {
    private T data;
    private int pr;

    public HeapElement(T data, int pr) {
        this.data = data;
        this.pr = pr;
    }

    public T getData() {
        return data;
    }

    public int getPr() {
        return pr;
    }
}
