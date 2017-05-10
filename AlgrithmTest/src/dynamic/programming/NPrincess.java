package dynamic.programming;

import java.util.Scanner;

/*
 * N皇后问题
 * N皇后问题是指在N*N的棋盘上摆N个皇后，要求任何两个皇后不同行、不同列，
 * 也不在同一斜线上。给定一个整数n，返回n皇后的摆法有多少种
 */
public class NPrincess {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(new NPrincess().num1(n));
	}
	
	//优化解法
	//用位运算，因为本方法中为运算的载体是int型变量，所以该方法只能算1~32皇后问题
	//如果计算更多皇后问题，则需要包含更多为的变量
	public int num2(int n){
		if(n < 2|| n > 32){
			return 0;
		}
		int upperLim = n== 32? -1 : (1<<n)-1;
		return proccess2(upperLim, 0, 0, 0);	
	}
	public int proccess2(int upperLim,int colLim, int leftDiaLim, int rightDiaLim){
		if(colLim == upperLim){
			return 1;
		}
		int pos = 0;
		int mostRightOne = 0;
		pos= upperLim & (~(colLim | leftDiaLim | rightDiaLim));
		int res = 0;
		while(pos != 0){
			mostRightOne = pos & (~pos + 1);
			pos= pos - mostRightOne;
			res += proccess2(upperLim, colLim | mostRightOne, (leftDiaLim | mostRightOne)<<1,(rightDiaLim | mostRightOne) >>>1);
		}
		return res;
	}

	//普通解法
	public int num1(int n){
		if(n < 1){
			return 0;
		}
		//record[i]表示在第i行皇后所在的列数
		int[] record = new int[n];
		return process1(0, record, n);
	}
	public int process1(int i,int[] record,int n){
		if(i== n){
			return 1;
		}
		int res = 0;
		for(int j = 0;j < n;j++){
			if(isValid(i, j, record)){
				record[i] = j;
				res += process1(i + 1, record, n);
			}
		}
		return res;
	}
	//判断在第i行j列放置皇后是不是有效的
	public boolean isValid(int i,int j,int[] record){
		for(int k = 0; k < i; k++){
			//递归计算到第i行第j列时，查看record[0..k](k < i)的值，看是否有相等的值
			//在看是否有|k-i|==|record[k] - j|
			if(record[k] == j || Math.abs(i-k)==Math.abs(record[k] - j)){
				return false;
			}
		}
		return true;
	}
}
