package dynamic.programming;
/**
 * 

给定三个字符串str1、str2和aim。
如果aim包含且仅包含来自str1和str2的所有字符，
而且在aim中属于str1的字符之间保持原来在str1中的顺序，
属于str2的字符之间保持原来在str2中的顺序，那么称aim是str1和str2的交错组成。
实现一个函数，判断aim是否是str1和str2交错组成。
【举例】
str1=“AB”，str2=“12”。那么“AB12”、“A1B2”、“A12B”、“1A2B”和“1AB2”等等都是str1和str2交错组成。
 * @author Administrator
 *
 */
public class StringCross {
	public static void main(String[] args){
		String str1 = "AB";
		String str2 = "12";
		String aim = "AB12";
		System.out.println(isCross2(str1, str2, aim));
	}
	
	/**
	 * 动态规划方法，时间复杂度为O(M*N)，空间复杂度O(M*N)，结合空间压缩方法，可以将空间复杂度降为O(min{M,N})
	 * dp[i][j]表示用str1[0..i-1]与str2[0..j-1]是否能组成aim[i+j-1];
	 * 
	 */
	public static boolean isCross1(String str1,String str2,String aim){
		if(str1 ==null || str2 == null || aim == null){
			return false;
		}
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();
		char[] chaim = aim.toCharArray();
		if((ch1.length + ch2.length) != chaim.length){
			return false;
		}
		boolean dp[][] = new boolean[ch1.length + 1][ch2.length + 1];
		dp[0][0] = true;
		for (int i = 1; i <= ch1.length; i++) {
			if(ch1[i-1] != chaim[i-1]){
				break;
			}
			dp[i][0] = true;
			
		}
		for (int i = 1; i <= ch2.length; i++) {
			if(ch2[i-1] != chaim[i-1]){
				break;
			}
			dp[0][i] = true;
			
		}
		for (int i = 1; i <= ch1.length; i++) {
			for (int j = 0; j <= ch2.length; j++) {
				if(ch1[i-1] == chaim[i + j - 1] && dp[i-1][j]
						|| (ch2[j-1] == chaim[i + j - 1]&&dp[i][j-1])){
					dp[i][j] = true;
				}
			}
			
		}
		return dp[ch1.length][ch2.length];
	}
	
	//使用空间压缩方法，将空间复杂度降到O(min{M,N})，将M，N中较少的一项作为列
	public static boolean isCross2(String str1,String str2,String aim){
		if(str1 ==null || str2 == null || aim == null){
			return false;
		}
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();
		char[] chaim = aim.toCharArray();
		if((ch1.length + ch2.length) != chaim.length){
			return false;
		}
		char[] longs = ch1.length >= ch2.length ? ch1:ch2;
		char[] shots = ch1.length < ch2.length ? ch1:ch2;
		boolean dp[] = new boolean[shots.length+1];
		dp[0] = true;
		for(int i = 1; i <= shots.length; i++){
			if(shots[i-1] != chaim[i-1]){
				break;
			}
			dp[i] = true;
		}
		for(int i = 1; i <= longs.length; i++){
			dp[0] = dp[0] && longs[i - 1] == chaim[i - 1];
			for (int j = 0; j <= shots.length; j++) {
				if(longs[i-1] == chaim[i+j-1] && dp[j] 
						||(shots[j-1] == chaim[i+j-1] &&dp[j-1])){
					dp[j] = true;
				}else {
					dp[j] = false;
				}
			}
		}
		return dp[shots.length];
	}
	
	
	
}
