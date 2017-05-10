package xh.collection.tree;
/**
 * ����һ������N�����N<1,��������ṹ�������������������Ϊ{1,2,3,4...N}.
 * ���ؿ��ܵĶ������ṹ�ж���
 * 
 * @author Administrator
 *
 */
public class SumAndGenerateProbilities {

	public int numTrees(int n){
		//num[N]��ʾ��N���ڵ���ɵ������������Ŀ���
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
