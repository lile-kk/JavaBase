package xh.collection.tree;
/**
 * 统计完全二叉树的节点数
 * @author Administrator
 *
 */
public class WangQuanTreeNodes {
	public static void main(String[] args){
		int a[] = {1,2,3,4,5,6,7,8,9,10,11,12,13};
		Node node= TreeUtils.buildTreeWanquan(a);
		System.out.println(TreeUtils.getHight(node));
		System.out.print(sumNode(node));
	}

	

	public static int sumNode(Node node){
		if(node== null){
			return 0;
		}
		
		return bs(node, 1, TreeUtils.getHight(node));
		
	}
	public static int bs(Node node,int l,int h){
		if(l == h){
			return 1;
		}
		int rightH = TreeUtils.getHight(node.rightChild);
		if((rightH + l) == h){
			return (1<<(h - l))  + bs(node.rightChild, l + 1, h); 
		}else{
			return (1<<(h - l - 1)) + bs(node.leftChild,l + 1 , h);
		}
		
	}
	
	
}
