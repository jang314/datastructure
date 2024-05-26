package chapter01;

public class LinearSearch {
    public static void main(String[] args) {
        int arr[] = {3,5,2,4,9};
        int idx = LinearSearch.LSearch(arr, arr.length, 7);

        if(idx == -1) {
            System.out.println("탐색 실패");
        } else {
            System.out.println("타켓 저장 인덱스 : " + idx);
        }
    }

    private static int LSearch(int ar[], int len, int target) {
        for(int i = 0; i < len; i++) {
            if(ar[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
