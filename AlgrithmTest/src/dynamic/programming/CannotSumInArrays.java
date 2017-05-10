package dynamic.programming;
/**
 * �����������С������ɺ�
 * 	����һ����������arr��P422
 * 	��̬�滮�ķ�����ʱ�临�Ӷ�ΪO(N*sum),�ռ临�Ӷ�Ϊo(N)
 * @author Administrator
 *
 */
public class CannotSumInArrays {
	
	public static void main(String[] args){
		int[] arr = {3,8,1,2};
		CannotSumInArrays can = new CannotSumInArrays();
		System.out.println(can.unformeSum(arr));
	}
	
	public int unformeSum(int[] arr){
		if(arr== null || arr.length == 0)
			return 1;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < arr.length;i++){
			sum += arr[i];
			min = Math.min(min, arr[i]);
		}
		boolean[] dp = new boolean[sum + 1];
		dp[0] = true;
		for(int i = 0; i < arr.length; i++){
			for(int j = sum; j >= arr[i]; j--){
				dp[j] = dp[j - arr[i]] ? true : dp[j];
			}
		}
		for(int i = min; i <= sum; i++){
			if(!dp[i])
				return i;
		}
		return sum + 1;
	}
}
