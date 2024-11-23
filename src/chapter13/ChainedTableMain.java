package chapter13;

import static chapter13.Person.makePersonData;

public class ChainedTableMain {
    public static void main(String[] args) {
        HashFunc<Integer> myHashFunc = key -> myHashFunc(key);
        Table2<Integer, Person> myTbl = new Table2<>(myHashFunc);
        Person np, sp, rp;

        // 데이터 입력
        np = makePersonData(900254, "Lee", "Seoul");
        myTbl.tblInsert(np.getSsn(), np);

        np = makePersonData(900139, "Kim", "Jeju");
        myTbl.tblInsert(np.getSsn(), np);

        np = makePersonData(900827, "Han", "Kangwon");
        myTbl.tblInsert(np.getSsn(), np);

        // 데이터 탐색
        sp = myTbl.tblSearch(900254);
        if(sp!=null) sp.showPerInfo();
        System.out.println();

        sp = myTbl.tblSearch(900139);
        if(sp!=null) sp.showPerInfo();
        System.out.println();

        sp = myTbl.tblSearch(900827);
        if(sp!=null) sp.showPerInfo();

        // 데이터 삭제
        rp = myTbl.tblDelete(900254);
        if(rp != null) rp = null;

        rp = myTbl.tblDelete(900139);
        if(rp != null) rp = null;

        rp = myTbl.tblDelete(900827);
        if(rp != null) rp = null;
    }
    private static int myHashFunc(int k) {
        return k % 100;
    }
}
