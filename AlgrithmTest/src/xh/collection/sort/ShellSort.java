package xh.collection.sort;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/3/3.
 */
public class ShellSort {


    public static void main(String[] args) {
        int[] arr = {1, 7, 8, 8, 2, 7, 3, 4, 2, 5, 1, 7};
        System.out.println(Arrays.toString(arr));
        shellsort1(arr, arr.length);
        System.out.println(Arrays.toString(arr));

    }

    public static void shellsort1(int a[], int n)
    {
        int i, j, gap;

        for (gap = n / 2; gap > 0; gap /= 2) //步长
            for (i = 0; i < gap; i++)        //直接插入排序
            {
                for (j = i + gap; j < n; j += gap)
                    if (a[j] < a[j - gap])
                    {
                        int temp = a[j];
                        int k = j - gap;
                        while (k >= 0 && a[k] > temp)
                        {
                            a[k + gap] = a[k];
                            k -= gap;
                        }
                        a[k + gap] = temp;
                    }
            }
    }
}