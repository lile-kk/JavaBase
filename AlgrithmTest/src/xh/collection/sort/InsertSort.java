package xh.collection.sort;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/2/28.
 */
public class InsertSort {


    public static void main(String[] args) {
        int[] arr = {1, 8, 8, 2, 7, 3, 4, 2, 5, 7, 1};
        System.out.println("before:\n" + Arrays.toString(arr));
        InsertSort.binarySort(arr);
        System.out.println("after:\n" + Arrays.toString(arr));

    }
    //升序排序
    public static void sort(int[] arr) {

        int j = 0, target = 0;
        for (int i = 1; i < arr.length; i++) {
            j = i;
            target = arr[i];
            while (j > 0 && target < arr[j-1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = target;
        }
    }
    //?
    public static void binarySort(int[] a) {

        for (int i = 0; i < a.length-1; i++) {
            int temp=a[i+1];
            int low=0;
            int high=i;
            int mid;
            //在low和high之间的区域进行二分查找，找到新插入的元素位置
            while(low<=high){
                mid=(low+high)/2;
                if(a[mid]>temp){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
            //经过上面的二分查找，得到新元素的位置是：high+1
            //把[high+1,i]区间内的所有元素往后移一个位置
            for (int j = i; j > high; j--) {
                a[j+1]=a[j];
            }
            a[high+1]=temp;

        }
}

}
