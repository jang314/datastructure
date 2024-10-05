package chapter03;


public class ListMain {
    public static void main(String[] args) {
        SimpleList list = new SimpleList(Integer.class);
        list.LInsert(11);
        list.LInsert(11);
        list.LInsert(22);
        list.LInsert(22);
        list.LInsert(33);

        System.out.println("현재 데이터 수 : " + list.LCount());

        if(list.LFirst()) {
            System.out.println(list.getData());
            while(list.LNext()) {
                System.out.println(list.getData());
            }
        }

        if(list.LFirst()) {
            if(list.getData().equals(22)) {
                list.LRemove();
            }

            while(list.LNext()) {
                if(list.getData().equals(22)) {
                    list.LRemove();
                }
            }
        }

        System.out.println("현재 남은 데이터 수 : " + list.LCount());

        if(list.LFirst()) {
            System.out.println(list.getData());
            while (list.LNext()) {
                System.out.println(list.getData());
            }
        }
    }
}
