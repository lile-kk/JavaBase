package xh.collection.tree;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 在二叉树中找到两个节点的最近公共祖先
 * 给定一棵二叉树的头结点head,以及这棵树中的两个节点o1和o2，返回这两个节点的最近公共祖先
 * @author Administrator
 *
 */
public class TheClosestAncestor {

	public Node lowestAncestor(Node head,Node o1,Node o2){
		if(head== null || head== o1 || head==o2){
			return head;
		}
		Node left = lowestAncestor(head.leftChild,o1, o2);
		Node right = lowestAncestor(head.rightChild, o1, o2);
		if(left != null && right != null){
			return head;
		}
		return left != null ? left : right;
	}
	
	
	
}

//如果查询公共节点祖先特别频繁，想法让单挑查询的查询时间减少
	//结构一：建立二叉树中每个节点对应的父节点信息，为一张哈希表，时间复杂度为O(N)空间复杂度为O(N),
	//查询操作时间复杂度为O(h)
class Record1{
	HashMap<Node, Node> map = new HashMap<Node, Node>();
	public Record1(Node root){
		if(root != null){
			map.put(root, null);
		}
		setMap(root);
	}
	
	private void setMap(Node head){
		if(head == null){
			return;
		}
		if(head.leftChild != null){
			map.put(head.leftChild, head);
		}
		if(head.rightChild != null){
			map.put(head.rightChild, head);
		}
		setMap(head.leftChild);
		setMap(head.rightChild);
	}
	public Node query(Node o1,Node o2){
		HashSet<Node> path = new HashSet<Node>();
		while(map.containsKey(o1)){
			path.add(map.get(o1));
			o1 = map.get(o1);
		}
		while(!path.contains(o2)){
			o2 = map.get(o2);
		}
		return o2;
	}
	
}