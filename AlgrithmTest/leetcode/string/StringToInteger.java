package string;
/**
 * 548注意特殊情况：
 * 	1. 首先需要丢弃字符串前面的空格；

2. 然后可能有正负号（注意只取一个，如果有多个正负号，那么说这个字符串是无法转换的，返回0。比如测试用例里就有个“+-2”）；

3. 字符串可以包含0~9以外的字符，如果遇到非数字字符，那么只取该字符之前的部分，如“-00123a66”返回为“-123”；

4. 如果超出int的范围，返回边界值（2147483647或-2147483648）。
 * @author Administrator
 *
 */
public class StringToInteger {
	
	public static void main(String[] args){
		StringToInteger sti = new StringToInteger();
		String str= "123";
		System.out.println(sti.atoi(str));
	}
	public int atoi(String str){
		if(str == null || str.length()==0)
			return 0;
		str = str.trim();
		boolean positive = true;
		int i = 0;
		if(str.charAt(0) == '-'){
			positive = false;
			i++;
		}else if(str.charAt(0) == '+'){
			i++;
		}
		long res = 0;
		for(; i < str.length();i++){
			int digit = str.charAt(i) - '0';
			if(digit >= 0 && digit <= 9){
				if(positive){
					res = 10 * res + digit ;
					if(res > Integer.MAX_VALUE)
						return Integer.MAX_VALUE;
				}else{
					res = 10 * res + digit;
					if(-res < Integer.MIN_VALUE)
						return Integer.MIN_VALUE;
				}
				
			}else{
				break;
			}
		}
		return (int)(positive? res : -res);
		
		
	}
}
