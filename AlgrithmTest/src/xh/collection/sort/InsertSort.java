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
    //��������
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
            //��low��high֮���������ж��ֲ��ң��ҵ��²����Ԫ��λ��
            while(low<=high){
                mid=(low+high)/2;
                if(a[mid]>temp){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
            //��������Ķ��ֲ��ң��õ���Ԫ�ص�λ���ǣ�high+1
            //��[high+1,i]�����ڵ�����Ԫ��������һ��λ��
            for (int j = i; j > high; j--) {
                a[j+1]=a[j];
            }
            a[high+1]=temp;

        }
}

}
