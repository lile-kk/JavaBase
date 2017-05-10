package arrayProblems;
/*
 * ��������С��
 * ʱ�临�Ӷ�O(NlogN)���ռ临�Ӷ�O(N)
 */
public class ArrayLittleSum {
	
	public static void main(String[] args){
		int[] arr = {1,3,5,2,4,6};
		System.out.println(new ArrayLittleSum().getSmallSum(arr));
	}
	
	public int getSmallSum(int[] arr){
		if(arr == null || arr.length == 0)
			return 0;
		return func(arr, 0, arr.length-1);
	}
	public int func(int[] arr,int l,int r){
		if(l==r)
			return 0;
		int mid = (l + r) / 2;
		return func(arr, l, mid) + func(arr, mid + 1, r) + merge(arr, l, mid, r);
	}

	
	//�鲢��������м���С��
	public int merge(int[] arr,int left, int mid ,int right){
		int[] h = new int[right - left + 1];
		int hi = 0;
		int i = left;
		int j = mid + 1;
		int smallSum = 0;
		while( i <= mid && j <= right){
			if(arr[i] <= arr[j]){
				smallSum += arr[i] * (right - j + 1);
				h[hi++] = arr[i++];
			}else {
				h[hi++] = arr[j++];
			}
		}
		while(i <= mid){
			h[hi++] = arr[i++];
		}
		while(j <= right){
			h[hi++] = arr[j++];
		}
		for(int k = 0; k < h.length; k++){
			arr[left++] = h[k];
		}
		return smallSum;
	}
}
