package xh.collection.tree;
/**
 * 给定一个整数N，如果N<1,代表空树结构，否则代表中序遍历结果为{1,2,3,4...N}.
 * 返回可能的二叉树结构有多少
 * 
 * @author Administrator
 *
 */
public class SumAndGenerateProbilities {

	public int numTrees(int n){
		//num[N]表示有N个节点组成的搜索二叉树的可能
		if(n < 2){
			return 1;
		}
		int[] num = new int[n + 1];
		num[0] = 1;
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= i; j++){
				num[i] += num[j-1] * num[i -  j]; 
			}
		}
		return num[n];
	}
}
