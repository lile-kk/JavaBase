package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//宽度优先遍历
public class DFSErgodic {
	static int count = 0;

	//Breadth first search
	public static void bfs(HashMap<Character, LinkedList<Character>> graph,HashMap<Character, Integer> dist,char start){
		Queue<Character> q = new LinkedList<Character>();
		q.add(start);
		dist.put(start, 0);
		int i = 0;
		while(!q.isEmpty()){
			char top = q.poll();
			i++;
			System.out.println("The "+i+"th element:"+top+" Distance from s is:"+dist.get(top));
			int d = dist.get(top) + 1;
			for(Character c : graph.get(top)){
				if(!dist.containsKey(c)){
					dist.put(c, d);
					q.add(c);
				}
			}
		}
	}
	
	
	//深度优先遍历，非递归
	public void dfs(int[][] edges,int number,String[] vertexs){
		 boolean[] flag = new boolean[number];
	     Stack<Integer> stack =new Stack<Integer>();
	     for(int i=0;i<number;i++){
	            if(flag[i]==false){
	                flag[i]=true;
	                System.out.print(vertexs[i]+" ");
	                stack.push(i);
	            }
	            while(!stack.isEmpty()){
	                int k = stack.pop();
	                for(int j=0;j<number;j++){
	                    if(edges[k][j]==1&&flag[j]==false){
	                        flag[j]=true;
	                        System.out.print(vertexs[j]+" ");
	                        stack.push(j);
	                        break;
	                    }
	                }

	            }
	        }
	}
	
	//深度优先遍历
	public static void dfs(HashMap<Character, LinkedList<Character>> graph,HashMap<Character, Boolean> visited){
		visit(graph, visited, 'u');
	}
	
	public static void visit(HashMap<Character, LinkedList<Character>> graph,HashMap<Character, Boolean> visited,
			char start){
		if(!visited.containsKey(start)){
			count++;
			System.out.println("The element:" + start);
			visited.put(start, true);
			for (char c: graph.get(start)) {
				if(!visited.get(c))
					visit(graph,visited,c);
			}
			count++;
		}
	}
	
	public static void main(String[] args){
		int number = 9;  
	    boolean[] flag;  
	    String[] vertexs = { "A", "B", "C", "D", "E", "F", "G", "H", "I" };  
	    int[][] edges = {   
	            { 0, 1, 0, 0, 0, 1, 1, 0, 0 }, 
	            { 1, 0, 1, 0, 0, 0, 1, 0, 1 }, 
	            { 0, 1, 0, 1, 0, 0, 0, 0, 1 },  
	            { 0, 0, 1, 0, 1, 0, 1, 1, 1 }, 
	            { 0, 0, 0, 1, 0, 1, 0, 1, 0 }, 
	            { 1, 0, 0, 0, 1, 0, 1, 0, 0 },  
	            { 0, 1, 0, 1, 0, 1, 0, 1, 0 }, 
	            { 0, 0, 0, 1, 1, 0, 1, 0, 0 }, 
	            { 0, 1, 1, 1, 0, 0, 0, 0, 0 }   
	            };  
	    new DFSErgodic().dfs(edges, number, vertexs);
	}
	
	
}
