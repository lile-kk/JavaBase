package xh.toutiao;

import java.util.Scanner;

public class Toutiao2 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		String[] strN = new String[N];
		String[] strM = new String[M];
		String[] strResult = new String[M];
		int i = 0;
		while(i < N){
			strN[i++] = sc.nextLine();
		}
		i = 0;
		while(i < M){
			strM[i++] = sc.nextLine();
		}
		
		
		//½¨Á¢µ¥´Ê¾ØÕó
//		boolean[][] dp = new boolean[N][16384];
//		for(int j = 0; j < N; j++){
//			String str = strN[j];
//			String[] word = str.split(" ");
//			for(int r = 0; r < word.length;r++){
//				int hashcode = Math.abs(word[r].hashCode());
//				dp[j][hashcode%16384] = true;
//			}
//		}
		
		
		for(int j = 0; j < M; j++){
			int index = 0;
			int maxLen = 0;
			String str = strM[j];
			String[] words = str.split(" ");
			for (int k = 0; k < N; k++) {
				int len = 0;
				String[] tmpp = strN[k].split(" ");
				for(int c = 0; c < words.length;c++){
					for (int l = 0; l < tmpp.length; l++) {
						if(words[c].equals(tmpp[l])){
							len++;
							break;
						}
					}
				}
				if(maxLen < len){
					maxLen = len;
					index = k;
				}
			}
			strResult[j] = strN[index];
		}
		
		for(int j = 0;j < M; j++){
			System.out.println(strResult[j]);
		}
		
	}
	
	
}
