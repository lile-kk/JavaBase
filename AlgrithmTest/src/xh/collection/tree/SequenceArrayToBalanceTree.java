package xh.collection.tree;
/**
 * 根据有序数组生成平衡搜索二叉树
 * 给定一个有序数组sortArr，已知没有重复值，用这个有序数组生成一颗平衡搜索二叉树
 * 并且该搜索二叉树的中序遍历结果和该sortArr一致
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
