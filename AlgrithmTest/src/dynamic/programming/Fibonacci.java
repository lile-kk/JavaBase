package dynamic.programming;

import xh.math.NciFang;

/*
 * 斐波那契系列问题的递归和动态规划
 */
public class Fibonacci {

	/*
	 * 递归的时间复杂度为O(2的N次方)
	 */
	public int f1(int n){
		if(n < 1)
			return 0;
		if(n== 1 || n == 2)
			return 1;
		return f1(n - 1) + f1(n - 2);
	}
	//非递归实现，时间复杂度O(N)
	public int f2(int n){
		if( n < 1)
			return 0 ;
		if(n == 1 || n == 2)
			return 1;
		int res = 1;
		int pre = 1;
		int tmp = 0;
		for(int i = 3; i <= n; i++){
			tmp = res;
			res= res + pre;
			pre = tmp;
		}
		return res;
	}
	
	/*
	 * 动态规划，时间复杂度log(N),转换为i*i的状态矩阵
	 */
	public int f3(int n){
		if(n < 1)
			return 0;
		if(n == 1 || n == 2)
			return 1;
		int[][] base = {{1,1},{1,0}};
		int[][] res = NciFang.matrixPower(base, n - 2);
		return res[0][0] + res[1][0];
	}
	
	public static void main(String[] args){
		Fibonacci fb = new Fibonacci();
		System.out.println(fb.f1(9));
		System.out.println(fb.f2(9));
		System.out.println(fb.f3(9));
	}
}
