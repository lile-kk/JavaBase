package xh.collection.tree;

import java.util.Stack;

/**
 * 不用递归的方式实现树的前序，中序，后序遍历
 * 时间复杂度O(N),空间复杂度O(h),h为树的高度
 * @author Administrator
 *
 */
public class TraversalNoRecurrent {
	
	//前序遍历
	public void preOrder(Node head){
		if(head ==null){
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		stack.add(head);
		while(!stack.isEmpty()){
			head = stack.pop();
			System.out.print(head.data);
			if(head.rightChild != null){
				stack.push(head.rightChild);
			}
			if(head.leftChild != null){
				stack.push(head.leftChild);
			}
		}
	}
	
	//中序遍历
	public void inOrder(Node head){
		if(head != null){
			Stack<Node> stack = new Stack<Node>();
			while(!stack.isEmpty() || head != null){
				if(head != null){
					stack.push(head);
					head = head.leftChild;
				}else{
					head = stack.pop();
					System.out.print(head.data);
					head = head.rightChild;
				}
			}
		}
	}
	
	//后序遍历
	public void posOrder(Node head){
		if(head != null){
			Stack<Node> s1 = new Stack<Node>();
			Stack<Node> s2 = new Stack<Node>();
			s1.push(head);
			while(!s1.isEmpty()){
				head = s1.pop();
				s2.push(head);
				if(head.leftChild != null){
					s1.push(head.leftChild);
				}
				if(head.rightChild != null){
					s1.push(head.rightChild);
				}
				
			while(!s2.isEmpty()){
				System.out.print(s2.pop());
			}
			}
		}
	}
	

}
