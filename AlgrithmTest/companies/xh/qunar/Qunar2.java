package xh.qunar;

import java.util.Scanner;

public class Qunar2 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str = sc.nextLine();
			System.out.println(changeTo(str));
		}
	}
	
	public static long changeTo(String str){
		char[] array = str.toCharArray();
		long result = 0;
		long temp = 1;
		for(int i = array.length-1; i >= 0;i--){
			long num = (long)array[i] - 97;
			result += num * temp;
			temp = temp * 26;
		}
		return result;
	}
	
}
