package xh.collection.tree;

import java.util.HashMap;
import java.util.HashSet;

/**
 * �ڶ��������ҵ������ڵ�������������
 * ����һ�ö�������ͷ���head,�Լ�������е������ڵ�o1��o2�������������ڵ�������������
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

//�����ѯ�����ڵ������ر�Ƶ�����뷨�õ�����ѯ�Ĳ�ѯʱ�����
	//�ṹһ��������������ÿ���ڵ��Ӧ�ĸ��ڵ���Ϣ��Ϊһ�Ź�ϣ��ʱ�临�Ӷ�ΪO(N)�ռ临�Ӷ�ΪO(N),
	//��ѯ����ʱ�临�Ӷ�ΪO(h)
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