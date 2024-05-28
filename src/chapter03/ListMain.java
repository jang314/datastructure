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



//    static class SimpleList {
//        private static int DEFAULT_SIZE = 8;
//        private int data;
//        private int[] list;
//        private int numOfData;
//        private int curPosition;
//
//        public static SimpleList ListInit() {
//            return new SimpleList();
//        }
//
//        private SimpleList () {
//            this.list = new int[DEFAULT_SIZE];
//            this.numOfData = 0;
//            this.curPosition = -1;
//        }
//
//        public void LInsert(int data) {
//            if(list.length <= numOfData) {
//                System.out.println("저장이 불가능합니다.");
//                return ;
//            }
//            this.list[numOfData] = data;
//            numOfData++;
//        }
//
//
//        // 초기화
//        public boolean LFirst() {
//            if(numOfData == 0) {
//                return false;
//            }
//            this.curPosition = 0;
//            this.data = list[0];
//            return true;
//        }
//
//        public boolean LNext() {
//            if(this.curPosition >= this.numOfData-1) {
//                return false;
//            }
//            this.curPosition++;
//            this.data = list[this.curPosition];
//            return true;
//        }
//
//        public void LRemove() {
//            int pos = this.curPosition;
//            int num = numOfData;
//            for(int i = pos; i<num-1; i++) {
//                list[i] = list[i+1];
//            }
//            this.curPosition--;
//            this.numOfData--;
//        }
//
//        public int LCount() {
//            return this.numOfData;
//        }
//    }
}
