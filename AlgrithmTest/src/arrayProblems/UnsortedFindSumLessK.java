package arrayProblems;
/*
 * δ�����������ۼӺ�С�ڻ���ڸ���ֵ���������ĳ���
 * ʱ�临�Ӷ�O(NlogN)���ռ临�ӵ�O(N)
 * 	:SumArr->��arr[i]��β���ۼӺ�
 * 	helpArr->sumArr������ֵ����
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
		//����ʾ�����ͷ��һ������ʼ�ĺ���Ķ��ۼӺ�
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
	
	//helper��һ���������飬�����ö��ֲ��Ҳ��ҵ�һ�δ��ڻ����sum-k���ֵ��λ��
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
