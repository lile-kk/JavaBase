package xh.commonUtils;

import javax.naming.InitialContext;


public class ErWeiShuzuInital {

	//��ʼ����ά����Ϊһ����ͬ��ֵ
	public void inital(int[][] map,int a){
		for(int i = 0; i < map.length; i++){
			for(int j = 0;j < map[0].length; j++){
				map[i][j] = a;
			}
		}
	}
}
