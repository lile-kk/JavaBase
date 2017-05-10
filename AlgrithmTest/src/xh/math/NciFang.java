package xh.math;
//求一个数或者矩阵的N次放
public class NciFang {
	
	//矩阵m的p次放
	public static int[][] matrixPower(int[][] m,int p){
		int[][] res = new int[m.length][m[0].length];
		//先把res设为单位矩阵
		for(int i = 0; i < m.length; i++){
			res[i][i] = 1;
		}
		int[][] tmp = m;
		for(; p != 0; p >>=1){
			if((p & 1) != 0){
				res = multiMatrix(tmp, res);
			}
			tmp = multiMatrix(tmp, tmp);//记录的m的1,2,4,6,次方。
		}
		return res; 
	}

	//矩阵乘法
	public static int[][] multiMatrix(int[][] m1,int[][] m2){
		int[][] res = new int[m1.length][m2[0].length];
		for(int i = 0; i < m1.length;i++){
			for (int j = 0; j < m2[0].length; j++) {
				for(int k = 0; k < m1.length; k++){
					res[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		return res;
	}
}
