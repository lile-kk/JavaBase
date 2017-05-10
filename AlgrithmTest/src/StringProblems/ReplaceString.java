package StringProblems;
/*
 * �滻�ַ������������ֵ�ָ���ַ���
 * ���������ַ���str,from��to,��֪from�ַ��������ظ��ַ�����str������from���Ӵ�ȫ���滻��to�ַ�����
 * ����������from�Ĳ���Ҫ��ֻ�滻��һ��to�ַ������������յĽ���ַ���
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
	
	//�滻���ַ���Ϊ'0'
	public void clear(char[] arr,int end,int len){
		while(len-- != 0){
			arr[end--] = 0;
		}
	}
}
