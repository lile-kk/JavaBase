package string;
/*
 * 5.字符串中最长的回文字符子串
 */
public class LongestPalindromicSubstring {
	private int lo,maxlen;
	
	public static void main(String[] args){
		String str = "babad";
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		System.out.println(lps.getLongest(str));
	}
	
	//别人家的答案
	public String longestpalindrome(String s){
		int len = s.length();
		if(len < 2)
			return s;
		for(int i = 0; i < len - 1; i++){
			extendPalindrome(s, i, i);
			extendPalindrome(s, i, i + 1);
		}
		return s.substring(lo,lo + maxlen);
	}
	private void extendPalindrome(String s, int j, int k){
		while(j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)){
			j--;
			k++;
		}
		if(maxlen < k - j - 1){
			lo = j + 1;
			maxlen = k - j - 1;
		}
	}
	
	
	
	/**
	 * my answer
	 * @param str
	 * @return
	 */
	public String getLongest(String str){
		boolean[][] dp = isPalindromic(str);
		int start = -1;
		int len = 0;
		for(int i = 0; i < str.length(); i++){
			for(int j = i; j < str.length();j++){
				if(dp[i][j]){
					if((j - i + 1) > len){
						len = j- i + 1;
						start = i;
					}
				}
			}
		}
		return str.substring(start, start + len);
		
	}

	//dp[i][j]表示arr[i..j]是否为回文字符串
	public boolean[][] isPalindromic(String str){
		boolean[][] res = new boolean[str.length()][str.length()];
		char[] arr = str.toCharArray();
		for(int i = arr.length - 1; i >= 0; i--){
			res[i][i] = true;
			for(int j = i + 1; j < arr.length; j++){
				if(arr[i] == arr[j] && (j - i < 2 || res[i + 1][j - 1]))
					res[i][j] = true;
			}
		}
		return res;
	}
	
	
}
