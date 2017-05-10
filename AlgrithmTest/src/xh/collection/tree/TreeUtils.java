package xh.collection.tree;

import java.awt.List;
import java.util.LinkedList;

//����һ����
public class TreeUtils {

	/**
	 * �����ڲ��ڵ�
	 */
	
	private Node root;
	
	
	public TreeUtils(){
		root = null;
	}
	
	//�ݹ鴴������������
	public void buildTree(Node node,int data){
		if(root ==null){
			root = new Node(data);
		}else{
			if(data < node.data){
				//����������
				if(node.leftChild == null){
					node.leftChild = new Node(data);
				}else{
					//��ڵ㲻Ϊ��,����buildTree�������뵽��������
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
	
	//����һ����ȫ������
	public static Node buildTreeWanquan(int[] arr){
		LinkedList<Node> nodeList = new LinkedList<Node>();  
        for (int nodeIndex = 0; nodeIndex < arr.length; nodeIndex++) {  
            nodeList.add(new Node(arr[nodeIndex]));  
        }  
        // ��ǰlastParentIndex-1�����ڵ㰴�ո��ڵ��뺢�ӽڵ�����ֹ�ϵ����������  
        for (int parentIndex = 0; parentIndex < arr.length / 2 - 1; parentIndex++) {  
            // ����  
            nodeList.get(parentIndex).leftChild = nodeList.get(parentIndex * 2 + 1);  
            // �Һ���  
            nodeList.get(parentIndex).rightChild = nodeList.get(parentIndex * 2 + 2);  
        }  
        // ���һ�����ڵ�:��Ϊ���һ�����ڵ����û���Һ��ӣ����Ե����ó�������  
        int lastParentIndex = arr.length / 2 - 1;  
        // ����  
        nodeList.get(lastParentIndex).leftChild = nodeList  
                .get(lastParentIndex * 2 + 1);  
        // �Һ���,�������ĳ���Ϊ�����Ž����Һ���  
        if (arr.length % 2 == 1) {  
            nodeList.get(lastParentIndex).rightChild = nodeList  
                    .get(lastParentIndex * 2 + 2);  
        }  
        
        return nodeList.get(0);
    }  
		
	
	
	//�����ĸ߶�,
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
