package wangyi;

import java.awt.LinearGradientPaint;
import java.util.Scanner;

/**
 * 在一个N*N的数组中寻找所有横，竖，左上到右下，右上到左下，四种方向的直线连续D个数字的和里面最大的值 
 * @author Administrator
 *
 */
public class NNArrayNDSum {

	public static void main(String[] args){
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		String line1 = sc.nextLine();
		String[] line1Arr = line1.split(" ");
		int N = Integer.valueOf(line1Arr[0]);
		int D = Integer.valueOf(line1Arr[1]);
		int[][] arr = new int[N][N];
		int r = 0;
		while(r < N){
			String line = sc.nextLine();
			String[] lineArr = line.split(" ");
			for(int j = 0;j < N;j++){
				arr[r][j] = Integer.valueOf(lineArr[j]);
			}
			r++;
		}
		for(int i = 0;i < N-D;i++){
			for(int j = 0;j < N - D;j++){
				int result = getMax(arr, sum, i, j, D);
				sum = Math.max(result, sum);
			}
		}
		System.out.println(sum);
		
	}
	
	public static int getMax(int[][] arr,int sum,int row,int col,int D){
		int result = 0;
		int sum1 = 0;
		int sum2 = 0;
		int sum3 = 0;
		int sum4 = 0;
		for(int i = 0;i < D;i++){
			sum1 += arr[row][col + i];
			sum2 += arr[row + i][col];
			sum3 += arr[row + i][col + i];
			sum4 += arr[row + i][col + D-1-i];
		}
		int temp12 = Math.max(sum1, sum2);
		int temp34 = Math.max(sum3, sum4);
		result  = Math.max(temp12, temp34);
		return result > sum ? result : sum;
	}
}
