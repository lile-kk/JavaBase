package xh.collection.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = {1, 8, 8, 2, 7, 3, 4, 2, 5, 7, 1};
        BubbleSort.sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    /*
    * 选择排序：
    *   时间复杂度：O(n^2)
    *   空间复杂度：O(1)
    * */
    public static void sort(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}