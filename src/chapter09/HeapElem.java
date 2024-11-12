package chapter09;

public class HeapElem<T> {
    private T data;

    public HeapElem (T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
