package StringProblems;

import java.util.Deque;
import java.util.LinkedList;

/*
 * 公式字符串求值：
 * 	给定一个字符串str，str表示一个公式，公式里可能有整数，加减乘除号和左右括号，返回公式计算结果
 * 如str="3+1*4" 返回7
 */
public class FormulaString {
	
	public static void main(String[] args){
		String str = "48*((70-65)-43)+8*1";
		System.out.println(new FormulaString().getValue(str));
	}

	public int getValue(String exp){
		return value(exp.toCharArray(),0)[0];
	}
	
	//i下一个递归过程的开始位置
	public int[] value(char[] arr,int i){
		Deque<String> deq = new LinkedList<String>();
		int pre = 0;
		int[] bra = null;
		while(i < arr.length && arr[i] != ')'){
			if(arr[i] <= '9' && arr[i] >= '0'){
				pre = pre * 10 + arr[i++] - '0';
			}else if(arr[i] != '('){
				addNum(deq,pre);
				deq.addLast(String.valueOf(arr[i++]));
				pre= 0;
			}else{
				bra = value(arr, i + 1);
				pre = bra[0];
				i = bra[1] + 1;
			}
		}
		addNum(deq, pre);
		return new int[]{getNum(deq),i};
	}
	
	public void addNum(Deque<String> deq,int num){
		if(!deq.isEmpty()){
			int cur = 0;
			String top = deq.pollLast();
			if(top.equals("+") || top.equals("-")){
				deq.addLast(top);
			}else{
				cur = Integer.valueOf(deq.pollLast());
				num = top.equals("*") ? (cur * num) : (cur / num);
			}
		}
		deq.addLast(String.valueOf(num));
	}
	
	public int getNum(Deque<String> deq){
		int res = 0;
		boolean add = true;
		String cur = null;
		int num = 0;
		while(!deq.isEmpty()){
			cur = deq.pollFirst();
			if(cur.equals("+")){
				add = true;
			}else if(cur.equals("-")){
				add = false;
			}else{
				num = Integer.valueOf(cur);
				res += add ? num : (-num);
			}
		}
		
		return res;
	}
}
