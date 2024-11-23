package chapter13;

import static chapter13.Person.makePersonData;
import static chapter13.Table.tvlInit;

public class SimpleHashMain {
    public static void main(String[] args) {
        HashFunc<Integer> myHashFunc = key -> func(key);
        Table<Person> myTbl = tvlInit(myHashFunc);
        Person np, sp, rp;

        // 데이터 입력
        np = makePersonData(20120003, "Lee", "Seoul");
        myTbl.tblInsert(np.getSsn(), np);

        np = makePersonData(20130012, "Kim", "Jeju");
        myTbl.tblInsert(np.getSsn(), np);

        np = makePersonData(20170049, "Han", "Kangwon");
        myTbl.tblInsert(np.getSsn(), np);

        // 데이터 탐색
        sp = myTbl.tblSearch(20120003);
        if(sp!=null)    sp.showPerInfo();
        System.out.println();

        sp = myTbl.tblSearch(20130012);
        if(sp!=null)    sp.showPerInfo();
        System.out.println();

        sp = myTbl.tblSearch(20170049);
        if(sp!=null)    sp.showPerInfo();
        System.out.println();

        // 데이터 삭제
        rp = myTbl.tblDelete(20120003);
        if(rp != null)  rp = null;

        rp = myTbl.tblDelete(20130012);
        if(rp != null)  rp = null;

        rp = myTbl.tblDelete(20170049);
        if(rp != null)  rp = null;
    }

    private static int func(int key) {
        return key % 100;
    }
}
