package chapter10;

import static java.util.Arrays.stream;

public class RadixSort {
    public static void main(String[] args) {
        int[] array = {13, 212, 14, 7141, 10987, 6,15};

        stream(radixSort(array))
                .forEach(arr -> System.out.printf("%d ", arr));

    }

    private static int[] radixSort(int[] array) {
        int max = getMax(array);

        for (int i = 0; i < max; i++) {
            int pow = (int) Math.pow(10, i);
            countingSort(array, pow);
        }
        return array;
    }

    private static void countingSort(int[] array, int exp) {
        int[] buckets = new int[array.length+1];
        int count[] = new int[10];

        for (int j = 0; j <= array.length - 1; j++) {
            int idx = array[j] / exp % 10;
            count[idx]++;
        }

        // 누적 합 구하기
        for(int j=1; j < count.length; j++) {
            count[j]+=count[j-1];
        }

        for(int j=array.length-1; j >= 0; j--) {
            int idx = array[j] / exp % 10;
            buckets[count[idx]] = array[j];
            count[idx]--;
        }

        for(int j=0; j< array.length; j++) {
            array[j] = buckets[j+1];
        }
    }

    private static int getMax(int[] array) {
        return stream(array).map(arr -> String.valueOf(arr).length()).max().getAsInt();
    }
}
