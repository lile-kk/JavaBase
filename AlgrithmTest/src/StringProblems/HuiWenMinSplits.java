package StringProblems;
/*
 * 回文最少分割数
 * 	给定一个字符串str,返回把str全部切成回文子串的最小分割数
 */
public class HuiWenMinSplits {
	
	public static void main(String[] args){
		String str = "ACDCDCDAD";
		System.out.println(new HuiWenMinSplits().minSplits(str));
	}

	public int minSplits(String str){
		if(str == null || str.equals(""))
			return 0;
		char[] arr = str.toCharArray();
		int len = arr.length;
		/*动态转移：dp[i]表示arr[i..len-1]分成回文子串的最小分割数\
		 * dp[i] = min{dp[j] + 1,i < j < len-1}
		 */
		int[] dp = new int[len + 1];
		dp[len] = -1;
		/*
		 * 二维数组p[i][j]表示arr[i..j]是否为回文字符串
		 * i..j有三种情况：
		 * 如果只有一个字符，则为true；
		 * 如果有两个字符，且两个字符相等，为true；
		 * 如果大于两个字符，if str[i+1..j-1]为回文字符串，即p[i+ 1][j-1]为true，且str[i]==str[j],则p[i][j]=true;
		 */
		boolean[][] p = new boolean[len][len];
		for(int i = len - 1; i >= 0; i--){
			dp[i] = Integer.MAX_VALUE;
			for(int j = i; j < len; j++){
				if(arr[i] == arr[j] && ((j - i) < 2 || p[i + 1][ j - 1])){
					p[i][j] = true;
					dp[i] = Math.min(dp[i], dp[j + 1] + 1);
				}
			}
		}
		return dp[0];
		
		
	}
}
