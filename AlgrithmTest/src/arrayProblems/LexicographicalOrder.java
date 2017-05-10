package arrayProblems;

import java.util.ArrayList;
import java.util.List;

/*
 * �����鰴�ֵ�����
 * Given an integer n, return 1 - n in lexicographical order.

For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 */
public class LexicographicalOrder {

	public  List<Integer> lexicalOrger(int n) {
		List<Integer> res = new ArrayList<Integer>();
		int cur = 1;
		for(int i = 1; i<=n; i++){
			res.add(cur);
			if(cur * 10 <= n)
				cur= cur * 10;
			else if(cur % 10 != 9 && cur + 1 <= n)
				cur++;
			else{
				while((cur / 10) % 10 == 9){
					cur = cur / 10;
				}
				cur = cur / 10 + 1;
			}
		}
		return res;
	}
	
	
	//���ף�
	/*
	 * Given integers n and k, find the lexicographically k-th smallest integer in the range from 1 to n.

Note: 1 �� k �� n �� 109.

Example:

Input:
n: 13   k: 2

Output:
10

Explanation:
The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.
	 */
	/**
	 *�ⷨ��
	 *����ʮ��������������ĵ�K���ڵ㼴Ϊ����
	 *1.�ҳ�cur��cur+1֮���ж��ٸ��ڵ�->steps
	 *2.���steps <= k�� k=k-steps,˵�������ƶ���cur+1
	 *3.���steps>k,�����ƶ���cur+1,ֻ��������һ��cur*10
	 *��μ���steps:calSteps����
	 *	��n1=cur,n2=cur+1��n2������n1���������ҽڵ���ұ�
	 *	��� n2 <= n,����n1���������ڣ����ǿ���ֱ�Ӵ�n1�ƶ���n2
	 *	���n2 > n,֤��n��n1��n2֮�䣬steps = (n + 1 -n1)
	 *	�������ж���һ��,steps += Math.min��n + 1,n2��-n1;n1 *= 10,n2 *= 10
	 */
	public int findKthNumber(int n, int k){
		int cur = 1;
		k = k - 1;
		while(k > 0){
			int steps = calSteps(n, cur, cur + 1);
			if(steps <= k){
				cur += 1;
				k -= steps;
			}else {
				cur *= 10;
				k -= 1;
			}
		}
		return cur;
	}
	public int calSteps(int n, long n1, long n2){
		int steps = 0;
		while(n1 < n){
			steps += Math.min(n + 1, n2) - n1;
			n1 *= 10;
			n2 *= 10;
		}
		return steps;
	}
	
	public static void main(String[] args){
		int n = 13;
		int result = new LexicographicalOrder().findKthNumber(13, 6);
		System.out.println(result);
		
	}
}
