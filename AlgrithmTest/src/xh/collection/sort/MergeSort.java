package xh.collection.sort;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/3/2.
 * πÈ≤¢≈≈–Ú
 */
public class MergeSort {

    public static void sort(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            sort(nums, low, mid);
            sort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }
    public static void merge(int[] nums, int low, int mid, int high) {

        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;

        while (i <= mid && j <= high) {  
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= high) {
            temp[k++] = nums[j++];
        }
        for (int k2 = 0; k2 < temp.length; k2++) {
            nums[k2 + low] = temp[k2];
        }
    }
    public static void main(String[] args) {
        int[] nums = {1, 8, 8, 2, 7, 3, 4, 2, 5, 1, 7};
        System.out.println(Arrays.toString(nums));
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
