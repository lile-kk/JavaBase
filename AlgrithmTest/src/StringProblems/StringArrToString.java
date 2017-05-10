package StringProblems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * ƴ�������ַ��������ֵ�˳����С�Ĵ�д�ַ���
 * ����һ���ַ������͵�����strs�����ҵ�һ��ƴ��˳��ʹ�����е��ַ���ƴ��������ɵ�
 * ��д�ַ��������п��������ֵ�˳����С�ģ������������д�ַ���
 * @author Administrator
 *
 */
public class StringArrToString implements Comparator<String> {
	public static void main(String[] args){
		String[] strs = {"b","ba","abc"};
		System.out.println(new StringArrToString().lowestString(strs));
	}

	@Override
	public int compare(String a, String b) {
		return (a+b).compareTo(b + a);
	}
	public String lowestString(String[] strs){
		if(strs.length == 0 || strs == null)
			return "";
		
		Arrays.sort(strs, new StringArrToString());
		String res = "";
		for(int i = 0; i < strs.length; i++){
			res += strs[i];
		}
		return res;
	}
	

}
