package chapter2;

public class RecursiveFactorial {
    public static void main(String[] args) {
        System.out.println("1! = " + factorial(1));
        System.out.println("2! = " + factorial(2));
        System.out.println("3! = " + factorial(3));
        System.out.println("4! = " + factorial(4));
        System.out.println("9! = " + factorial(9));

    }

    private static int factorial(int n) {

        if(n == 0) {
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }
}
