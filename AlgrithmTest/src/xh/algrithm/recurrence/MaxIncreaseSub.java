package xh.algrithm.recurrence;

import java.util.function.IntPredicate;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 最长递归子序列
 * @author Administrator
 *
 */
//最基本的算法，时间复杂度为O(N平方)
public class MaxIncreaseSub {

	public static void main(String[] args){
		int[] arr = {2,1,5,3,6,4,8,9,7};
		MaxIncreaseSub ms = new MaxIncreaseSub();
		int[] dp = ms.getdp2(arr);
		int[] lis = ms.generateLIS(arr, dp);
		System.out.println(ArrayUtils.toString(lis));
	}
	//时间复杂度为O(N平方)
	public int[] getdp1(int[] arr){
		int[] dp = new int[arr.length];
		for(int i = 0; i < arr.length;i++){
			dp[i] = 1;
			for(int j = 0;j < i;j++){
				if(arr[i] > arr[j]){
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		return dp;
		
	}
	
	//时间复杂度为O(NlgN)
	public int[] getdp2(int[] arr){
		int[] dp = new int[arr.length];
		int[] ends = new int[arr.length];
		ends[0] = 0;
		dp[0] = 1;
		int right = 0;
		int l = 0;
		int r = 0;
		int m = 0;
		for(int i = 1;i< arr.length;i++){
			l = 0;
			r= right;
			while(l <= r){
				m = (l+r)/2;
				if(arr[i] > ends[m]){
					l= m + 1;
				}else{
					r= m -1;
				}
			}
			right= Math.max(right, l);
			ends[l] = arr[i];
			dp[i] = l+1;
		}
		return dp;
	}
	
	public int[] generateLIS(int[] arr,int[] dp){
		int len = 0;
		int index = 0;
		for(int i = 0;i < dp.length;i++){
			if(dp[i] > len){
				len= dp[i];
				index = i;
			}
		}
		
		int[] lis = new int[len];
		lis[--len] = arr[index];
		for(int i = index;i >= 0;i--){
			if(arr[i] < arr[index] && (dp[i] == dp[index] -1 )){
				lis[--len] = arr[i];
				index = i;
			}
		}
		return lis;
	}
	
}

//时间复杂度为O(NlgN)

