package dynamic.programming;
/**
 * 正数数组的最小不可组成和
 * 	给定一个正数数组arr，P422
 * 	动态规划的方法，时间复杂度为O(N*sum),空间复杂度为o(N)
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
