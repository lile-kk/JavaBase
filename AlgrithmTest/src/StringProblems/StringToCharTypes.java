package StringProblems;
/**
 * �����ַ���ת��Ϊ��ĸ��ϵ�����
 * ����һ���ַ���str,strȫ���������ַ���ɣ����str��ĳһ����ĳ���������ַ���ɵ��Ӵ�ֵ��1~26֮�䣬������Ӵ�����ת��Ϊһ����ĸ
 * "1" -> "A"
 * @author Administrator
 *
 */
public class StringToCharTypes {
	
	public static void main(String[] args){
		String str = "10";
		System.out.println(new StringToCharTypes().sumNun(str));
	}

	
	public int sumNun(String str){
		if(str == null || str.equals("")){
			return 0;
		}
		char[] arr = str.toCharArray();
		int cur = arr[arr.length - 1] == '0' ? 0 : 1;
		int next = 1;
		int tmp2 = 0;
		for(int i = arr.length - 2; i >= 0; i--){
			if(arr[i] == '0'){
				next = cur;
				cur = 0;
				
			}else{
				tmp2= cur;
				if(((arr[i] - '0')*10 + (arr[i + 1] - '0')) < 27){
					cur += next;
				}
				next = tmp2;
			}
		}
		return cur;
	}
}
