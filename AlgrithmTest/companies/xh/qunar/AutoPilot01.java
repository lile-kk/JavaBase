package xh.qunar;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class AutoPilot01 {
	public static int min = 10000000;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int n = str.split(" ").length;
		String[] arr = str.split(" ");
		byte[][] map = new byte[n][n];
		for(int i = 0; i < arr.length; i++){
			map[0][i] = Integer.valueOf(arr[i]).byteValue();
		}
		int i = 1;
		while(i < n){
			int j = 0;
			while(j < n){
				map[i][j] = sc.nextByte();
				j++;
			}
			i++;
		}
		
		dfs(map,0 , 0, 0, n);
		if(min== 10000000){
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
	}
	
	public static void dfs(byte a[][], int count, int x, int y,int n) {
		if (x > n - 1 || y > n - 1 || x < 0 || y < 0)
			return;
		if (x == n - 1 && y == n - 1) {
			if (count < min)
				min = count;
		}
		if (x + 1 < n && a[x + 1][y] == 0) {
			a[x + 1][y] = 1;
			//System.out.println(count +" 第"+ (x+1)+"行 "+(y+1)+"列"+ "x+1");
			dfs(a, count + 1, x + 1, y,n);
			
			a[x + 1][y] = 0;
		}
		if (y + 1 < n && a[x][y + 1] == 0) {
			a[x][y + 1] = 1;
			//System.out.println(count +" 第"+ (x+1)+"行 "+(y+1)+"列"+ "y+1");
			dfs(a, count + 1, x, y + 1,n);
			a[x][y + 1] = 0;
		}
		if (x - 1 >= 0 && a[x - 1][y] == 0) {
			a[x - 1][y] = 1;
			//System.out.println(count +" 第"+ (x+1)+"行 "+(y+1)+"列"+ "x-1");
			dfs(a, count + 1, x - 1, y,n);
			a[x - 1][y] = 0;
		}
		if (y - 1 >= 0 && a[x][y - 1] == 0) {
			a[x][y - 1] = 1;
			//System.out.println(count +" 第"+ (x+1)+"行 "+(y+1)+"列" + "y-1");
			dfs(a, count + 1, x, y - 1,n);
			a[x][y - 1] = 0;
		}
	}
	
	public static int auto(byte[][] map,int n){
		int[][] dp = new int[n][n];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n;j++){
				dp[i][j] = n * n;
			}
		}
		if(map[0][0] == 1){
			return -1;
		}
		dp[0][0] = 0;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(map[i][j] == 0){
					int stepsUp = n*n;
					int stepsDown = n*n;
					int stepsLeft = n*n;
					int stepsRight = n*n;
					if(j-1 >= 0 && map[i][j-1] == 0)
						stepsUp = dp[i][j-1] + 1;
					if(j + 1 <n && map[i][j + 1] == 0)
						stepsDown = dp[i][j + 1] + 1;
					if(i-1 >= 0 && map[i - 1][j] == 0)
						stepsLeft = dp[i - 1][j] + 1;
					if(i + 1 <n &&map[i + 1][j] == 0)
						stepsRight = dp[i+1][j] +1;
					int stepLR = Math.min(stepsLeft, stepsRight);
					int stepUD = Math.min(stepsUp, stepsDown);
					dp[i][j] = Math.min(stepLR, stepUD);
					if(i == 0 && j== 0){
						dp[0][0] = 0;
					}
				}
				
			}
		}
		
		
		return dp[n-1][n-1];
	}
}
