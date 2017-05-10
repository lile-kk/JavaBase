package StringProblems;
/*
 * һ�����ֺ��ַ�����Ӧ��ϵ
 * 	һ��char���͵�����chs���������е��ַ�����ͬ��
 * 	αK����
 */
public class FakeKRadix {
	public static void main(String[] args){
		int n = 72;
		char[] chs = {'A','B','C'};
		FakeKRadix fk = new FakeKRadix();
		System.out.println(fk.getString(chs, n));
		System.out.println(fk.getNum(chs, "ABBA"));
	}

	//��ʮ�������õ��ַ������ʽ
	public String getString(char[] chs,int n){
		if(chs == null || chs.length == 0 || n < 1)
			return "";
		int cur = 1;
		int base = chs.length;
		int len = 0;
		while(n >= cur){
			len++;
			n -= cur;
			cur *= base;
		}
		char[] res = new char[len];
		int index = 0;
		int ncur = 0;
		do{
			cur /= base;
			ncur = n / cur;
			res[index++] = getKthCharAtchs(chs, ncur + 1);
			n %= cur;
		}while(index != len);
		return String.valueOf(res);
	}
	public char getKthCharAtchs(char[] chs,int k){
		if(k < 1 || k > chs.length)
			return 0;
		return chs[k-1];
	}
	
	//���ַ���ת����ʮ����
	public int getNum(char[] chs,String str){
		if(chs == null || chs.length== 0)
			return 0;
		char[] arr = str.toCharArray();
		int base = chs.length;
		int res = 0;
		int cur = 1;
		for(int i =arr.length - 1 ; i >= 0; i--){
			
			res += getNthFromChar(chs, arr[i])*cur;
			cur *= base;
		}
		return res;
	}
	public int getNthFromChar(char[] chs,char c){
		int res = -1;
		for(int i = 0; i != chs.length; i++){
			if(chs[i] == c){
				res = i + 1;
				break;
			}
		}
		return res;
	}
}
