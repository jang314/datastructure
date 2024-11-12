package chapter10;

import java.util.Arrays;
import java.util.stream.IntStream;

import static java.util.Arrays.stream;

public class BubbleSort {
    public static void main(String[] args) {
        stream(bubbleSort2(3,4,2,1)).forEach(arr -> System.out.printf("%d ", arr)); ;
    }

    private static int[] bubbleSort(int... arr) {
        for(int i = 0 ; i < arr.length -1; i++) {
            for(int j = 1; j<arr.length-i; j++) {
                if(arr[j-1] > arr[j]) {
                    int tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }

    private static int[] bubbleSort2(int... arr) {
        for(int i = 0; i < arr.length-1; i++  ){
            for(int j = 0; j < (arr.length - i) - 1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
