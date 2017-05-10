package arrayProblems;

import java.util.Arrays;

/*
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
 */
public class MedianOfTwoSortedArrays {
	
	public static void main(String[] args){
		int[] nums1 = {1,2};
		int[] nums2 = {3,4};
		System.out.println(new MedianOfTwoSortedArrays().median(nums1, nums2));
	}

	//优化解法：利用二分查找,等价于求第K小的数
	public double median(int[] A,int[] B){
		 int m = A.length, n = B.length;
		    int l = (m + n + 1) / 2;
		    int r = (m + n + 2) / 2;
		    return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
	}
	
	public double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
		if (aStart > A.length - 1) return B[bStart + k - 1];            
		if (bStart > B.length - 1) return A[aStart + k - 1];                
		if (k == 1) return Math.min(A[aStart], B[bStart]);
		
		int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
		if (aStart + k/2 - 1 < A.length) aMid = A[aStart + k/2 - 1]; 
		if (bStart + k/2 - 1 < B.length) bMid = B[bStart + k/2 - 1];        
		
		if (aMid < bMid) 
		    return getkth(A, aStart + k/2, B, bStart,       k - k/2);// Check: aRight + bLeft 
		else 
		    return getkth(A, aStart,       B, bStart + k/2, k - k/2);// Check: bRight + aLeft
	}
	
	//--mine
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] res = merge(nums1, nums2);
        int n = nums1.length + nums2.length;
        double result = 0;
        if(n % 2 == 0){
        	int sum = res[n/2 - 1] + res[n/2];
        	result = (double)sum/2;
        }else{
        	result = res[n/2];
        }
        return result;
    }

	public int[] merge(int[] sums1,int[] sums2){
		int m = sums1.length;
		int n = sums2.length;
		int[] result = new int[m + n];
		int i = 0;
		int j = 0;
		int index = 0;
		while((i < m) && (j < n)){
			if(sums1[i] <= sums2[j]){
				result[index++] = sums1[i++];
			}else {
				result[index++] = sums2[j++];
			}
		}
		while(i < m){
			result[index++] = sums1[i++];
		}
		while(j < n){
			result[index++] = sums2[j++];
		}
		return result;
	}

}
