package StringProblems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 拼接所有字符串产生字典顺序最小的大写字符串
 * 给定一个字符串类型的数组strs，请找到一种拼接顺序，使得所有的字符串拼接起来组成的
 * 大写字符串是所有可能性中字典顺序最小的，并返回这个大写字符串
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
