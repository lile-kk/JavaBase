package arrayProblems;
/*
 * 未排序数组中累加和小于或等于给定值的最长子数组的长度
 * 时间复杂度O(NlogN)，空间复杂的O(N)
 * 	:SumArr->以arr[i]结尾的累加和
 * 	helpArr->sumArr左侧最大值数组
 */
public class UnsortedFindSumLessK {
	public static void main(String[] args){
		int[] arr = {3,-2,-4,0,6,2};
		int k = -2;
		System.out.println(new UnsortedFindSumLessK().maxLength(arr, k));
	}

	public int maxLength(int[] arr,int k){
		int sum = 0;
		int[] helper = new int[arr.length + 1];
		//即表示数组从头第一个数开始的后面的额累加和
		helper[0] = 0;
		for(int i = 0; i < arr.length; i++){
			sum += arr[i];
			helper[i + 1] = Math.max(sum, helper[i]);
		}
		sum= 0;
		int num = 0;
		int len = 0;
		int index = 0;
		int res= 0;
		for(int i = 0; i < arr.length; i++){
			sum += arr[i];
			num = sum - k;
			index = getLessIndex(helper, num);
			len = index == -1 ? 0 : i - index + 1;
			res = Math.max(res, len);
		}
		return res;
		
	}
	
	//helper是一个升序数组，所以用二分查找查找第一次大于或等于sum-k这个值的位置
	public int getLessIndex(int[] arr,int num){
		int lo = 0;
		int hi = arr.length - 1;
		int mid = 0;
		int res = -1;
		while(lo <= hi){
			mid = (lo + hi) /2;
			if(arr[mid] >= num){
				res = mid;
				hi = mid - 1;
			}else {
				lo = mid + 1;
			}
		}
		return res;
	}
	
}
