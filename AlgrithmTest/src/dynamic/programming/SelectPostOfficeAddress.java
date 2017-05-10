package dynamic.programming;
/*
 * 邮局选址问题
 */
public class SelectPostOfficeAddress {
	
	public static void main(String[] args){
		int[] a = {1,2,3,4,5,1000};
		int num = 2;
		SelectPostOfficeAddress spf = new SelectPostOfficeAddress();
		System.out.print(spf.minDistance2(a, num));
	}

	/*
	 * w矩阵的求解过程O(N2),动态规划的求解过程O(n2*num)所以总得时间复杂度为O(n2 * num)
	 */
	public int minDistance(int[] arr,int num){
		if(arr== null || num < 1 || arr.length < num){
			return 0;
		}
		
		/*
		 * w[i][j]表示如果在arr[i..j]这个区域上只建一个邮局，这个区间距邮局的总距离的最小值，
		 * 最小值为当邮局建在i..j中点的时候
		 * 如果区间有奇数个居民点，邮局建在中点位置会使距离最短；
		 * 如果有偶数个居民点，邮局建在两个中点都是一样的距离
		 * w[i][j] = w[i][j - 1] + arr[j] - arr[(i + j) / 2]
		 */
		int[][] w = new int[arr.length + 1][arr.length + 1];
		for(int i = 0; i < arr.length; i++){
			for(int j = i + 1; j < arr.length;j++){
				w[i][j] = w[i][j - 1] + arr[j] - arr[(i + j) / 2];
			}
		}
		//dp[a][b]表示如果在arr[0..b]上建a + 1个邮箱，总距离最少是多少
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
	
	//用四边形不等式优化动态规划的枚举过程，使整个过程的时间复杂度降低至O(N2)
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
