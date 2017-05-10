package xh.toutiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Toutiao8 {

	public static ArrayList<Integer> list= new ArrayList<Integer>();
	public static void main(String[] args){
		Scanner sc  = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] map = new int[n][n];
		int i = 0;
		int j = 0;
		while(i < n){
			j= 0;
			while(j <= i){
				map[i][j++] = sc.nextInt();
			}
			i++;
		}
		int sum = 0;
		for(int r = 0; r < n;r++){
			sum += r+1;
			list.add(sum);
		}
		System.out.println(sumMax(map, k, n));
		
		
	}
	public static int sumMax(int[][] map,int k,int n){
		int[][] dp = new int[n][n];
		for(int i = 0; i< n;i++){
			dp[n - 1][i] = map[n - 1][i];
		}
		for(int i = n - 2; i >= 0;i--){
			for(int j = 0;j <= i; j++){
				dp[i][j] = dp[i + 1][j] + dp[i + 1][j + 1] + map[i][j];
			}
		}
		//取出k在哪一层
		int layer = 1;
		for(int i = 0;i < n - 1;i++){
			if(k >= list.get(i) && k <= list.get(i + 1)){
				layer = i;
				break;
			}
		}
		int max = 0;
		int cur = n - 1;
		for(int l = k;l > 0;){
			Arrays.sort(dp[cur]);
			for(int j = 0; j < l&&j < cur;j++){
				max += dp[cur][cur - j];
			}
			l = l - (cur + 1);
			cur--;
			
		}
		return max;
		
	}
	
	
	
}

