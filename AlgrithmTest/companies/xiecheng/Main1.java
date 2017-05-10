package xiecheng;

import java.util.Scanner;

public class Main1 {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			double n = sc.nextInt();
			int m = sc.nextInt();
			System.out.println(sumM(n, m));
		}
	}
	
	public static String sumM(double n, int m){
		double kaif = n;
		double sum = 0;
		for(int i = 1; i <= m && kaif > 0;i++){
			sum += kaif;
			kaif = Math.sqrt(kaif);
		}
		return String.format("%.2f", sum);
	}
	
	public static boolean isValid(int x){
		int result = 0;
		int shang = x;
		int yushu = 0;
		while(shang != 0){
			yushu = shang % 10;
			result += yushu * yushu * yushu;
			shang = shang / 10;
		}
		if(result == x){
			return true;
		}
		return false;
	}
}
