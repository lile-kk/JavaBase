package xh.toutiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String start = sc.nextLine();
		String end = sc.nextLine();
		String str = sc.nextLine();
		String words[] = str.split(" ");
		List<String> wordList= new ArrayList<String>();
		for (int i = 0; i < words.length; i++) {
			wordList.add(words[i]);
		}
	}
}
