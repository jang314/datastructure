package chapter04;

import java.util.Scanner;

public class LinkedRead {
    public static void main(String[] args) {
        Node<Integer> head = null;
        Node<Integer> tail = null;
        Node<Integer> cur = null;

        Scanner scanner  = new Scanner(System.in);

        while(true) {
            System.out.println("자연수 입력 : " );
            int data = scanner.nextInt();
            if(data < 1) {
                return ;
            }

            Node<Integer> newNode = new Node(data);
            if(head == null) {
                head = newNode;
            } else {
                tail.next = newNode;
            }
            tail = newNode;
        }
    }
}
