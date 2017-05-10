package wangyi;

import java.util.Scanner;

/**
 * 给定一个字符串，请你将字符串重新编码，将连续的字符替换成“连续出现的个数+字符”。
 * 比如字符串AAAABCCDAA会被编码成4A1B2C1D2A。 
 * @author Administrator
 *
 */
public class StringCode {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		char[] array = str.toCharArray();
		int length = array.length;
		int next = 0;
		String result = new String();
		for(int i = 0;i < length;){
			int sum = 1;
			next = i + 1;
			while(next < length && array[i] == array[next]){
				sum++;
				next++;
			}
			result = result+sum+array[i];
			i = i + sum;
		}
		
		System.out.println(result);
	}
}
