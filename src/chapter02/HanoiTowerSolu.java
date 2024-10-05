package chapter02;

public class HanoiTowerSolu {
    public static void main(String[] args) {
        HanoiTowerMove(3, "a", "b", "c");
    }

    private static void HanoiTowerMove(int num, String from ,String by, String to) {
        if(num==1) {
            System.out.println("원반 1개를 " + from + "에서 " + to +"로 이동");
        } else {
            HanoiTowerMove(num-1, from, to, by);
            System.out.println("원반 " + num + " 을(를) " + from + "에서 " + to + "로 이동");
            HanoiTowerMove(num-1, by,from,to);
        }
    }
}
