package xh.collection.tree;

//二叉树遍历的神级方法，时间复杂度O(N),空间复杂度O(1)

public class TraversalMorris {
	
	//中序遍历
	public void morrisIn(Node head){
		if(head == null){
			return;
		}
		
		Node cur = head;
		Node temp = null;
		while(cur != null){
			temp = cur.leftChild;
			if(temp != null){
				while(temp.rightChild != null && temp.rightChild != cur){
					temp = temp.rightChild;
				}
				if(temp.rightChild == cur){
					temp.rightChild = null;
				}else if(temp.rightChild == null){
					temp.rightChild = cur;
					cur = cur.leftChild;
					continue;
				}
			}
			
			System.out.println(cur.data);
			cur = cur.rightChild;
			
		}
	}
	
	public static void main(String[] args){
		Node root = TreeUtils.treeInstance();
		TraversalMorris tm = new TraversalMorris();
		tm.morrisIn(root);
		
	}

}
