package chapter2;

public class RecursiveFunc {
    public static void main(String[] args) {
        Recursive(3);
    }

    private static void Recursive(int i) {
        if(i<=0) {
            return;
        }
        System.out.println("Recursive call! " + i);
        Recursive(i-1);
    }
}
