package arrayProblems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * �����ͨ·ֵ
 * 	��һ�����ξ���matrix��ʾһ�����磬1������·��0������·��ÿһ��λ��ֻҪ��Խ�磬�������������ĸ�������������Ͻǵ������½ǵ����ͨ·ֵ
 * 		�����ÿ�����ȱ������ɣ���������СΪM*N����ʱ�临�ӵ�ΪO(M*N)
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
		//map[i][j]��ʾ��i��jλ�õ����·��
		//�ж���rQ,�ж���cQ
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
