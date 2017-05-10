package dynamic.programming;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * walle��һ�������˻���Ͷ��Ѳ�ӻ����ˣ�ÿ��Ĺ����Ǿ�ְ��Ѳ������ɽ���������ʧ�޶������㣬����ƽ�������£�ֻ��������·
 * ����������ΪWalle���Ѳ��·�ߣ�����walle�ڿ�Ͷ���ܹ�Ѳ�����ĵط���
 * ����ɽ���ĵ��εĺ��θ߶Ƚ���һ������ά����������������������·�ߵĳ��ȡ�
 * ����
 1 2 3 4 5
 16 17 18 19 6
 15 24 25 20 7
 14 23 22 21 8
 13 12 11 10 9
 * Walle�����ĳ�������������������ڵ��ĸ���֮һ����ֻ��ѡ������·�ߡ�
 * ������������У�һ�����е�·��Ϊ21->17->16->1����25->24->23-...3->2->1����
 * ������������һ��
 * ����������
 * ����ĵ�һ�б�ʾ���������R������C(1 <= R,C <= 100).������R�У�ÿ����C������������߶�h��0��=h��=10000.
 * �����
 * ��������ĳ��ȡ�
 * @author Administrator
 *
 */

public class PatrolRobot {

	static int R = 0;
	static int C = 0;
	static TreeMap<Integer, Integer[]> treeMap = null;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		int map[][] = new int[R][C];
		treeMap = new TreeMap<Integer, Integer[]>();
		int r = 0;
		while(r < R){
			int j = 0;
			while(j < C){
				int value = sc.nextInt();
				map[r][j] = value;
				Integer[] a = {r,j};
				treeMap.put(value, a);
				j++;
			}
			r++;
		}
		
		int[][] dp = new int[R][C];
		inital(dp, 0);
		
		Iterator<Integer> iter = treeMap.keySet().iterator();
		while(iter.hasNext()){
			int key = iter.next();
			Integer[] ij = treeMap.get(key);
			int tmpr = ij[0];
			int tmpc = ij[1];
			f(dp, tmpr, tmpc, map);
		}
		
		int max = 0;
		for(int i = 0; i < R;i++){
			for(int j = 0; j < C;j++){
				if(max < dp[i][j])
					max= dp[i][j];
			}
		}
		
		System.out.println(max);
		
	}
	
	
	public static void f(int[][] dp,int i,int j,int[][] map){
		int index = i;
		int indey = j;
		int max= 0;
		if((i - 1 >=0)&& (dp[i-1][j] != 0)&&(map[i][j] > map[i - 1][j])){
			if(max < dp[i - 1][j]){
				max= dp[i - 1][j];
				index = i - 1;
				indey = j;
			}
		}
		if((i + 1 <R)&& (dp[i+1][j] != 0)&&(map[i][j] > map[i + 1][j])){
			if(max < dp[i + 1][j]){
				max= dp[i + 1][j];
				index = i + 1;
				indey = j;
			}
		}
		if((j - 1 >=0)&& (dp[i][j - 1] != 0)&&(map[i][j] > map[i][j - 1])){
			if(max < dp[i][j - 1]){
				max= dp[i][j - 1];
				index = i;
				indey = j - 1;
			}
		}
		if((j + 1 < C)&& (dp[i][j + 1] != 0)&&(map[i][j] > map[i][j + 1])){
			if(max < dp[i][j + 1]){
				max= dp[i][j + 1];
				index = i;
				indey = j + 1;
			}
		}
		if(max != 0){
			dp[i][j] = dp[index][indey] + 1;
		}else {
			dp[i][j] = 1;
		}
	}
	
	public static void inital(int[][] map,int a){
		for(int i = 0; i < map.length; i++){
			for(int j = 0;j < map[0].length; j++){
				map[i][j] = a;
			}
		}
	}
	
}
