package StringProblems;

import java.time.chrono.MinguoChronology;
import java.util.Arrays;

/*
 * ��ת�ַ���
 * ����һ���ַ����͵�����chas��һ������size����Ѵ�СΪsize������������ƶ����Ұ������Ұ��������ƶ������
 * 
 */
public class ReverseString {
	
	public static void main(String[] args){
		String str = "1234567ABCD";
		int size = 7;
		char[] cha = str.toCharArray();
		fanzhuan1(cha, size);
		System.out.println(Arrays.toString(cha));
		cha = str.toCharArray();
		fanzhuan2(cha, size);
		System.out.println(Arrays.toString(cha));
	}
	
	//����1��ʱ�临�Ӷ�O(N),�ռ临�ӵ�O(1)
	public static void fanzhuan1(char[] chas,int size){
		if(chas == null || size <= 0 || size >=chas.length){
			return;
		}
		reverse(chas, 0, size - 1);
		reverse(chas, size, chas.length - 1);
		reverse(chas, 0, chas.length - 1);
	}
	//��ת�ַ�������i->j
		public static void reverse(char[] chas, int start, int end){
			while(start < end){
				char tmp = chas[start];
				chas[start] = chas[end];
				chas[end] = tmp;
				start++;
				end--;
			}
		}

	//����2��ʱ�临�Ӷ�<O(N),�ռ临�Ӷ�O(1)
	public static void fanzhuan2(char[] chas,int size){
		if(chas == null || size <= 0 || size >=chas.length){
			return;
		}
		int start = 0;
		int end = chas.length - 1;
		int lpart = size;
		int rpart = chas.length - size;
		int s = Math.min(lpart, rpart);
		int d = lpart - rpart;
		while(true){
			exchange(chas, start, end, s);
			if(d==0){
				break;
			}else if(d > 0){
				start += s;
				lpart = d;
			}else {
				end -= s;
				rpart = -d;
			}
			s = Math.min(lpart, rpart);
			d = lpart - rpart;
		}
		
		
	}
	
	public static void exchange(char[] chas,int start,int end,int size){
		int i = end - size + 1;
		char tmp = 0;
		while(size-- != 0){
			tmp = chas[start];
			chas[start] = chas[i];
			chas[i] = tmp;
			start++;
			i++;
		}
	}
	
}
