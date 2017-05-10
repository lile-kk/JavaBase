package StringProblems;
/**
 * �ҵ��ַ���������ظ��ַ��Ӵ�
 * 	����һ���ַ���str������str������ظ��ַ��Ӵ��ĳ���
 * 
 * @author Administrator
 *
 */
public class MaxUnrepeatedSubString {
	
	public static void main(String[] args){
		String str = "aabcdb";
		System.out.println(new MaxUnrepeatedSubString().maxUnique(str));
	}

	public int maxUnique(String str){
		//pre��ʾ������str[i- 1]��β������£�����ظ��ַ��Ӵ���ʼ��ǰһ��λ�ã���ʼʱpre=-1
		int pre = -1;
		if(str.length() == 0 || str.equals(""))
			return 0;
		char[] arr = str.toCharArray();
		int[] map = new int[256];
		for(int i = 0;i < 256; i++){
			map[i] = -1;
		}
		int cur = 0;
		int len = 0;
		for(int i = 0; i < arr.length; i++){
			pre = Math.max(pre, map[arr[i]]);
			cur = i - pre;
			len = Math.max(cur, len);
			map[arr[i]] = i; 
		}
		return len;
	}
}
