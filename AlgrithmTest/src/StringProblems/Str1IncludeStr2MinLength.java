package StringProblems;

import java.util.HashMap;

/*
 * 最小包含子串的长度
 * 给定字符串str1和str2，求str1的子串中含有str2所有字符的最小子串长度
 * P288
 */
public class Str1IncludeStr2MinLength {
	public static void main(String[] args){
		String str1 = "adabbca";
		String str2 = "abc";
		System.out.println(new Str1IncludeStr2MinLength().minLength(str1, str2));
	}

	public int minLength(String str1,String str2){
		if(str1==null || str2 == null || str1.length() < str2.length()){
			return 0;
		}
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		int[] map = new int[256];
		for(int i = 0; i < arr2.length; i++){
			map[arr2[i]]++;
		}
		int left = 0;
		int right = 0;
		int match = arr2.length;
		int minLen = Integer.MAX_VALUE;
		while(right != arr1.length){
			map[arr1[right]]--;
			if(map[arr1[right]] >= 0){
				match--;
			}
			if(match == 0){
				while(map[arr1[left]] < 0){
					map[arr1[left++]]++;
				}
				minLen = Math.min(minLen, right - left + 1);
				match++;
				map[arr1[left++]]++;
			}
			right++;
		}
		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}
}
