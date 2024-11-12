package chapter10;

import java.util.Arrays;

import static java.util.Arrays.stream;

public class MergeSort {
    public static void main(String[] args) {
//        int[] arrays = {3,2,4,1,7,6,5};
        int[] arrays = {8,2,3,7,1,5,4,6};
        stream(mergeSort(0, arrays.length-1, arrays))
                .forEach(r -> System.out.printf("%d ", r));
    }

    private static int[] mergeSort(int left, int right, int[] arrays) {
        int mid = (left + right) / 2;

        if(left < right) {
            mergeSort(left, mid, arrays);
            mergeSort(mid + 1, right, arrays);

            mergeTwoArea(arrays, left, mid, right);
        }

        return arrays;
    }

    private static int[] mergeTwoArea(int[] arrays, int left, int mid, int right) {
        int[] sortArray = new int[arrays.length];
        int lIdx = left;
        int rIdx = mid+1;
        int sIdx = left;

        while(lIdx <= mid && rIdx <= right) {
            if(arrays[lIdx] < arrays[rIdx]) {
                sortArray[sIdx++] = arrays[lIdx++];
            } else {
                sortArray[sIdx++] = arrays[rIdx++];
            }
        }

        if(lIdx <= mid) {
            for(int i = lIdx; i<=mid; i++) {
                sortArray[sIdx++] = arrays[i];
                lIdx++;
            }
        }
        if(rIdx <= right) {
            for(int i = rIdx; i <= right; i++) {
                sortArray[sIdx++] = arrays[i];
                rIdx++;
            }
        }

       for(int k = left; k<= right; k++) {
           arrays[k] = sortArray[k];
       }
        return arrays;
    }
}
