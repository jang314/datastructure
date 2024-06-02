package chapter06;

public class ArrayBaseStackMain {
    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayBaseStack<>(Integer.class);

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
