package xiecheng;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[] arr = str.toCharArray();
		double len = arr.length;
		double[] tmp = new double[26];
		
		if(len == 0){
			System.out.println(0);
		}else{
			for(int i = 0; i < arr.length; i++){
				tmp[arr[i] - 97]++;
			}
			
			double result = 0;
			for(int i = 0; i < 26; i++){
				if(tmp[i] != 0){
					double times = tmp[i];
					double gailv = times / len;
					double gain = - (gailv * (Math.log(gailv)/Math.log(2)));
					result += gain;
				}
				
			}
			
			System.out.println(String.format("%.7f", result));
		}
		
	}
}
