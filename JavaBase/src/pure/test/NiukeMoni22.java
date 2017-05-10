package pure.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


/**
 * 字符串分类
 * @author Administrator
 *
 */
public class NiukeMoni22 {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int i = 0;
		String[] arr = new String[N];
		while(i < N){
			arr[i] = sc.next();
			i++;
		}
		ArrayList< Integer> list= new ArrayList<Integer>();
		list.add(0);
		int row = 1;
		boolean isclass = false;
		while(row < N){
			Iterator<Integer> iter = list.iterator();
			while(iter.hasNext()){
				isclass = isType(arr[iter.next()], arr[row], N);
				if(isclass){
					isclass= true;
					break;
				}
			}
			if(isclass == false){
				list.add(row);
			}
			row++;
			isclass = false;
		}
		
		System.out.println(list.size());
		
	}
	
	//判断是否属于某个类
	public static boolean isType(String from,String to,int N){
		boolean is = false;
		HashMap<Character, Integer> fromMap = toHashMap(from);
		HashMap<Character, Integer> toMap = toHashMap(to);
		is = compareHashMap(fromMap, toMap);
		return is;
		
	}
	
	//String存入HashMap
	public static HashMap<Character, Integer> toHashMap(String str){
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char[] arr = str.toCharArray();
		int N = arr.length;
		int value = 0;
		for(int i = 0; i < N; i++){
			if(map.containsKey(arr[i])){
				value = map.get(arr[i]);
				value++;
				map.put(arr[i], value);
				
			}else {
				value = 1;
				map.put(arr[i], value);
			}
		}
		return map;
	}
	
	//循环比较两个HashMap
	public static boolean compareHashMap(HashMap<Character, Integer> from,HashMap<Character, Integer> to){
		boolean isEqual = false;
		Iterator<Entry<Character, Integer>> iter = from.entrySet().iterator();
		while(iter.hasNext()){
			Map.Entry<Character,Integer> entry = (Map.Entry<Character,Integer>)iter.next();
			Character key = entry.getKey();
			Integer val = entry.getValue();
			if(to.containsKey(key)&& val==to.get(key)){
				isEqual = true;
			}else {
				return false;
			}
		}
		return isEqual;
	}
}
