package chapter04;

import java.util.Scanner;

public class LinkedRead {
    public static void main(String[] args) {
        SimpleList<Integer> list = new SimpleList<>();

        Scanner scanner  = new Scanner(System.in);
        System.out.println("자연수 입력 : " );

        while(true) {
            int data = scanner.nextInt();
            if(data < 0) {
                break;
            }
            list.LInsert(data);
        }

        System.out.println("자연수 총 입력 개수 : " + list.getTotalCount());

        if(list.LFirst()) {
            System.out.print(list.getData());
        }

        while(list.LNext()) {
            System.out.print(", " +list.getData());
        }
        System.out.println();
        System.out.println("삭제할 데이터 입력 : ");
        int input = scanner.nextInt();

        Node delNode = null;
        if(list.LFirst()) {
            if(list.getData() == input) {
                list.LRemove(delNode);
            }
            delNode = list.getNode();
        }

        while(list.LNext()) {
            if(list.getData() == input) {
                list.LRemove(delNode);
            }
            delNode = list.getNode();
        }

        if(list.LFirst()) {
            System.out.print(list.getData());
        }

        while(list.LNext()) {
            System.out.print(", " +list.getData());
        }
    }
}
