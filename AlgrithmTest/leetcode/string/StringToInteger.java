package string;
/**
 * 548ע�����������
 * 	1. ������Ҫ�����ַ���ǰ��Ŀո�

2. Ȼ������������ţ�ע��ֻȡһ��������ж�������ţ���ô˵����ַ������޷�ת���ģ�����0�����������������и���+-2������

3. �ַ������԰���0~9������ַ�����������������ַ�����ôֻȡ���ַ�֮ǰ�Ĳ��֣��硰-00123a66������Ϊ��-123����

4. �������int�ķ�Χ�����ر߽�ֵ��2147483647��-2147483648����
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
