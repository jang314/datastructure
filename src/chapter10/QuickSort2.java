package chapter10;

import java.util.Arrays;

public class QuickSort2 {


    public static void main(String[] args) {
        int arr[] = {3,2,4,1,7,6,5};
        Arrays.stream(quickSort(0, arr.length - 1, arr))
                .forEach(a -> System.out.printf("%d ", a));
    }

    private static int[] quickSort(int left, int right, int... arr) {
        int pivot = partition(left, right, arr);
        quickSort(left, pivot-1);
        quickSort(pivot+1, right);
        return arr;
    }

    private static int partition(int left, int right , int... arr){
        int pivot = arr[left];
        int low = left + 1;
        int high = right;

        while(low <= high) {
            // 피벗 값 보다 큰 값을 찾는 과정 (low)
            while(arr[low] < pivot) {
                low++;
            }
            // 피벗 값 ㅂ다 작은 값을 찾는 과정(high)
            while(arr[high] > pivot) {
                high--;
            }
            if(low <= high) {
                swap(low, high, arr);
            }
        }

        // 피벗과 high가 가리키는 대상 교환
        swap(left, high, arr);
        return high;
    }

    // 두 교차지점에서 마났을 데이터 교환.
    private static void swap(int idx1, int idx2, int... arr) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }
}
