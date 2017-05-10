package StringProblems;
/**
 * KMP�㷨��һ���ַ������Ƿ������һ���ַ���
 * ���ַ���str_N,match_M��
 * �㷨�����ΪO(N)
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

	//����match��nextArr���飬nextArr[i]��ʾ����match[i]֮ǰ���ַ���match[0..i-1]�У�������match[i-1]��β�ĺ�׺�Ӵ�(���ܰ���match[0])
	//�������match[0]��ͷ��ǰ׺�Ӵ�(���ܰ���mach[i-1])�ƥ�䳤���Ƕ��٣�ʱ�临�Ӷ�ΪO(M)
	public int[] getNextArray(char[] ms){
		if(ms.length == 1){
			return new int[] {-1};
		}
		int[] next = new int[ms.length];
		next[0] = -1;
		next[1] = 0;
		int pos = 2;
		int cn = 0;//cnΪnext[pos-1]��ֵ
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
	 * ����nextArr��ƥ��match,���������У�str���˻أ�matchһֱ���һ����������str�е�ĳ��λ����ȫƥ���match��
	 * ��������ֹͣ������match����str�����Ҳ����Ҳֹͣ�����Ի�������󳤶�ΪN������ʱ�临�Ӷ�ΪO(N)
	 */
	public int getIndexOf(String s, String m){
		if(s== null||m==null||m.length() < 1 || s.length() < m.length()){
			return -1;
		}
		char[] strArr = s.toCharArray();
		char[] matchArr = m.toCharArray();
		int si = 0;//��¼str�ƶ�����λ��
		int mi = 0;// ��¼matchƥ�䵽��λ��
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
