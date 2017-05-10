package StringProblems;

/*
 * 给定一个字符串，判断是不是整体有效的括号字符串
 * 进阶：
 * 给定一个括号字符串str，返回最长的有效括号子串
 */
public class ValidBrakets {

	public static void main(String[] args){
		String str = "(())()(";
		System.out.println(new ValidBrakets().maxLength(str));
	}
	
	//原问题：
	public boolean isValid(String str){
		if(str== null || str.equals("")){
			return false;
		}
		char[] arr = str.toCharArray();
		int count = 0;
		for(int i = 0; i < arr.length;i++){
			if(arr[i] != '(' && arr[i] != ')'){
				return false;
			}
			if(arr[i] == ')' && --count < 0){
				return false;
			}
			if(arr[i] == '('){
				count++;
			}
		}
		return count==0;
	}
	
	//进阶问题：
	//动态规划：dp[i] 表示以arr[i]结尾的最长有效字符串是多少
	public int maxLength(String str){
		if(str== null || str.equals(""))
			return 0;
		char[] arr = str.toCharArray();
		int[] dp = new int[arr.length];
		int pre = 0;
		int res = 0;
		for(int i = 1; i< arr.length; i++){
			if(arr[i] == ')'){
				pre = i - dp[i - 1] - 1;
				if(pre >= 0 && arr[pre] == '('){
					dp[i] = dp[i - 1] + 2 + (pre > 0?dp[pre - 1] : 0);
				}
			}
			res = Math.max(res, dp[i]);
		}
		return res;
	}
}
