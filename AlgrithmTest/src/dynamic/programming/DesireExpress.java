package dynamic.programming;

import java.util.Scanner;

import javax.lang.model.element.Element;

/**
 * ����һ��ֻ��(0,1,&,|��^)�����ַ���ɵ��ַ���express���ڸ���һ������ֵdesired��
 * ����express���ж�������Ϸ�ʽ�����Դﵽdesired�Ľ����
 * ��express = "1^0|0|1",desired = false;
 * ֻ��1^((0|0)|1)��1^(0|(0|1))����Ͽ��Եõ�false������2
 * @author Administrator
 *
 */
public class DesireExpress {
	public static void main(String[] args){
		DesireExpress de = new DesireExpress();
		Scanner sc = new Scanner(System.in);
		String express = sc.nextLine();
		boolean desired = sc.nextBoolean();
		System.out.println(de.num2(express, desired));
	}
	
	//���䷨���Ѽ��㹤���е�״̬������
	public int num2(String express,boolean desired){
		if(express == null||express.equals("")){
			return 0;
		}
		char[] exp = express.toCharArray();
		if(!isValid(exp)){
			return 0;
		}
		int[][] t = new int[exp.length][exp.length];
		int[][] f = new int[exp.length][exp.length];
		
		//t[i][j]��ʾexp[i][j]���true������
		t[0][0] = exp[0] == '1' ? 1 : 0;
		f[0][0] = exp[0] == '1' ? 0 : 1;
		
		for(int i = 2; i < exp.length; i++){
			t[i][i] = exp[i] == '0' ? 0 : 1;
			f[i][i] = exp[i] == '0' ? 1 : 0;
			for(int j = i - 2; j >= 0; j -= 2){
				for(int k = j; k < i; k += 2){
					if(exp[k+1] == '&'){
						t[j][i] += t[j][k] * t[k + 2][i];
						f[j][i] += t[j][k]*f[k+2][i] + f[j][k]*t[k+2][i] + f[j][k]*f[k+2][i];
					}else if(exp[k + 1] == '|'){
						t[j][i] += t[j][k] * t[k + 2][i] + t[j][k]*f[k+2][i] + f[j][k]*t[k+2][i];
						f[j][i] += f[j][k]*f[k+2][i];
					}else {
						t[j][i] += t[j][k]*f[k+2][i] + f[j][k]*t[k+2][i];
						f[j][i] += f[j][k]*f[k+2][i] + t[j][k] * t[k + 2][i];
					}
					
				}
			}
		}
		
		return desired ? t[0][exp.length-1] : f[0][exp.length - 1];
	}
	
	//�ж�express�ж����֣�������������ܵ�ʱ�临�Ӷ�ΪO(N!),�ռ临�Ӷ�ΪO(N),��Ϊ����ջ�Ĵ�С��N
	public int num1(String express,boolean desired){
		if(express == null||express.equals("")){
			return 0;
		}
		char[] exp = express.toCharArray();
		if(!isValid(exp)){
			return 0;
		}
		return p(exp, desired, 0, exp.length - 1);
	}
	
	public int p(char[] exp,boolean desired,int l,int r){
		if(l == r){
			if(exp[l] == '1'){
				return desired ? 1 : 0;
			}else{
				return desired ? 0 : 1;
			}
		}
		int res = 0;
		if(desired){
			for(int i = l + 1; i < r; i += 2){
				switch (exp[i]) {
				case '&':
					res += p(exp, true, l, i - 1)*p(exp, true, i + 1, r);
					break;
				case '|':
					res += p(exp, true, l, i - 1)*p(exp, true, i + 1, r);
					res += p(exp, true, l, i - 1) * p(exp, false, i + 1, r);
					res += p(exp, false, l, i - 1) * p(exp, true, i + 1, r);
					break;
				case '^':
					res += p(exp, true, l, i - 1) * p(exp, false, i + 1, r);
					res += p(exp, false, l, i - 1) * p(exp, true, i + 1, r);
					break;
				default:
					break;
				}
			}
		}else{
			for (int i = l + 1; i < r; i += 2) {
				switch (exp[i]) {
				case '&':
					res += p(exp, false, l, i - 1) * p(exp, true, i + 1, r);
					res += p(exp, true, l, i - 1) * p(exp, false, i + 1, r);
					res += p(exp, false, l, i - 1) * p(exp, false, i + 1, r);
					break;
				case '|':
					res += p(exp, false, l, i - 1) * p(exp,false, i + 1, r);
					break;
				case '^':
					res += p(exp, true, l, i - 1) * p(exp, true, i + 1, r);
					res += p(exp, false, l, i - 1) * p(exp, false, i + 1, r);
					break;
				}
			}
		}
		return res;
	}

	//�жϱ��ʽ�Ƿ���Ч
	public boolean isValid(char[] exp){
		if(exp.length % 2 == 0){
			return false;
		}
		for(int i = 0; i < exp.length; i+=2){
			if((exp[i] != '1') && (exp[i] != '0')){
				return false;
			}
		}
		for(int i = 1; i < exp.length; i+=2){
			if((exp[i] != '|') && (exp[i] != '^')&&(exp[i] != '&')){
				return false;
			}
		}
		return true;
	}
}

