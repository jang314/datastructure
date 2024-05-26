package chapter01;

public class BSWrostOpCount {
    public static void main(String[] args) {
        int[] arrA = new int[500];
        int[] arrB = new int[5000];
        int[] arrC = new int[50000];
        int idx = 0;

        // 배열 arrA 대상으로 저장되지 않은 정수 1을 찾으라고 명령
        idx = Bsearch(arrA, 1);
        if(idx == -1) {
            System.out.println("탐색 실패");
        } else {
            System.out.println("타겟 저장 인덱스 : " + idx);
        }

        // 배열 arrB 대상으로 저장되지 않은 정수 2을 찾으라고 명령
        idx = Bsearch(arrB, 2);
        if(idx == -1) {
            System.out.println("탐색 실패");
        } else {
            System.out.println("타겟 저장 인덱스 : " + idx);
        }

        // 배열 arrC 대상으로 저장되지 않은 정수 3을 찾으라고 명령
        idx = Bsearch(arrC, 3);
        if(idx == -1) {
            System.out.println("탐색 실패");
        } else {
            System.out.println("타겟 저장 인덱스 : " + idx);
        }
    }
    private static int Bsearch(int[] arr, int target) {
        int first = 0;
        int last = arr.length-1;
        int mid = 0;

        System.out.println(arr.length);

        int opCount = 0;
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
            opCount++; // 비교연산의 횟수 1 증가
        }
        System.out.println("비교연산횟수 : " + opCount);

        return -1;
    }
}
