package pure.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
public class Wangyi33 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String[] arr1 = str1.split(" ");
		long score = 0;
		int n = Integer.parseInt(arr1[0]);
		int m = Integer.parseInt(arr1[1]);
		String strn = sc.nextLine();
		String strm = sc.nextLine();
		String[] arrn = strn.split(" ");
		String[] arrm = strm.split(" ");
		
		Map<String, Integer> mapm = new HashMap<String, Integer>();
		Map<String, Integer> mapn = new HashMap<String, Integer>();
		for(int i = 0;i < m;i++){
			mapm.put(arrm[i], arrm[i].length());
		}
		for(int i = 0;i < n;i++){
			mapn.put(arrn[i], arrn[i].length());
		}
		
		for(String key:mapn.keySet()){
			if(mapm.containsKey(key)){
				int value = mapm.get(key);
				score += value * value;
			}
		}
		System.out.println(score);
		
	}
}
