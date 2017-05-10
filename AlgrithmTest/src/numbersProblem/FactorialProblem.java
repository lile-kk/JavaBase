package numbersProblem;
/*
 * ���ڽ׳˵���������
 * ����һ���Ǹ�����N������N�����ĩβΪ0������
 * ��ת��Ϊ1,2,3������N���ж��ٸ�����5����Ϊ5*2  = 10����2������һ����5�࣬��������˶��ٸ�5���൱������˶��ٸ�0
 */
public class FactorialProblem {
	
	public static void main(String[] args){
		FactorialProblem fac = new FactorialProblem();
		System.out.println(fac.rightOne2(1000000000));
	}
	//��1~N��5�����ӵĸ���
	public int fiveNum(int num){
		if(num < 0)
			return 0;
		int res = 0;
		while(num != 0){
			res += num / 5;
			num /= 5;
		}
		return res;
	}

	//���ף�����һ���Ǹ�����N������ö����Ʊ�ʾN���Ľ�����������λ��1���ĸ�λ����
	/**
	 * �ⷨ1���������������ƣ���ԭ�������ж��ٸ�2
	 */
	public int rightOne1(int num){
		if(num < 1)
			return -1;
		int res = 0;
		while(num != 0){
			num >>>= 1;
			res += num;
		}
		return res;
	}
	/**
	 * �ⷨ2��N!����е�����2���ܸ�����ΪZ��N�Ķ����Ʊ��ʽ��1�ĸ���Ϊm����z= N-m
	 */
	public int rightOne2(int num){
		if(num < 1)
			return -1;
		int ones = 0;
		int tmp = num;
		while(tmp != 0){
			ones += (tmp & 1) != 0 ? 1 : 0;
			tmp >>>= 1;
		}
		return num - ones;
	}
}
