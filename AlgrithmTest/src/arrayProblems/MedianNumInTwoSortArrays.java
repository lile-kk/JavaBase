package arrayProblems;


/**
 * 在两个长度相等的排序数组总找到上中位数
 * 	给定两个有序数组arr1和arr2，已知两个数组的长度都为N，求两个数组中所有数的上中位数
 * 	时间复杂度o(logN),额外空间复杂度O(1)
 * @author Administrator
 *
 */
public class MedianNumInTwoSortArrays {
	public static void main(String[] args){
		int[] arr1 = {1,2,3,4};
		int[] arr2 = {3,4,5,6};
		MedianNumInTwoSortArrays media = new MedianNumInTwoSortArrays();
		System.out.println(media.getMedianNum(arr1, arr2));
	}

	public int getMedianNum(int[] arr1,int[] arr2){
		if(arr1== null || arr2 == null || arr1.length != arr2.length)
			throw new RuntimeException("Your arr is invalid!");
		int start1 = 0;
		int end1 = arr1.length - 1;
		int start2 = 0;
		int end2 = arr2.length - 1;
		int mid1 = 0;
		int mid2 = 0;
		int offset = 0;//offset=0表示奇数，1表示偶数
		while(start1 < end1){
			mid1 = (end1 + start1) / 2;
			mid2 = (end2 + start2) / 2;
			offset = (end1 - start1) % 2;
			if(arr1[mid1] > arr2[mid2]){
				end1 = mid1;
				start2 = mid2 + offset;
			}else if(arr1[mid1] < arr2[mid2]){
				start1 = mid1 + offset;
				end2 = mid2;
			}else {
				return arr1[mid1];
			}
		}
		return Math.min(arr1[start1], arr2[start2]);
	}
}
