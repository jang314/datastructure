package chapter07;

public class DequeMain {
    public static void main(String[] args) {
        Dequeue<Integer> deque = new Dequeue<>();
        deque.dqAddFirst(3);
        deque.dqAddFirst(2);
        deque.dqAddFirst(1);

        deque.dqAddLast(4);
        deque.dqAddLast(5);
        deque.dqAddLast(6);

        while(!deque.dqIsEmpty()) {
            System.out.printf("%d ", deque.dqRemoveFirst());
        }

        deque.dqAddFirst(3);
        deque.dqAddFirst(2);
        deque.dqAddFirst(1);

        deque.dqAddLast(4);
        deque.dqAddLast(5);
        deque.dqAddLast(6);

        System.out.println();
        while(!deque.dqIsEmpty()) {
            System.out.printf("%d ", deque.dqRemoveLast());
        }



    }
}
