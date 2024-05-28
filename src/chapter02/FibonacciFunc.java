package chapter02;

public class FibonacciFunc {
    public static void main(String[] args) {
        for(int i= 1 ; i< 15; i++) {
            System.out.print(fibo(i) + " ");
        }
    }
    private static int fibo (int n) {
        if(n==1) {
            return 0;
        } else if(n==2) {
            return 1;
        } else {
            return fibo(n-1) + fibo(n-2);
        }
    }

}
