package numbersProblem;
/*
 * 关于阶乘的两个问题
 * 给定一个非负整数N，返回N结果的末尾为0的数量
 * ：转换为1,2,3，··N中有多少个因子5，因为5*2  = 10，且2的因子一定比5多，所以求除了多少个5就相当于求出了多少个0
 */
public class FactorialProblem {
	
	public static void main(String[] args){
		FactorialProblem fac = new FactorialProblem();
		System.out.println(fac.rightOne2(1000000000));
	}
	//求1~N中5的因子的个数
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

	//进阶：给定一个非负整数N，如果用二进制表示N！的结果，返回最低位的1在哪个位置上
	/**
	 * 解法1：跟上述问题类似：求原问题中有多少个2
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
	 * 解法2：N!结果中的因子2的总个数即为Z，N的二进制表达式中1的个数为m，则z= N-m
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
