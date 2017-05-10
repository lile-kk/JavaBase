package StringProblems;
import java.lang.System.*;

/*
 *�ַ���ƥ������
 *	�����ַ���str,���о��Բ������ַ�'.'��'*'���ٸ����ַ���exp,���п��Ժ���'.'��'*','*'�ַ�������exp���ַ���
 *������������'*'�ַ�����������exp�е�'.'�����κ�һ���ַ���'*'��ʾǰһ���ַ�������0�����߶�����ж�str�Ƿ��ܱ�expƥ�䡣 
 */
public class MatchString {
	public static void main(String[] args){
		String str = "abc";
		String exp = "a.c";
		System.out.println(new MatchString().isMatchDP(str, exp));
	}

	
	//�ж��ַ����Ƿ���Ч
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
	
	//�ݹ�⣺process(s,e,si,ei)��ʾ��str[si..len-1]�ܷ�exp[ei..len-1]ƥ��
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
	 * �ö�̬�滮��
	 * ��ά����dp[][]����process(i,j)�ķ���ֵ
	 * dp[i][j]ֻ������dp[i + 1][j + 1]����dp[i + k][j + 2](k>=0)
	 * ����ֻҪ���������·���ʼ�������󣬴������ϼ��㼴�ɵó�dp[i][j]
	 * �ȳ�ʼ��dp���һ�к�������У�����ֱ�ӵó�
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
	//��ʼ��dp����
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
