package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 题意说明：从start变换到end，途中只能经过字典中的单词，每次只允许差一个字母。
要求输出所有变换路径。
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
//解法：先BFS生成找到end时的生成树，标记出每个单词所在的层数。然后从目标用DFS往回找，过了大数据。
public class WordLadder {

	//记录每个单词所在的层数
	HashMap<String, Integer> path = new HashMap<String, Integer>();
	//bfs生成path
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
						//每个单词在path中只能出现一次，也就是每个单词只能出现在一层中，这样就很巧妙的解决了环的问题
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
	
	//从目标单词往回找开始单词，记录所有路径
	void dfs(String start,String end,HashSet<String> dict,ArrayList<String> pathArr,
			ArrayList<ArrayList<String>> result){
		//找到了，需要reverse加入的所有单词
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
				//只相差一个字母同时这个单词所在的层数也是当前单词的上一层
				if(path.get(newWord)!=null && (path.get(newWord)==nextDepth)){
					ArrayList<String> newPathArr = new ArrayList<String>(pathArr);
					dfs(newWord, end, dict, newPathArr, result);
				}
			}
			
			
		}
		
	}
	
	//主方法
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
