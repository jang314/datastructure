package chapter10;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        Arrays.stream(insertionSort2(5,3,2,4,1))
                .forEach(arr -> System.out.printf("%d ", arr));
    }

    private static int[] insertionSort(int... arr) {
        int j =0;
        for(int i = 1; i< arr.length; i++) {
            int insData = arr[i];
            for(j = i - 1; j >=0; j--) {
                if(arr[j] > insData) {
                    arr[j+1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j+1]=insData;
        }

        return arr;
    }

    private static int[] insertionSort2(int... arr) {

        for(int i = 1; i < arr.length-1; i++) {
            int insData = arr[i];
            for(int j = i-1; j >= 0; j--) {
                if(insData  > arr[j]) {
                    arr[j+1] = arr[j];
                } else {
                    arr[j+1] = insData;
                    break;
                }
            }
        }
        return arr;
    }
}
