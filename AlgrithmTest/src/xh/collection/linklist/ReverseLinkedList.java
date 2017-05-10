package xh.collection.linklist;
/**
 * 反转链表
 * @author Administrator
 *
 */
public class ReverseLinkedList {

	public static void main(String[] args){
		 Node head = new Node(0);  
	     Node node1 = new Node(1);  
	     Node node2 = new Node(2);  
	     Node node3 = new Node(3);  
	    head.next = node1;
	    node1.next = node2;
	    node2.next = node3;
	    Node tmp = head;
	    while (null != head) {  
            System.out.print(head.value + " ");  
            head = head.next;  
        }  
	    head = tmp;
	    ReverseLinkedList rll = new ReverseLinkedList();
	    head = rll.reversePart(head, 2, 3);
	    System.out.println("\n");
	    while (null != head) {  
            System.out.print(head.value + " ");  
            head = head.next;  
        } 
	    
	} 
	/*
	 * 反转单向链表
	 */
	public Node reverseList(Node head){
		Node pre = null;
		Node next = null;
		while(head != null){
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
	
	/*
	 * 反转双向链表
	 */
	public DoubleNode reverseDoubleList(DoubleNode head){
		DoubleNode pre = null;
		DoubleNode next = null;
		while(head != null){
			next= head.next;
			head.next = pre;
			head.last = next;
			pre = head;
			head = next;
			
		}
		return pre;
	}
	
	/*
	 * 反转部分单向链表
	 * 给定一个单向链表的头结点head，以及两个整数from 和 to,在单向链表上吧第from个节点
	 * 到第to个节点这一部分进行反转。
	 * 
	 */
	public Node reversePart(Node head,int from, int to){
		int len = 0;
		Node node1 = head;
		Node fpre = null;
		Node tpos = null;
		while(node1 != null){
			len++;
			fpre = len == from - 1 ? node1 : fpre;
			tpos = len == to + 1? node1 : tpos;
			node1 = node1.next;
		}
		if(from > to || from < 1 || to > len){
			return head;
		}
		node1= fpre == null ? head : fpre.next;
		Node node2 = node1.next;
		node1.next = tpos;
		Node next = null;
		while(node2 != tpos){
			next = node2.next;
			node2.next = node1;
			node1 = node2;
			node2 = next;
		}
		if(fpre != null){
			fpre.next = node1;
			return head;
		}
		return node1;
	}
	
	/*
	 * 将单链表的每K个节点之间逆序
	 * 方法1：用栈结构
	 * 方法2：直接在原链表中逆序（代码用此方法）
	 */
	public Node reverseKNode(Node head, int k){
		if(k < 2){
			return head;
		}
		Node cur = head;
		Node start = null;
		Node pre = null;
		Node next = null;
		int count = 1;
		while(cur != null){
			next = cur.next;
			if(count == k){
				start= pre== null ? head : pre.next;
				head = pre == null ? cur : head;
				resign(pre, start, cur, next);
				pre = start;
				count = 0;
			}
			count++;
			cur  = next;
		}
		return head;
	}
	//实现某一区间的反转
	public void resign(Node left,Node start,Node end, Node right){
		Node pre = start;
		Node cur = start.next;
		Node next = null;
		while(cur != right){
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		if(left != null){
			left.next = end;
		}
		start.next = right;
	}
		
}




class Node{
	public int value;
	public Node next;
	public Node(int data){
		this.value = data;
	}
}

class DoubleNode{
	public int value;
	public DoubleNode last = null;
	public DoubleNode next = null;
	
	public DoubleNode(int data){
		this.value = data;
	}
	
}