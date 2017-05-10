package dynamic.programming;

import xh.math.NciFang;

/*
 * 쳲�����ϵ������ĵݹ�Ͷ�̬�滮
 */
public class Fibonacci {

	/*
	 * �ݹ��ʱ�临�Ӷ�ΪO(2��N�η�)
	 */
	public int f1(int n){
		if(n < 1)
			return 0;
		if(n== 1 || n == 2)
			return 1;
		return f1(n - 1) + f1(n - 2);
	}
	//�ǵݹ�ʵ�֣�ʱ�临�Ӷ�O(N)
	public int f2(int n){
		if( n < 1)
			return 0 ;
		if(n == 1 || n == 2)
			return 1;
		int res = 1;
		int pre = 1;
		int tmp = 0;
		for(int i = 3; i <= n; i++){
			tmp = res;
			res= res + pre;
			pre = tmp;
		}
		return res;
	}
	
	/*
	 * ��̬�滮��ʱ�临�Ӷ�log(N),ת��Ϊi*i��״̬����
	 */
	public int f3(int n){
		if(n < 1)
			return 0;
		if(n == 1 || n == 2)
			return 1;
		int[][] base = {{1,1},{1,0}};
		int[][] res = NciFang.matrixPower(base, n - 2);
		return res[0][0] + res[1][0];
	}
	
	public static void main(String[] args){
		Fibonacci fb = new Fibonacci();
		System.out.println(fb.f1(9));
		System.out.println(fb.f2(9));
		System.out.println(fb.f3(9));
	}
}
