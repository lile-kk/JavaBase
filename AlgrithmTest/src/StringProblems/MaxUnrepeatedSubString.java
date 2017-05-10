package StringProblems;
/**
 * 找到字符串的最长无重复字符子串
 * 	给定一个字符串str，返回str的最长无重复字符子串的长度
 * 
 * @author Administrator
 *
 */
public class MaxUnrepeatedSubString {
	
	public static void main(String[] args){
		String str = "aabcdb";
		System.out.println(new MaxUnrepeatedSubString().maxUnique(str));
	}

	public int maxUnique(String str){
		//pre表示必须以str[i- 1]结尾的情况下，最长无重复字符子串开始的前一个位置，初始时pre=-1
		int pre = -1;
		if(str.length() == 0 || str.equals(""))
			return 0;
		char[] arr = str.toCharArray();
		int[] map = new int[256];
		for(int i = 0;i < 256; i++){
			map[i] = -1;
		}
		int cur = 0;
		int len = 0;
		for(int i = 0; i < arr.length; i++){
			pre = Math.max(pre, map[arr[i]]);
			cur = i - pre;
			len = Math.max(cur, len);
			map[arr[i]] = i; 
		}
		return len;
	}
}
