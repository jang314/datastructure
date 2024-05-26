package chapter01;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1,3,5,7,9, 12, 21,23,27};
        int target = 3;
        int result = Bsearch(arr, target);
        if(result == -1) {
            System.out.println(" 탐색 실패 ");
        } else {
            System.out.println(" 타겟 저장 인덱스 " + result);
        }
    }
    private static int Bsearch(int[] arr, int target) {
        int first = 0;
        int last = arr.length-1;
        int mid = 0;

        while(first <= last) {
            mid = (first + last) / 2;
            if(arr[mid] == target) {
                return mid;
            } else {
                if(arr[mid] < target) {
                   first = mid + 1;
                } else {
                    last = mid - 1;
                }
            }
        }
        return -1;
    }
}
