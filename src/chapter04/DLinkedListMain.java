package chapter04;

public class DLinkedListMain {
    public static void main(String[] args) {
        DLinkedList<Integer> list = new DLinkedList();
        list.SetSortRule((d1, d2) -> {
            if(d1 < d2) {
                return 0;
            } else {
                return 1;
            }
        });


        list.LInsert(11);
        list.LInsert(11);
        list.LInsert(22);
        list.LInsert(22);
        list.LInsert(33);

        System.out.println("현재 데이터의 수 = " + list.LCount());

        if(list.LFirst()) {
            System.out.print(""+list.getData());
        }
        while(list.LNext()) {
            System.out.print(", " + list.getData());
        }

        if(list.LFirst()) {
            if(22 == list.getData()) {
                list.LRemove();
            }
        }
        while(list.LNext()) {
            if(22 == list.getData()) {
                list.LRemove();
            }
        }
        System.out.println();
        System.out.println("삭제 후 ! ");
        if(list.LFirst()) {
            System.out.print(""+list.getData());
        }
        while(list.LNext()) {
            System.out.print(", " + list.getData());
        }

    }
}
