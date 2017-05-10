package pure.test;

import java.util.Scanner;

public class wangyi22 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String a= sc.nextLine();
		String b = a;
		int res = 0;
		for(int i = 0;i < a.length();i++){
			b = split(b);
			if(b.equals(a)){
				res++;
			}
		}
		System.out.println(res);
	}
	public static String split(String str){
		String res = str.substring(str.length()-1) + str.substring(0,str.length()-1);
		return res;
	}
}

 class Main {

    public static void shift(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int num = 1;
        char a = s.charAt(0);
        char b = s.charAt(s.length() - 1);
        if (s.length() < 700000)
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == a && s.charAt(i - 1) == b) {
                    String temp = s.substring(i) + s.substring(0, i);
                    if (temp.equals(s))
                        num++;
                }
            }
        System.out.println(num);
        scanner.close();
    }
}