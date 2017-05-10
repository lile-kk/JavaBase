package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
 * ����˵������start�任��end��;��ֻ�ܾ����ֵ��еĵ��ʣ�ÿ��ֻ�����һ����ĸ��
Ҫ��������б任·����
Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
 */
//�ⷨ����BFS�����ҵ�endʱ������������ǳ�ÿ���������ڵĲ�����Ȼ���Ŀ����DFS�����ң����˴����ݡ�
public class WordLadder {

	//��¼ÿ���������ڵĲ���
	HashMap<String, Integer> path = new HashMap<String, Integer>();
	//bfs����path
	void bfs(String start,String end,HashSet<String> dict){
		Queue queue = new LinkedList<String>();
		queue.add(start);
		path.put(start, 0);
		String current;
		while(!queue.isEmpty()){
			current = (String) queue.poll();
			if(current == end){
				continue;
			}
			for(int i = 0; i < current.length(); i++){
				char[] charArr = current.toCharArray();
				for(char ch = 'a'; ch <= 'z'; ch++){
					if(ch == charArr[i])
						continue;
					charArr[i] = ch;
					String newWord = new String(charArr);
					if(newWord.equals(end)==true || dict.contains(newWord)){
						//ÿ��������path��ֻ�ܳ���һ�Σ�Ҳ����ÿ������ֻ�ܳ�����һ���У������ͺ�����Ľ���˻�������
						if(path.get(newWord) == null){
							int depth = path.get(current);
							path.put(newWord, depth + 1);
							queue.add(newWord);
						}
					}
				}
			}
		}
	}
	
	//��Ŀ�굥�������ҿ�ʼ���ʣ���¼����·��
	void dfs(String start,String end,HashSet<String> dict,ArrayList<String> pathArr,
			ArrayList<ArrayList<String>> result){
		//�ҵ��ˣ���Ҫreverse��������е���
		if(start.equals(end)){
			pathArr.add(start);
			Collections.reverse(pathArr);
			result.add(pathArr);
			return;
		}
		if(path.get(start) == null){
			return;
		}
		pathArr.add(start);
		int nextDepth = path.get(start) - 1;
		for(int i = 0; i < start.length(); i++){
			char[] charArr = start.toCharArray();
			for(char ch = 'a'; ch <= 'z'; ch++){
				if(charArr[i] == ch)
					continue;
				charArr[i] = ch;
				String newWord = new String(charArr);
				//ֻ���һ����ĸͬʱ����������ڵĲ���Ҳ�ǵ�ǰ���ʵ���һ��
				if(path.get(newWord)!=null && (path.get(newWord)==nextDepth)){
					ArrayList<String> newPathArr = new ArrayList<String>(pathArr);
					dfs(newWord, end, dict, newPathArr, result);
				}
			}
			
			
		}
		
	}
	
	//������
	public ArrayList<ArrayList<String>> findLadders(String start,String end,HashSet<String> dict){
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		ArrayList<String> path = new ArrayList<String>();
		if(start== null || end== null || start.length()!= end.length()){
			return result;
		}
		bfs(start, end, dict);
		dfs(end, start, dict, path, result);
		return result;
	}
	
	public static void main(String[] args){
		String start = "hit";
		String end = "cog";
		HashSet<String> dict = new HashSet<String>();
		dict.add("dot");
		dict.add("hot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		
	}
}
