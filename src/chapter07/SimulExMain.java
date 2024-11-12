package chapter07;
import java.util.*;
import java.util.Queue;
import java.util.stream.Collectors;

public class SimulExMain {
    private static final int LUNCH_TIME = 3600;

    public static void main(String[] args) {
        Queue<BURGER> queue = new LinkedList<>();
        List<BURGER> reports = new ArrayList<>();

        BURGER order = null;
        int makeTime = -1;

        int timer = -1;
        while(timer <= LUNCH_TIME) {
            if(timer % 15 == 0) {
                order = selectMenu();

                if(!queue.offer(order)) {
                    System.out.println("order fail.");
                }
                makeTime = order.makeTime;
            }

            if (makeTime <= 0 && !queue.isEmpty()) {
                BURGER completeOrder = queue.poll();
                reports.add(completeOrder);
            }
            timer++;
            makeTime--;
        }

        System.out.println("burger.list.size = " + reports.size());
        reports.stream().collect(Collectors.groupingBy(BURGER::name))
                .entrySet().forEach(s -> System.out.println("- " + s.getKey() + " : " + s.getValue().size()));
    }

    private static BURGER selectMenu() {
        Random random = new Random();
        int orderNum = random.nextInt(3);

        return Arrays.stream(BURGER.values())
                .filter(burger -> burger.orderNum == orderNum)
                .findAny()
                .orElseGet(() -> BURGER.CHEESE_BURGER);
    }

    enum BURGER {
        CHEESE_BURGER(0, 12),
        BULGOGI_BURGER(1, 15),
        DOUBLE_BURGER(2, 24);

        private final int orderNum;
        private final int makeTime;

        BURGER(int orderNum, int makeTime) {
            this.orderNum = orderNum;
            this.makeTime = makeTime;
        }
    }
}
