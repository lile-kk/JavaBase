package dynamic.programming;

import java.util.Scanner;

/*
 * N�ʺ�����
 * N�ʺ�������ָ��N*N�������ϰ�N���ʺ�Ҫ���κ������ʺ�ͬ�С���ͬ�У�
 * Ҳ����ͬһб���ϡ�����һ������n������n�ʺ�İڷ��ж�����
 */
public class NPrincess {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(new NPrincess().num1(n));
	}
	
	//�Ż��ⷨ
	//��λ���㣬��Ϊ��������Ϊ�����������int�ͱ��������Ը÷���ֻ����1~32�ʺ�����
	//����������ʺ����⣬����Ҫ��������Ϊ�ı���
	public int num2(int n){
		if(n < 2|| n > 32){
			return 0;
		}
		int upperLim = n== 32? -1 : (1<<n)-1;
		return proccess2(upperLim, 0, 0, 0);	
	}
	public int proccess2(int upperLim,int colLim, int leftDiaLim, int rightDiaLim){
		if(colLim == upperLim){
			return 1;
		}
		int pos = 0;
		int mostRightOne = 0;
		pos= upperLim & (~(colLim | leftDiaLim | rightDiaLim));
		int res = 0;
		while(pos != 0){
			mostRightOne = pos & (~pos + 1);
			pos= pos - mostRightOne;
			res += proccess2(upperLim, colLim | mostRightOne, (leftDiaLim | mostRightOne)<<1,(rightDiaLim | mostRightOne) >>>1);
		}
		return res;
	}

	//��ͨ�ⷨ
	public int num1(int n){
		if(n < 1){
			return 0;
		}
		//record[i]��ʾ�ڵ�i�лʺ����ڵ�����
		int[] record = new int[n];
		return process1(0, record, n);
	}
	public int process1(int i,int[] record,int n){
		if(i== n){
			return 1;
		}
		int res = 0;
		for(int j = 0;j < n;j++){
			if(isValid(i, j, record)){
				record[i] = j;
				res += process1(i + 1, record, n);
			}
		}
		return res;
	}
	//�ж��ڵ�i��j�з��ûʺ��ǲ�����Ч��
	public boolean isValid(int i,int j,int[] record){
		for(int k = 0; k < i; k++){
			//�ݹ���㵽��i�е�j��ʱ���鿴record[0..k](k < i)��ֵ�����Ƿ�����ȵ�ֵ
			//�ڿ��Ƿ���|k-i|==|record[k] - j|
			if(record[k] == j || Math.abs(i-k)==Math.abs(record[k] - j)){
				return false;
			}
		}
		return true;
	}
}
