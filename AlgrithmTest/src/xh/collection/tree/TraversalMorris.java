package xh.collection.tree;

//�������������񼶷�����ʱ�临�Ӷ�O(N),�ռ临�Ӷ�O(1)

public class TraversalMorris {
	
	//�������
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
