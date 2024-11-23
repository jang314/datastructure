package chapter13;

import static chapter13.SlotStatus.EMPTY;

public class Slot<T> {
    private int key;
    private T value;
    private SlotStatus status = EMPTY;

    public Slot(int key, T value, SlotStatus status) {
        this.key = key;
        this.value = value;
        this.status = status;
    }

    public int getKey() {
        return key;
    }

    public T getValue() {
        return value;
    }

    public SlotStatus getStatus() {
        return status;
    }

    public void setStatus(SlotStatus status) {
        this.status = status;
    }
}
