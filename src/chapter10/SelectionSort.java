package chapter10;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        Arrays.stream(selectionSort(3,4,2,1))
                .forEach(arr -> System.out.printf("%d ", arr));
    }


    private static int[] selectionSort(int ... arr) {
        for(int i = 0; i<arr.length-1; i++) {
            int minIdx = i; // 1. 위치 선택
            for(int j = i+1 ; j<arr.length; j++) {  // 2. 선택한 위치의 값과 비교 시작
                if(arr[j] < arr[minIdx]) {  // 3. 조건에 맞는 위치 지정
                    minIdx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }

        return arr;
    }
}
