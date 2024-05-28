package chapter03;

import static chapter03.Pointer.Point.*;

public class Pointer {
    public static void main(String[] args) {
        SimpleList list = new SimpleList(Point.class);

        list.LInsert(SetPointPost("2","1"));
        list.LInsert(SetPointPost("2","2"));
        list.LInsert(SetPointPost("3","1"));
        list.LInsert(SetPointPost("3","2"));

        System.out.println("현재 데이터의 수 : " + list.LCount());

        if(list.LFirst()) {
            ShowPointPost((Point) list.getData());

            while(list.LNext()) {
                ShowPointPost((Point) list.getData());
            }
        }

        Point compPos =  SetPointPost("2", "0");
        if(list.LFirst()) {
            if(PointComp((Point) list.getData() , compPos) == 1) {
                list.LRemove();
            }
            while (list.LNext()) {
                if(PointComp((Point) list.getData() , compPos) == 1) {
                    list.LRemove();
                }
            }
        }


        System.out.println("현재 남은 데이터의 수  : " + list.LCount());

        if(list.LFirst()) {
            ShowPointPost((Point) list.getData());
            while(list.LNext()) {
               ShowPointPost((Point) list.getData());
            }
        }

    }

    static class Point {
        private String x;
        private String y;

        public static Point SetPointPost(String x, String y) {
            return  new Point(x ,y);
        }

        private Point (String x, String y) {
            this.x = x;
            this.y = y;
        }

        public static void ShowPointPost(Point point) {
            System.out.println("[" + point.x + ", " + point.y + "]");
        }

        public static int PointComp(Point point1, Point point2) {
            // 두 포인트의 x만 같을 때
            if(point1.x.equals(point2.x) && !point1.y.equals(point2.y)) {
                return 1;
            }

            // 두 포인트의 y만 같을 때
            if(point1.y.equals(point2.y) && !point1.x.equals(point2.x)) {
                return 2;
            }

            if(point1.x.equals(point2.x) && point1.y.equals(point2.y)) {
                return 0;
            }

            return -1;
        }
    }
}
