package chapter07;

public class CircularQueueMain {
    public static void main(String[] args) {
        Queue<Integer> queue = new CQueue(Integer.class);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);

        while(!queue.qIsEmpty()) {
            int num = queue.dequeue();
            System.out.printf("%d ", num);
        }
    }
}
