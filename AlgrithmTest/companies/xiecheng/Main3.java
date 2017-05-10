package xiecheng;

import java.util.Scanner;

public class Main3 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String res0 = sc.nextLine();
		String[] res = res0.substring(1,res0.length() - 1).split(",");
		int[] resArr = new int[res.length];
		for (int i  = 0; i < res.length; i++) {
			resArr[i] = Integer.parseInt(res[i]);
		}
		String[] tmp1 = str.split("\\],\\[");
		tmp1[0] = tmp1[0].substring(1);
		tmp1[tmp1.length - 1] = tmp1[tmp1.length - 1].substring(0,tmp1[tmp1.length - 1].length() - 1);
		System.out.print(tmp1[0] + "  "+tmp1[tmp1.length - 1]);
	}
}
