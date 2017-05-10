package jingdong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class EndC {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		//int n = Integer.valueOf(sc.nextLine());
		int n= sc.nextInt();
		TreeMap<Integer, Integer[]> map= new TreeMap<Integer, Integer[]>();
		int i = 0;
		int farest = 0;
		
		while(i < n){
			Integer[] t = new Integer[2];
			t[0] = sc.nextInt();
			t[1] = sc.nextInt();
			farest = farest < t[0] ? t[0] : farest;
			map.put(i, t);
			i++;
		}
		
		int time = 0;
		HashMap<Integer, LinkedList<Integer>> sumMax = new HashMap<Integer, LinkedList<Integer>>();
		for(int j = 0; j < farest + 1; j++){
			Iterator<Integer> iter = map.keySet().iterator();
			LinkedList<Integer> list= new LinkedList<Integer>();
			while(iter.hasNext()){
				int key = iter.next();
				Integer[] value = map.get(key);
				if((value[0] -j <= 0)&&(value[0] + value[1] - j >=0))
					list.add(key);
			}
			sumMax.put(j, list);
		}
		
		int max1 = 0;
		int timeNum = 0;
		for (int j = 0; j < farest + 1; j++) {
			int size = sumMax.get(j).size();
			if(max1 < size){
				max1 = size;
				timeNum = j;
			}
			
		}
		
		LinkedList<Integer> carList= sumMax.get(timeNum);
		for (int j = 0; j < farest + 1; j++) {
			LinkedList<Integer> tmp = new LinkedList<Integer>();
			tmp.addAll(sumMax.get(j));
		
			tmp.retainAll(carList);	
			sumMax.get(j).removeAll(tmp);
			
		}
		
		int max2 = 0;
		for (int j = 0; j < farest + 1; j++) {
			int size = sumMax.get(j).size();
			if(max2 < size){
				max2 = size;
			}
			
		}
		
		System.out.print(max1 + max2);
		
		
	}
}
