package xh.collection.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Administrator on 2017/3/3.
 */
public class SelectSort {
    public static void main(String[] args) {

        int[] arr = {1, 8, 8, 2, 7, 3, 4, 2, 5, 7, 1};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));


    }

    public static void sort(int[] arr) {

        int k = 0, tmp = 0;


        for (int i = 0; i < arr.length - 1; i++) {
            k = i;
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] < arr[k]) {

                    k = j;
                }
            }

            if (i != k) {
                tmp = arr[i];
                arr[i] = arr[k];
                arr[k] = tmp;

            }
        }


    }
}