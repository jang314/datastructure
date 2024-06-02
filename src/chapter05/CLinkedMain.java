package chapter05;

public class CLinkedMain {
    public static void main(String[] args) {
        CLinkedList<Integer> clist = new CLinkedList<>();
        clist.CRearInsert(3);
        clist.CRearInsert(4);
        clist.CRearInsert(5);
        clist.CFrontInsert(2);
        clist.CFrontInsert(1);

        if(clist.LFirst()) {
            System.out.print(""+clist.getData());
        }
        for(int i = 0 ; i< clist.LCount()*3-1; i++) {
            if(clist.LNext()) {
                System.out.print(", " + clist.getData());
            }
        }

        System.out.println();

        int count = clist.LCount();
        if(count != 0) {
            clist.LFirst();
            if(clist.getData()%2==0) {
                clist.LRemove();
            }

            for(int i =0; i<count-1; i++) {
                clist.LNext();
                if(clist.getData()%2==0) {
                    clist.LRemove();
                }
            }
        }

        if(clist.LFirst()) {
            System.out.print(""+clist.getData());
            for(int i =0 ; i<clist.LCount()-1; i++) {
                if(clist.LNext()) {
                    System.out.print(", " + clist.getData());
                }
            }
        }
    }
}
