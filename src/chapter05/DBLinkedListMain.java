package chapter05;

public class DBLinkedListMain {
    public static void main(String[] args) {
        DBLinkedList<Integer> list = new DBLinkedList<>();
        list.lInsert(1);
        list.lInsert(2);
        list.lInsert(3);
        list.lInsert(4);
        list.lInsert(5);
        list.lInsert(6);
        list.lInsert(7);
        list.lInsert(8);

        if(list.lFirst()) {
            System.out.printf("%d ", list.getData().data);
            while(list.lNext()) {
                System.out.printf("%d ", list.getData().data);
            }
            System.out.println();
            while(list.lPrevious()) {
                System.out.printf("%d ", list.getData().data);
            }

            System.out.println();
            System.out.println();
        }
    }
}
