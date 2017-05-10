package dynamic.programming;
/*
 * �ʾ�ѡַ����
 */
public class SelectPostOfficeAddress {
	
	public static void main(String[] args){
		int[] a = {1,2,3,4,5,1000};
		int num = 2;
		SelectPostOfficeAddress spf = new SelectPostOfficeAddress();
		System.out.print(spf.minDistance2(a, num));
	}

	/*
	 * w�����������O(N2),��̬�滮��������O(n2*num)�����ܵ�ʱ�临�Ӷ�ΪO(n2 * num)
	 */
	public int minDistance(int[] arr,int num){
		if(arr== null || num < 1 || arr.length < num){
			return 0;
		}
		
		/*
		 * w[i][j]��ʾ�����arr[i..j]���������ֻ��һ���ʾ֣����������ʾֵ��ܾ������Сֵ��
		 * ��СֵΪ���ʾֽ���i..j�е��ʱ��
		 * �������������������㣬�ʾֽ����е�λ�û�ʹ������̣�
		 * �����ż��������㣬�ʾֽ��������е㶼��һ���ľ���
		 * w[i][j] = w[i][j - 1] + arr[j] - arr[(i + j) / 2]
		 */
		int[][] w = new int[arr.length + 1][arr.length + 1];
		for(int i = 0; i < arr.length; i++){
			for(int j = i + 1; j < arr.length;j++){
				w[i][j] = w[i][j - 1] + arr[j] - arr[(i + j) / 2];
			}
		}
		//dp[a][b]��ʾ�����arr[0..b]�Ͻ�a + 1�����䣬�ܾ��������Ƕ���
		int[][] dp  = new int[num][arr.length];
		for(int i = 0; i < arr.length; i++){
			dp[0][i] = w[0][i];
		}
		for(int i = 1; i < num; i++){
			for(int j = i + 1; j < arr.length;j++){
				dp[i][j] = Integer.MAX_VALUE;
				for(int k = 0; k <= j; k++){
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + w[k + 1][j]);
				}
			}
		}
		return dp[num - 1][arr.length - 1];
	}
	
	//���ı��β���ʽ�Ż���̬�滮��ö�ٹ��̣�ʹ�������̵�ʱ�临�ӶȽ�����O(N2)
	public int minDistance2(int[] arr,int num){
		if(arr== null || num < 1 || arr.length < num){
			return 0;
		}
		int[][] w = new int[arr.length + 1][arr.length + 1];
		for(int i = 0; i < arr.length; i++){
			for(int j = i + 1; j < arr.length;j++){
				w[i][j] = w[i][j - 1] + arr[j] - arr[(i + j) / 2];
			}
		}
		int[][] dp = new int[num][arr.length];
		int[][] s = new int[num][arr.length];
		for(int j = 0; j != arr.length; j++){
			dp[0][j] = w[0][j];
			s[0][j] = 0;
		}
		int minK = 0;
		int maxK = 0;
		int cur = 0;
		for(int i = 1; i < num; i++){
			for(int j = arr.length - 1; j > i; j--){
				minK = s[i - 1][j];
				maxK = j== arr.length - 1 ? arr.length - 1 : s[i][j+1];
				dp[i][j] = Integer.MAX_VALUE;
				for(int k  = minK; k <= maxK; k++){
					cur = dp[i - 1][k] + w[k + 1][j];
					if(cur <= dp[i][j]){
						dp[i][j] = cur;
						s[i][j] = k;
					}
				}
			}
		}
		
		return dp[num - 1][arr.length - 1];
	}
}
