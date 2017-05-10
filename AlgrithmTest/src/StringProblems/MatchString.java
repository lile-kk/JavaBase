package StringProblems;
import java.lang.System.*;

/*
 *字符串匹配问题
 *	给定字符串str,其中绝对不含有字符'.'和'*'。再给定字符串exp,其中可以含有'.'或'*','*'字符不能是exp首字符，
 *并且任意两个'*'字符不能相连。exp中的'.'代表任何一个字符，'*'表示前一个字符可以有0个或者多个，判断str是否能被exp匹配。 
 */
public class MatchString {
	public static void main(String[] args){
		String str = "abc";
		String exp = "a.c";
		System.out.println(new MatchString().isMatchDP(str, exp));
	}

	
	//判断字符串是否有效
	public boolean isValid(char[] str,char[] exp){
		for(int i = 0; i < str.length; i++){
			if(str[i] == '.' || str[i] == '*')
				return false;
		}
		for(int i = 0; i < exp.length; i++){
			if(exp[i] == '*' &&(i == 0 || exp[i - 1] == '*'))
				return false;
		}
		return true;
	}
	
	//递归解：process(s,e,si,ei)表示从str[si..len-1]能否被exp[ei..len-1]匹配
	public boolean isMatch(String str,String exp){
		if(str == null || exp == null)
			return false;
		char[] s = str.toCharArray();
		char[] e = exp.toCharArray();
		return isValid(s, e) ? process(s, e, 0, 0) : false;
		
	}
	public boolean process(char[] s,char[] e,int si, int ei){
		if(ei == e.length)
			return si == s.length;
		if(ei + 1 == e.length || e[ei + 1] != '*'){
			return si != s.length && (e[ei] == s[si] || e[ei] == '.')
					&&process(s, e, si+1, ei+1);
		}
		
		while(si != s.length && (e[ei] == s[si]) || e[ei] == '.'){
			if(process(s, e, si, ei + 2)){
				return true; 
			}
			si++;
		}
		return process(s, e, si, ei + 2);
	}
	/*
	 * 用动态规划解
	 * 二维数组dp[][]代表process(i,j)的返回值
	 * dp[i][j]只依赖于dp[i + 1][j + 1]或者dp[i + k][j + 2](k>=0)
	 * 所以只要从数组右下方开始从右往左，从下往上计算即可得出dp[i][j]
	 * 先初始化dp最后一行和最后两列，可以直接得出
	 */
	public boolean isMatchDP(String str,String exp){
		if(str == null || exp == null)
			return false;
		char[] s = str.toCharArray();
		char[] e = exp.toCharArray();
		if(!isValid(s, e)){
			return false;
		}
		boolean[][] dp = initDPMap(s, e);
		for(int i = s.length - 1; i > -1;i--){
			for(int j = s.length - 2; j > -1; j--){
				if(e[j + 1] != '*'){
					dp[i][j] = (s[i] == e[j] || e[j] == '.' ) && dp[i + 1][j + 1];
				} else{
					int index = i;
					while(index != s.length && (s[index] == e[j]) || e[j] == '.'){
						if(dp[index][j + 2]){
							dp[i][j] = true;
							break;
						}
						index++;
					}
					if(dp[i][j] != true)
						dp[i][j] = dp[index][j + 2];
				}
			}
		}
		return dp[0][0];
	}
	//初始化dp数组
	public boolean[][] initDPMap(char[] s, char[] e){
		int slen = s.length;
		int elen = e.length;
		boolean[][] dp = new boolean[slen + 1][ elen + 1];
		dp[slen][elen] = true;
		for(int j = elen - 2; j > -1; j -= 2){
			if(e[j] != '*' && e[j + 1] == '*')
			dp[slen][j] = true;
			else 
				break;
		}
		if(slen > 0 && elen > 0){
			if((e[elen - 1] == '.' || s[slen - 1] == e[elen - 1]))
				dp[slen - 1][elen - 1] = true;
		}
		return dp;
	}
	
}
