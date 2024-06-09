package chapter10;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3,2,4,1,7,6,5};
        Arrays.stream(mergeSort(0, arr.length-1, 3,2,4,1,7,6,5))
                .forEach(r -> System.out.printf("%d ", r));
    }

    private static int[] mergeSort(int left, int right, int... arr) {
        int mid = (left + right) /2;
        if(left < right) {
            mergeSort(left, mid, arr);
            mergeSort(mid+1, right, arr);

            mergeTwoArea(left, right, mid, arr);
        }

        return arr;
    }

    private static int[] mergeTwoArea(int left, int right, int mid, int... arr) {
        int[] sortArr = new int[arr.length];

        int lIdx = left;
        int rIdx = mid + 1;
        int curIdx = left;
        int i = 0;

        while(lIdx <= mid && rIdx <= right) {
            if(arr[lIdx] < arr[rIdx]) {
                sortArr[curIdx] = arr[lIdx];
                lIdx++;
            } else {
                sortArr[curIdx] = arr[rIdx];
                rIdx++;
            }
            curIdx++;
        }

        if(lIdx <= mid) {
            for(i = lIdx; i <= mid; i++) {
                sortArr[curIdx] = arr[i];
                curIdx++;
            }
        } else {
            for(i = rIdx; i <= right; i++) {
                sortArr[curIdx] = arr[i];
                curIdx++;
            }
        }

        for(i = left ; i<= right; i++) {
            arr[i] = sortArr[i];
        }
        return arr;
    }
}
