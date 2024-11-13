package chapter11;

public class InterpolSearch {
    public static void main(String[] args) {
        int idx = iSearch(0, 4, 7, 1,3,5,7,9);
        if(idx == -1) {
            System.out.println("탐색 실패");
        } else {
            System.out.printf("타겟 저장 인덱스 : %d ", idx);
        }

    }

    private static int iSearch(int first, int last, int target, int... arr) {
        int mid = 0;

        mid = (int)((double)(target - arr[first]) / (arr[last] - arr[first]) * (last-first)) + first;
//        mid = ((target - arr[first]) / (arr[last] - arr[first]) * (last-first)) + first;
        mid = (((target - arr[first]) * (last-first)) / (arr[last] - arr[first])) + first;

//        if(arr[mid] == target) {
//            return mid;
//        }

        if(arr[first]>target||arr[last]<target) {
            return -1;
        }
        if(arr[mid] == target) {
            return mid;
        }
        else if (target > arr[mid]) {
            return iSearch(first, mid-1, target,arr);
        } else {
            return iSearch(mid+1, last, target, arr);
        }
    }
}
