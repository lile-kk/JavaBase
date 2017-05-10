package xh.collection.tree;

import java.awt.List;
import java.util.LinkedList;

//创建一棵树
public class TreeUtils {

	/**
	 * 创建内部节点
	 */
	
	private Node root;
	
	
	public TreeUtils(){
		root = null;
	}
	
	//递归创建二叉搜索树
	public void buildTree(Node node,int data){
		if(root ==null){
			root = new Node(data);
		}else{
			if(data < node.data){
				//插入左子树
				if(node.leftChild == null){
					node.leftChild = new Node(data);
				}else{
					//左节点不为空,调用buildTree函数插入到左子树中
					buildTree(node.leftChild,data);
				}
			}else{
				if(node.rightChild == null){
					node.rightChild = new Node(data);
				}else{
					buildTree(node.rightChild,data);
				}
			}
		}
	}
	
	//创建一颗完全二叉树
	public static Node buildTreeWanquan(int[] arr){
		LinkedList<Node> nodeList = new LinkedList<Node>();  
        for (int nodeIndex = 0; nodeIndex < arr.length; nodeIndex++) {  
            nodeList.add(new Node(arr[nodeIndex]));  
        }  
        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树  
        for (int parentIndex = 0; parentIndex < arr.length / 2 - 1; parentIndex++) {  
            // 左孩子  
            nodeList.get(parentIndex).leftChild = nodeList.get(parentIndex * 2 + 1);  
            // 右孩子  
            nodeList.get(parentIndex).rightChild = nodeList.get(parentIndex * 2 + 2);  
        }  
        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理  
        int lastParentIndex = arr.length / 2 - 1;  
        // 左孩子  
        nodeList.get(lastParentIndex).leftChild = nodeList  
                .get(lastParentIndex * 2 + 1);  
        // 右孩子,如果数组的长度为奇数才建立右孩子  
        if (arr.length % 2 == 1) {  
            nodeList.get(lastParentIndex).rightChild = nodeList  
                    .get(lastParentIndex * 2 + 2);  
        }  
        
        return nodeList.get(0);
    }  
		
	
	
	//求树的高度,
	public static int  getHight(Node root){
		Node node= root;
		int h = 1;
		if(node== null){
			return 0;
		}
		while(node.leftChild != null)
		{
			h++;
			node = node.leftChild;
		}
		return h;
	}
	
	public static Node treeInstance(){
		int[] a = {2,4,12,45,21,6,8,5};
		TreeUtils ct = new TreeUtils();
		for(int i = 1;i < a.length;i++){
			ct.buildTree(ct.root, a[i]);
		}
		return ct.root;
	}
}

class Node{
	 Node leftChild;
	 Node rightChild;
	 int data;
	
	public Node(int i){
		this.data = i;
	}
}
