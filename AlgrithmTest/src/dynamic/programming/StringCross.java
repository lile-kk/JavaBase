package dynamic.programming;
/**
 * 

���������ַ���str1��str2��aim��
���aim�����ҽ���������str1��str2�������ַ���
������aim������str1���ַ�֮�䱣��ԭ����str1�е�˳��
����str2���ַ�֮�䱣��ԭ����str2�е�˳����ô��aim��str1��str2�Ľ�����ɡ�
ʵ��һ���������ж�aim�Ƿ���str1��str2������ɡ�
��������
str1=��AB����str2=��12������ô��AB12������A1B2������A12B������1A2B���͡�1AB2���ȵȶ���str1��str2������ɡ�
 * @author Administrator
 *
 */
public class StringCross {
	public static void main(String[] args){
		String str1 = "AB";
		String str2 = "12";
		String aim = "AB12";
		System.out.println(isCross2(str1, str2, aim));
	}
	
	/**
	 * ��̬�滮������ʱ�临�Ӷ�ΪO(M*N)���ռ临�Ӷ�O(M*N)����Ͽռ�ѹ�����������Խ��ռ临�ӶȽ�ΪO(min{M,N})
	 * dp[i][j]��ʾ��str1[0..i-1]��str2[0..j-1]�Ƿ������aim[i+j-1];
	 * 
	 */
	public static boolean isCross1(String str1,String str2,String aim){
		if(str1 ==null || str2 == null || aim == null){
			return false;
		}
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();
		char[] chaim = aim.toCharArray();
		if((ch1.length + ch2.length) != chaim.length){
			return false;
		}
		boolean dp[][] = new boolean[ch1.length + 1][ch2.length + 1];
		dp[0][0] = true;
		for (int i = 1; i <= ch1.length; i++) {
			if(ch1[i-1] != chaim[i-1]){
				break;
			}
			dp[i][0] = true;
			
		}
		for (int i = 1; i <= ch2.length; i++) {
			if(ch2[i-1] != chaim[i-1]){
				break;
			}
			dp[0][i] = true;
			
		}
		for (int i = 1; i <= ch1.length; i++) {
			for (int j = 0; j <= ch2.length; j++) {
				if(ch1[i-1] == chaim[i + j - 1] && dp[i-1][j]
						|| (ch2[j-1] == chaim[i + j - 1]&&dp[i][j-1])){
					dp[i][j] = true;
				}
			}
			
		}
		return dp[ch1.length][ch2.length];
	}
	
	//ʹ�ÿռ�ѹ�����������ռ临�ӶȽ���O(min{M,N})����M��N�н��ٵ�һ����Ϊ��
	public static boolean isCross2(String str1,String str2,String aim){
		if(str1 ==null || str2 == null || aim == null){
			return false;
		}
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();
		char[] chaim = aim.toCharArray();
		if((ch1.length + ch2.length) != chaim.length){
			return false;
		}
		char[] longs = ch1.length >= ch2.length ? ch1:ch2;
		char[] shots = ch1.length < ch2.length ? ch1:ch2;
		boolean dp[] = new boolean[shots.length+1];
		dp[0] = true;
		for(int i = 1; i <= shots.length; i++){
			if(shots[i-1] != chaim[i-1]){
				break;
			}
			dp[i] = true;
		}
		for(int i = 1; i <= longs.length; i++){
			dp[0] = dp[0] && longs[i - 1] == chaim[i - 1];
			for (int j = 0; j <= shots.length; j++) {
				if(longs[i-1] == chaim[i+j-1] && dp[j] 
						||(shots[j-1] == chaim[i+j-1] &&dp[j-1])){
					dp[j] = true;
				}else {
					dp[j] = false;
				}
			}
		}
		return dp[shots.length];
	}
	
	
	
}
