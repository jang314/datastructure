package chapter13;

import javafx.scene.control.Tab;

import java.util.concurrent.atomic.AtomicInteger;

import static chapter13.SlotStatus.DELETED;
import static chapter13.SlotStatus.INUSE;

public class Table<T>{
    private static final int MAX_TBL = 100;
    private Slot<Object>[] tbl;
    private HashFunc hf;

    public static Table tvlInit(HashFunc hf) {
        return new Table(hf);
    }

    private Table (HashFunc hf) {
        this.tbl = new Slot[MAX_TBL];
        this.hf = hf;
    }

    public void tblInsert(int key, T value) {
        int hv = this.hf.func(key);
        this.tbl[hv] = new Slot<>(key, value, INUSE);
    }

    public T tblDelete(int key) {
        int hv = this.hf.func(key);
        if(this.tbl[hv].getStatus() != INUSE) {
            return null;
        } else {
            this.tbl[hv].setStatus(DELETED);
            return (T) tbl[hv].getValue();
        }
    }

    public T tblSearch(int key) {
        int hv =  this.hf.func(key);
        if(tbl[hv].getStatus() != INUSE) {
            return null;
        } else {
            return (T) tbl[hv].getValue();
        }
    }


}
