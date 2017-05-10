package xh.qunar;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Qunar1 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] pre = new int[n];
		int[] mid = new int[n];
		int i = 0;
		while(i < n){
			pre[i++] = sc.nextInt();
		}
		i = 0;
		while(i < n){
			mid[i++] = sc.nextInt();
		}
		i= 0;
		int[] result = new int[n];
		Node head = preInToTree(pre, mid);
		ArrayDeque<Node> que = new ArrayDeque<Node>();
		que.add(head);
		while(!que.isEmpty()){
			Node node= que.removeFirst();
			result[i++] = node.value;
			if(node.left != null){
				que.add(node.left);
			}if(node.right != null){
				que.add(node.right);
			}
		}
		for(int j = 0; j < n - 1; j++){
			System.out.print(result[j] + " ");
		}
		System.out.println(result[n-1]);
	}
	
	public static Node preInToTree(int[] pre,int[] mid){
		if(pre == null || mid == null){
			return null;
		}
		HashMap<Integer, Integer> map= new HashMap<Integer, Integer>();
		for(int i = 0; i < mid.length;i++){
			map.put(mid[i], i);
		}
		return preIn(pre, 0, pre.length-1, mid, 0, mid.length-1, map);
	}
	
	public static Node preIn(int[] p,int pi,int pj,int[] n,int ni,int nj,HashMap<Integer, Integer> map){
		if(pi > pj){
			return null;
		}
		Node head = new Node(p[pi]);
		int index = map.get(p[pi]);
		head.left = preIn(p, pi + 1,pi + index -ni , n, ni, index - 1, map);
		head.right = preIn(p, pi+index-ni + 1, pj, n, index + 1, nj, map);
		return head;
	}
	
}

class Node{
	int value;
	Node left;
	Node right;
	
	public Node(int val){
		this.value = val;
		
	}
}
