package arrayProblems;
/*
 * �����������ۼӺ�����
 * 	����һ������arr�����������������ۼӺ�,ʱ�临�Ӷ�O(N),�ռ临�Ӷ�O(1)
 */
public class SubArrayMaxSum {

	public static void main(String[] args){
		int[] arr = {1,-2,3,5,-2,6,-1};
		System.out.println(new SubArrayMaxSum().sumMax(arr));
	}
	public int sumMax(int[] arr){
		if(arr == null || arr.length < 1)
			return 0;
		int cur = 0;
		int max= Integer.MIN_VALUE ;
		for(int i = 0; i < arr.length;i++)
		{
			cur += arr[i];
			if(cur >= 0){
				max = Math.max(max, cur);
			}else{
				cur= 0;
			}
		}
		return max;
		
	}
}
