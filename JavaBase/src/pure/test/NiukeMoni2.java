package pure.test;

import java.util.Scanner;

public class NiukeMoni2 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[] arr = str.toCharArray();
		int[] arrtem = new int[arr.length];
		for(int i = 0;i < arr.length  ;i++){	
			arrtem[i] = Integer.parseInt(String.valueOf(arr[i]));
		}
		boolean result = isBanlance(arrtem);
		if(result){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
	}
	
	public static boolean isBanlance(int[] arr){
		boolean result = false;
		long sum1 = 1;
		long sum2 = 1;
		int len = arr.length;
		for(int i  = 0;i < len-1;i++){
			sum1 = 1;
			sum2 = 1;
			for(int r = 0;r <= i;r++){
				sum1 = sum1 * arr[r];
			}
			for(int j = len-i-2;j < len;j++ ){
				sum2 = sum2 * arr[j];
			}
			if(sum1 == sum2){
				return true;
			}
		}
		return result;
	}
}
