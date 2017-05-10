package xh.collection.sort;

//二分查找
import java.util.Arrays;

/**
 * Created by Administrator on 2017/3/1.
 */
public class BinarySearch {


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 34, 44, 55, 55, 66, 77, 999};
        System.out.println(binarySearch(arr, 3));
//        Arrays.sort();
    }

    public static int binarySearch(int[] arr, int a) {

        int hi = arr.length - 1;
        int low = 0;
        int mid = (hi + low) / 2;
        while (low <= hi) {
            if (arr[mid] == a) {
                return mid + 1;
            } else if (arr[mid] < a) {
                low = mid + 1;
            } else {
                hi = mid - 1;
            }
            mid = (hi + low) / 2;
        }
        return -1;
    }
    /*

    * 等于：大于，等于，小于
    * 找上界：大于，不大于
    * 找下界：小于，不小于，mid = (hi+low+1)/2
    *
    * */
}
