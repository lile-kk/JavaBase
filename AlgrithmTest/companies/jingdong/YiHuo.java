package jingdong;

import java.util.Scanner;

public class YiHuo {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str1 = sc.next();
		String str2 = sc.next();
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		char[] res = new char[n];
		for(int i = 0; i < n; i++){
			if(arr1[i] == arr2[i]){
				res[i] = '0';
			}else {
				res[i] = '1';
			}
		}
		int result = 0;
		int tmp = 1;
		for(int i = n-1; i >=0; i--){
			if(res[i] == '1'){
				result += tmp;
			}
			tmp = tmp * 2;
		}
		System.out.println(result);
	}
}
