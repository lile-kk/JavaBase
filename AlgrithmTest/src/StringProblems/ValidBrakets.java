package StringProblems;

/*
 * ����һ���ַ������ж��ǲ���������Ч�������ַ���
 * ���ף�
 * ����һ�������ַ���str�����������Ч�����Ӵ�
 */
public class ValidBrakets {

	public static void main(String[] args){
		String str = "(())()(";
		System.out.println(new ValidBrakets().maxLength(str));
	}
	
	//ԭ���⣺
	public boolean isValid(String str){
		if(str== null || str.equals("")){
			return false;
		}
		char[] arr = str.toCharArray();
		int count = 0;
		for(int i = 0; i < arr.length;i++){
			if(arr[i] != '(' && arr[i] != ')'){
				return false;
			}
			if(arr[i] == ')' && --count < 0){
				return false;
			}
			if(arr[i] == '('){
				count++;
			}
		}
		return count==0;
	}
	
	//�������⣺
	//��̬�滮��dp[i] ��ʾ��arr[i]��β�����Ч�ַ����Ƕ���
	public int maxLength(String str){
		if(str== null || str.equals(""))
			return 0;
		char[] arr = str.toCharArray();
		int[] dp = new int[arr.length];
		int pre = 0;
		int res = 0;
		for(int i = 1; i< arr.length; i++){
			if(arr[i] == ')'){
				pre = i - dp[i - 1] - 1;
				if(pre >= 0 && arr[pre] == '('){
					dp[i] = dp[i - 1] + 2 + (pre > 0?dp[pre - 1] : 0);
				}
			}
			res = Math.max(res, dp[i]);
		}
		return res;
	}
}
