package chapter10;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BubbleSort {
    public static void main(String[] args) {
        Arrays.stream(bubbleSort(3,4,2,1)).forEach(arr -> System.out.printf("%d ", arr)); ;
    }

    private static int[] bubbleSort(int... arr) {
        for(int i = 0 ; i < arr.length -1; i++) {
            for(int j = i+1; j<arr.length; j++) {
                if(arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }
}
