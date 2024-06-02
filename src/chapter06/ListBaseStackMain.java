package chapter06;

import common.Stack;

public class ListBaseStackMain {
    public static void main(String[] args) {
        Stack<Integer> stack = new ListBaseStack<>();

        stack.SPush(1);
        stack.SPush(2);
        stack.SPush(3);
        stack.SPush(4);
        stack.SPush(5);

        while(!stack.SisEmpty()) {
            System.out.printf("%d ", stack.SPop());
        }
    }
}
