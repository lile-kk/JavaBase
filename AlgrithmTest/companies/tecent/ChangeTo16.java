package tecent;

import java.util.Scanner;

/**
 * 将输入转换为16进制
 * @author Administrator
 *
 */
public class ChangeTo16 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		char[] arr = str.toCharArray();
		int len = arr.length;
		for(int i = 0;i < len; i++){
			if((i + 1)%16 == 1){
				String index = Integer.toHexString(i);//十六进制偏移
				String res = String.format("%0" + 8 + "d", Integer.parseInt(index));
				System.out.print(res);
			}
			String ch = Integer.toHexString(arr[i]);
			System.out.print(" " + ch);
			if(i != 0 && (i + 1)%16==0){
				System.out.println(" " + str.substring(i-15,i+1));//原文
			}
		}
	}
}
