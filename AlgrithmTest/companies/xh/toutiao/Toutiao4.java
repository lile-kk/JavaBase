package xh.toutiao;

import java.util.Scanner;

public class Toutiao4 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int q = sc.nextInt();
		int[] arrA = new int[n];
		int[] arrB = new int[n];
		int[][] arrQ = new int[q][2];
		int p = 0;
		while(p < n){
			arrA[p++] = sc.nextInt();
		}
		p= 0;
		while(p < n){
			arrB[p++] = sc.nextInt();
		}
		p = 0;
		while(p < q){
			arrQ[p][0] = sc.nextInt();
			arrQ[p][1] = sc.nextInt();
			p++;
		}
		
		//QuickSort qs = new QuickSort();
		//qs.quickSort(arrA, 0, n-1);
		//qs.quickSort(arrB, 0, n-1);
		int[] result = new int[q];
		for(int i = 0; i < q; i++){
			int len = 0;
			for(int j = 0; j < n; j++){
				if((arrA[j] >= arrQ[i][0])&&(arrB[j] >= arrQ[i][1])){
					len++;
				}
			}
			result[i] = len;
		}
		
		for(int i = 0;i < q; i++){
			System.out.println(result[i]);
		}
	}
}

