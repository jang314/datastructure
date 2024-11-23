package chapter13;

import chapter04.DLinkedList;

public class Table2<T1, T2> {
    private static final int MAX_TBL = 100;
    private DLinkedList<Slot2>[] tbl;
    private HashFunc<T1> hf;

    public Table2(HashFunc hf) {
        this.tbl = new DLinkedList[MAX_TBL];
        this.hf = hf;
    }

    public void tblInsert(T1 key, T2 value) {
        int hv = hf.func(key);
        Slot2 ns = new Slot2(key, value);

        if (tbl[hv] == null) {
            tbl[hv] = new DLinkedList<>();
        } else {
            if (tblSearch(key) != null) { // 키가 중복되었다면
                System.out.println("키 중복 오류 발생 ");
                return;
            }
        }
        tbl[hv].LInsert(ns);
    }

    public T2 tblDelete(T1 key) {
        int hv = hf.func(key);
        Slot2 cSlot = tbl[hv].getData();
        if (tbl[hv].LFirst()) {
            if (cSlot.getKey().equals(key)) {
                tbl[hv].LRemove();
                return (T2) cSlot.getValue();
            } else {
                while (tbl[hv].LNext()) {
                    if (cSlot.getKey() == key) {
                        tbl[hv].LRemove();
                        return (T2) cSlot.getValue();
                    }
                }
            }
        }
        return null;
    }

    public T2 tblSearch(T1 key) {
        int hv = this.hf.func(key);
        Slot2 cSlot = null;

        if (tbl[hv].LFirst()) {
            cSlot = tbl[hv].getData();
            if (cSlot.getKey().equals(key)) {
                return (T2) cSlot.getValue();
            }
        } else {
            cSlot = tbl[hv].getData();
            while (tbl[hv].LNext()) {
                if (cSlot.getKey() == key) {
                    return (T2) cSlot.getValue();
                }
            }
        }
        return null;
    }

}
