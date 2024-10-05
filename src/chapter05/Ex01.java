package chapter05;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        CLinkedList<Employee> list = new CLinkedList<>();
        list.CRearInsert(new Employee(1, "김철수"));
        list.CRearInsert(new Employee(2, "박영희"));
        list.CRearInsert(new Employee(3, "이수정"));

        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        int day = sc.nextInt();

        System.out.printf("%s, %d", name, day);

        if(list.LFirst()) {
            if(!list.getData().name.equals(name)){
                while(list.LNext()) {
                    if(list.getData().name.equals(name)){
                        break;
                    }
                }
            }
        }
        for(int i =0 ; i < day; i++) {
            list.LNext();
        }
        System.out.println();
        System.out.printf("%d일 후 청소 당번 : %s ", day ,list.getData().name);

    }

    static class Employee{
        private int no;
        private String name;

        public Employee (int no, String name) {
            this.no = no;
            this.name = name;
        }
    }
}
