package arrayProblems;
/*
 * תȦ��ӡ����
 * 	����һ�����ξ���matrix���밴��תȦ�ķ�ʽ��ӡ��
 */
public class PrintSquareInCircle {
	public static void main(String[] args){
		int[][] arr={
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};
		
		new PrintSquareInCircle().print(arr);
	}

	public void print(int[][] arr ){
		int i = 0;
		int col = arr[0].length;
		int row = arr.length;
		while(i < row / 2){
			int j = i;
			while(j < col-i){
				System.out.print(arr[i][j++]+",");
			}
			j = i + 1;
			while(j < row - i ){
				System.out.print(arr[j++][col - i -1]+",");
			}
			j = col - i -2;
			while(j >= i){
				System.out.print(arr[row - i - 1][j--]+",");
			}
			j = row - i - 2;
			while(j > i){
				System.out.print(arr[j--][i]+",");
			}
			i++;
		}
	}
}
