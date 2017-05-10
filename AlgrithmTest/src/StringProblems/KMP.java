package StringProblems;
/**
 * KMP算法求一个字符串中是否包含另一个字符串
 * 两字符串str_N,match_M，
 * 算法负责度为O(N)
 * @author Administrator
 *
 */
public class KMP {
	
	public static void main(String[] args){
		String str = "string";
		String match = "sti";
		String match2 = "bcc";
		System.out.println(new KMP().getIndexOf(str, match));
		System.out.println(new KMP().getIndexOf(str, match2));
	}

	//生成match的nextArr数组，nextArr[i]表示以在match[i]之前的字符串match[0..i-1]中，必须以match[i-1]结尾的后缀子串(不能包含match[0])
	//与必须以match[0]开头的前缀子串(不能包含mach[i-1])最长匹配长度是多少，时间复杂度为O(M)
	public int[] getNextArray(char[] ms){
		if(ms.length == 1){
			return new int[] {-1};
		}
		int[] next = new int[ms.length];
		next[0] = -1;
		next[1] = 0;
		int pos = 2;
		int cn = 0;//cn为next[pos-1]的值
		while(pos < ms.length){
			if(ms[pos - 1] == ms[cn]){
				next[pos++] = ++cn;
			}else if(cn > 0){
				cn = next[cn];
			}else {
				next[pos++] = 0;
			}
			
		}
		return next;
	}
	
	/*
	 * 根据nextArr来匹配match,整个过程中，str不退回，match一直向右华东，如果在str中的某个位置完全匹配出match，
	 * 整个过程停止。负责match滑到str的最右侧过程也停止，所以滑动的最大长度为N，所以时间复杂度为O(N)
	 */
	public int getIndexOf(String s, String m){
		if(s== null||m==null||m.length() < 1 || s.length() < m.length()){
			return -1;
		}
		char[] strArr = s.toCharArray();
		char[] matchArr = m.toCharArray();
		int si = 0;//记录str移动到的位置
		int mi = 0;// 记录match匹配到的位置
		int[] next = getNextArray(matchArr);
		while(si < strArr.length && mi < matchArr.length){
			if(strArr[si] == matchArr[mi]){
				si++;
				mi++;
			}else if(next[mi] == -1){
				si++;
			}else {
				mi = next[mi];
			}
		}
		return mi == matchArr.length  ? si - mi : -1;
	}
}
