package arrayProblems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 求最短通路值
 * 	用一个整形矩阵matrix表示一个网络，1代表有路，0代表无路，每一个位置只要不越界，都有上下左右四个方向，求从最左上角到最右下角的最短通路值
 * 		：利用宽度优先遍历即可，如果矩阵大小为M*N，则时间复杂的为O(M*N)
 * @author Administrator
 *
 */
public class BFSInMatrix {
	
	public static void main(String[] args){
		int[][] arr = {
				{1,0,1,1,1},
				{1,0,1,0,1},
				{1,1,1,0,1},
				{0,0,0,0,1}
		};
		System.out.println(new BFSInMatrix().minPathValue(arr));
	}

	public int minPathValue(int[][] m){
		if(m == null || m.length == 0 || m[0].length == 0||m[0][0] != 1 || 
				m[m.length - 1][m[0].length - 1] != 1)
			return 0;
		
		int res = 0;
		//map[i][j]表示到i，j位置的最短路径
		//行队列rQ,列队列cQ
		int[][] map = new int[m.length][m[0].length];
		map[0][0] = 1;
		Queue<Integer> rQ = new LinkedList<Integer>();
		Queue<Integer> cQ = new LinkedList<Integer>();
		rQ.add(0);
		cQ.add(0);
		int r = 0,c = 0;
		while(!rQ.isEmpty()){
			r = rQ.poll();
			c = cQ.poll();
			if(r == m.length - 1 && c == m[0].length - 1)
				return map[r][c];
			walkTo(map[r][c],r + 1, c, m, map, rQ, cQ);
			walkTo(map[r][c],r - 1, c, m, map, rQ, cQ);
			walkTo(map[r][c],r, c + 1, m, map, rQ, cQ);
			walkTo(map[r][c],r, c - 1, m, map, rQ, cQ);
			
		}
		return res;
	}
	
	public void walkTo(int pre,int toR,int toC,int[][] m,int[][] map,
			Queue<Integer> rQ,Queue<Integer> cQ){
		if(toR < 0 || toR == m.length || toC < 0 || toC == m[0].length ||
				m[toR][toC] == 0 || map[toR][toC] != 0)
			return;
		map[toR][toC] = pre + 1;
		rQ.add(toR);
		cQ.add(toC);
	}
}
