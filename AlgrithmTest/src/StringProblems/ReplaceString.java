package StringProblems;
/*
 * 替换字符串中连续出现的指定字符串
 * 给定三个字符串str,from和to,已知from字符串中无重复字符，把str中所有from的子串全部替换成to字符串，
 * 对连续出现from的部分要求只替换成一个to字符串，返回最终的结果字符串
 */
public class ReplaceString {
	
	public static void main(String[] args){
		String str = "123abccabc";
		String from = "abc";
		String to = "X";
		System.out.println(new ReplaceString().replace(str, from, to));
	}

	public String replace(String str,String from,String to){
		if(str== null || from == null || to== null){
			return str;
		}
		char[] arrStr = str.toCharArray();
		char[] arrF = from.toCharArray();
		int match = 0;
		for(int i = 0; i < arrStr.length; i++){
			if(arrStr[i] == arrF[match++]){
				if(match == arrF.length){
					clear(arrStr, i, match);
					match = 0;
				}
			}else{
				if(arrStr[i] == arrF[0])
					i--;
				match = 0;
			}
		}
		
		String res = "";
		String cur = "";
		for(int i = 0; i < arrStr.length; i++){
			if(arrStr[i] != 0){
				cur = cur + String.valueOf(arrStr[i]);
			}
			if(arrStr[i] == 0 && (i==0||arrStr[i-1] != 0)){
				res = res + cur + to;
				cur= "";
			}
		}
		if(!cur.equals("")){
			res= res + cur;
		}
		return res;
	}
	
	//替换子字符串为'0'
	public void clear(char[] arr,int end,int len){
		while(len-- != 0){
			arr[end--] = 0;
		}
	}
}
