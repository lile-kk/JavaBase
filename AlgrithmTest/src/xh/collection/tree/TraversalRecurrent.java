package xh.collection.tree;
/**
 * �ݹ�ʵ������ǰ�����򣬺�������
 * ʱ�临�Ӷ�O(N),�ռ临�Ӷ�O(h),hΪ���ĸ߶�
 * @author Administrator
 *
 */
public class TraversalRecurrent {

	//ǰ�����
	public void preOrder(Node head){
		if(head == null){
			return;
		}
		System.out.print(head.data);
		preOrder(head.leftChild);
		preOrder(head.rightChild);
	}
	
	//�������
	public void inOrder(Node head){
		if(head == null){
			return;
		}
		
		inOrder(head.leftChild);
		System.out.print(head.data);
		inOrder(head.rightChild);
	}
	
	//�������
	public void posOrder(Node head){
		if(head == null){
			return;
		}
		
		posOrder(head.leftChild);
		posOrder(head.rightChild);
		System.out.print(head.data);
	}
	
	
}
