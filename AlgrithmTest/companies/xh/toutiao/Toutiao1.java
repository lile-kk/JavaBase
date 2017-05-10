package xh.toutiao;

import java.util.Scanner;

public class Toutiao1 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int i = 0;
		while(i < n){
			arr[i++] = sc.nextInt();
		}
		boolean[] dp = new boolean[n];
		dp[0] = true;
		for(int j = 1;j < n;j++){
			if(arr[j] > arr[j - 1]){
				dp[j] = true;
			}else {
				dp[j] = false;
			}
		}
		
		int start = 0;
		int end = 0;
		int index = 0;
		int result_start = 0;
		int maxLen = 0;
		for(int j = 0; j < n; j++){
			while(dp[j++] && j<n){
				
			}
			index= j - 1;
			while( (j<n) && (!dp[j])){
				j++;
			}
			end = j - 1;
			if(maxLen < (end - start + 1)){
				maxLen =  (end - start + 1);
				result_start = start;
				System.out.println(result_start);
			}
			start = end;
		}
		System.out.println(result_start + " " + (result_start + maxLen - 1));
		
	}
	
	
}
