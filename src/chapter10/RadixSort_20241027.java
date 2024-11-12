package chapter10;

import chapter07.ListQueue;
import chapter07.Queue;

public class RadixSort_20241027 {
    private static final int BUCKET_NUM = 10;

    public static void main(String[] args) {
        int[] arr = {13, 212 ,14 , 7141, 10987, 6, 15};
        radixSort(5, arr.length, arr);
        for(int i=0; i<arr.length; i++) {
            System.out.printf("%d : ", arr[i]);
        }

    }

    private static void radixSort(int num, int maxLen, int... arr) {
        Queue<Integer>[] queues = new Queue[BUCKET_NUM];
        int bi = 0;
        int pos = 0;
        int di = 0 ;
        int divfac = 1;
        int radix = 0;

        // 총 10개의 버킷 초기화
        for(bi =0; bi<BUCKET_NUM; bi++) {
            Queue<Integer> queue = new ListQueue<>();
            queues[pos] = queue;
        }


        // 가장 긴 데이터의 길이만큼 반복
        for(pos = 0 ; pos < maxLen; pos++) {
            // 정렬 대상의 수만큼 반복
            for(di = 0 ; di<num; di++) {
                // N번째 자리의 숫자 추출
                radix = (arr[di] / divfac) % 10;
                //추출한 숫자를 근거로 버킷에 데이터 저장
                queues[di].enqueue(arr[di]);
            }

            // 버킷 수만큼 반복
            di = 0;
            for(bi=0; bi<BUCKET_NUM; bi++) {
                // 버킷에 저장된 것 순서대로 다 꺼내 다시 arr에 저장
                while(!queues[bi].qIsEmpty()) {
                    arr[di++] = queues[bi].dequeue();
                }
            }

            // N번째 자리까의 숫자 추출을 위한 피제수의 증가
            divfac *= 10;
        }
    }
}
