package xh.collection.tree;
/**
 * 递归实现树的前序，中序，后续遍历
 * 时间复杂度O(N),空间复杂度O(h),h为树的高度
 * @author Administrator
 *
 */
public class TraversalRecurrent {

	//前序遍历
	public void preOrder(Node head){
		if(head == null){
			return;
		}
		System.out.print(head.data);
		preOrder(head.leftChild);
		preOrder(head.rightChild);
	}
	
	//中序遍历
	public void inOrder(Node head){
		if(head == null){
			return;
		}
		
		inOrder(head.leftChild);
		System.out.print(head.data);
		inOrder(head.rightChild);
	}
	
	//后序遍历
	public void posOrder(Node head){
		if(head == null){
			return;
		}
		
		posOrder(head.leftChild);
		posOrder(head.rightChild);
		System.out.print(head.data);
	}
	
	
}
