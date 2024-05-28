package chapter02;

public class RecursiveBinarySearch {
    public static void main(String[] args) {
        int arr[] = {1,3,5,7,9};
        int idx = BsearchRecur(arr, 0, arr.length-1, 7);
        if(idx == -1) {
            System.out.println("탐색 실패");
        } else {
            System.out.println("타겟 저장 인덱스 " + idx);
        }

    }
    private static int BsearchRecur(int[] arr, int first, int last, int target) {
        if(first > last) return -1;
        int mid = (first+last) / 2;
        if(arr[mid] == target) {
            return mid;
        } else if(arr[mid] < target) {
            return BsearchRecur(arr, mid+1, last, target);
        } else {
            return BsearchRecur(arr, first, mid-1, target);
        }
    }
}
