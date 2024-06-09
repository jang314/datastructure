package chapter10;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        Arrays.stream(selectionSort(3,4,2,1))
                .forEach(arr -> System.out.printf("%d ", arr));
    }

    private static int[] selectionSort(int... arr) {
        for(int i = 0 ; i<arr.length - 1; i++ ) {
            int idx= i;
            for(int j = i+1; j < arr.length; j++) {
                if(arr[idx] > arr[j]) {
                    idx = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }
        return arr;
    }
}
