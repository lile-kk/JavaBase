package StringProblems;
/*
 * �������ٷָ���
 * 	����һ���ַ���str,���ذ�strȫ���гɻ����Ӵ�����С�ָ���
 */
public class HuiWenMinSplits {
	
	public static void main(String[] args){
		String str = "ACDCDCDAD";
		System.out.println(new HuiWenMinSplits().minSplits(str));
	}

	public int minSplits(String str){
		if(str == null || str.equals(""))
			return 0;
		char[] arr = str.toCharArray();
		int len = arr.length;
		/*��̬ת�ƣ�dp[i]��ʾarr[i..len-1]�ֳɻ����Ӵ�����С�ָ���\
		 * dp[i] = min{dp[j] + 1,i < j < len-1}
		 */
		int[] dp = new int[len + 1];
		dp[len] = -1;
		/*
		 * ��ά����p[i][j]��ʾarr[i..j]�Ƿ�Ϊ�����ַ���
		 * i..j�����������
		 * ���ֻ��һ���ַ�����Ϊtrue��
		 * ����������ַ����������ַ���ȣ�Ϊtrue��
		 * ������������ַ���if str[i+1..j-1]Ϊ�����ַ�������p[i+ 1][j-1]Ϊtrue����str[i]==str[j],��p[i][j]=true;
		 */
		boolean[][] p = new boolean[len][len];
		for(int i = len - 1; i >= 0; i--){
			dp[i] = Integer.MAX_VALUE;
			for(int j = i; j < len; j++){
				if(arr[i] == arr[j] && ((j - i) < 2 || p[i + 1][ j - 1])){
					p[i][j] = true;
					dp[i] = Math.min(dp[i], dp[j + 1] + 1);
				}
			}
		}
		return dp[0];
		
		
	}
}
