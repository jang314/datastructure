package chapter07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class HamburgerSim {

    public enum Burger {
        CHE_BUR(0, 12),
        BUL_BUR(1, 15),
        DUB_BUR(2, 24);

        int orderNum;
        int time;

        Burger(int orderNum, int time) {
            this.orderNum = orderNum;
            this.time = time;
        }

        public int getTime() {
            return this.time;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        Queue<Burger> queue = new CQueue(Burger.class);
        List<Burger> burgers = new ArrayList<>();

        int time = -1;
        for (int i= 0 ; i < 3600; i++) {
            if(i % 15 == 0) {
                Burger burger = Arrays.asList(Burger.values()).stream()
                        .filter(o -> o.orderNum == random.nextInt(3))
                        .findAny().orElseGet(() -> Burger.CHE_BUR);

                queue.enqueue(burger);
                burgers.add(burger);
                time = burger.getTime();
            }
            time--;
            if(time <= 0 && !queue.qIsEmpty()) {
                 queue.dequeue();
            }
        }

        burgers.stream().collect(Collectors.groupingBy(Burger::name))
                .entrySet().forEach(s -> {
                    System.out.println(s.getKey() + " : " + s.getValue().size());
                });
    }
}
