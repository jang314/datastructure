package chapter10;

import static java.util.Arrays.stream;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {3,2,4,1,7,6,5};

        quickSort(arr, 0, arr.length-1);

        stream(arr)
                .forEach(a -> System.out.printf("%d ", a));
    }

    private static void quickSort(int[] arr, int left, int right) {
        if(left > right) {
            return ;
        }

        int pivot = partition(left, right, arr);

        quickSort(arr, left, pivot-1);
        quickSort(arr, pivot+1, right);
    }

    private static int partition(int left, int right, int[] arr) {
        int pivot = arr[left];
        int low = left+1;
        int high = right;

        while(low<=high) {
            while(low<=high && arr[low] < pivot) {
                low++;
            }
            while(arr[high] > pivot) {
                high--;
            }
            if(low <= high) {
                swap(arr, low, high);
            }
        }
        swap(arr, left, high);
        return high;
    }

    private static void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
}
