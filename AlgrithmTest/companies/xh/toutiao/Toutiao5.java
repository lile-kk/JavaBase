package xh.toutiao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Toutiao5 {

	public static void main(String[] args){
		/**
		Scanner sc  = new Scanner(System.in);
		int m = sc.nextInt();
		int[] arrM = new int[m];
		int i = 0;
		while(i < m){
			arrM[i++] = sc.nextInt();
		}
		int n = sc.nextInt();
		int[] arrN = new int[n];
		int j = 0;
		while(j < n){
			arrN[j++] = sc.nextInt();
		}
		HashSet<Integer> set= new HashSet<Integer>();
		for(int k = 0;k < m;k++){
			set.add(arrM[k]);
		}
		ArrayList<Integer> list= new ArrayList<Integer>();
		for(int k = 0; k < n; k++){
			if(set.contains(arrN[k]))
				list.add(arrN[k]);
		}
		for(int k = 0; k < list.size()-1;k++){
			System.out.print(list.get(k) + " ");
		}
		System.out.print(list.get(list.size()-1));
		
		
		
			*/
		
		/**
		 * Scanner sc  = new Scanner(System.in);
		HashSet<Long> set= new HashSet<Long>();
		long uid = 0;
		while(true){
			uid = sc.nextLong();
			if(uid != 0){
				set.add(uid);
			}else {
				break;
			}
				
		}
		System.out.println(set.size());
3 4
1
5 3
1 1 4
		 */
		System.out.println(Long.MAX_VALUE);
		System.out.println(String.valueOf((1L << 62)));
	}

}
