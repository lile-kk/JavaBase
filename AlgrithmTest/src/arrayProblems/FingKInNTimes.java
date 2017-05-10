package arrayProblems;
import static java.lang.System.out;

import java.awt.image.RescaleOp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
/*
 *在数组中找到出现次数大于N/K的数
 *	一次在数组中删掉K个不同的数，不停的删除，直到剩下数的种类不足K就停止删除
 */
public class FingKInNTimes {
	
	public static void main(String[] args){
		int[] arr = {1,2,3,3,2,3,4,5,2,6,2,2};
		new FingKInNTimes().printKMajor(arr, 5);
	}

	//数组中出现次数大于一半的数
	public void printHalfmajor(int[] arr){
		int cand = 0;
		int count = 0;
		for(int i = 0; i < arr.length;i++){
			if(count == 0){
				cand = arr[i];
				count++;
			}else if(arr[i] == cand)
				count++;
			else
				count--;
		}
		count = 0;
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == cand)
				count++;
		}
		if(count > arr.length / 2)
			out.println(cand);
		else {
			out.println("no such number");
		}
	}
	
	//找出数组中出现N/K次的数，一次删除K个数
	public  void printKMajor(int[] arr,int k){
		if(k < 2){
			out.println("the value of K is invalid");
			return ;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i= 0; i < arr.length; i++){
			if(map.containsKey(arr[i]))
				map.put(arr[i], map.get(arr[i])+1);
			else {
				if(map.size() == k - 1){
					allNumsMinusOne(map);
				}else {
					map.put(arr[i], 1);
				}
			}
			
		}
		HashMap<Integer, Integer> reals = getReals(arr,map);
		boolean hasPrint = false;
		for(Entry<Integer, Integer> set:map.entrySet()){
			Integer key = set.getKey();
			if(reals.get(key) > (arr.length / k)){
				hasPrint = true;
				out.print(key + " ");
			}
		}
		out.print(hasPrint ? "" : "no such number");
	}
	//将hashmap所有的数减1，value为0则删除
	public void allNumsMinusOne(HashMap<Integer, Integer> map){
		List<Integer> removeList = new LinkedList<Integer>() ;
		for (Entry<Integer, Integer> set : map.entrySet()) {
			Integer key = set.getKey();
			Integer value = set.getValue();
			if(value == 1)
				removeList.add(key);
			map.put(key, value--);
		}
		for (Integer integer : removeList) {
			map.remove(integer);
		}
		
		
	}
	//验证候选出来的数那些真正大于N/K
	public HashMap<Integer, Integer> getReals(int[] arr,HashMap<Integer, Integer> map){
		HashMap<Integer, Integer> reals = new HashMap<Integer, Integer>();
		for(int i = 0; i < arr.length; i++){
			int curNum = arr[i];
			if(map.containsKey(curNum)){
				if(reals.containsKey(curNum))
					reals.put(curNum, reals.get(curNum) + 1);
				else {
					reals.put(curNum, 1);
				}
			}
		}
		return reals;
	}
	
}
