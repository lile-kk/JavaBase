package xh.collection.tree;
/**
 * ����������������ƽ������������
 * ����һ����������sortArr����֪û���ظ�ֵ�������������������һ��ƽ������������
 * ���Ҹ������������������������͸�sortArrһ��
 * @author Administrator
 *
 */
public class SequenceArrayToBalanceTree {
	public static void main(String[] args){
		int a[] = {5,3,4,6,9,7,2};
		Node root = new SequenceArrayToBalanceTree().generaTree(a);
		new TraversalNoRecurrent().inOrder(root);
	}
	public Node generaTree(int[] sortArr){
		if(sortArr == null){
			return null;
		}
		return generate(sortArr, 0, sortArr.length - 1);
	}
	
	public Node generate(int[] sortArr,int start, int end){
		if(start > end){
			return null;
		}
		int mid = (start + end) / 2;
		Node head = new Node(sortArr[mid]);
		head.leftChild = generate(sortArr, start, mid - 1);
		head.rightChild = generate(sortArr, mid + 1, end);
		return head;
	}
}
