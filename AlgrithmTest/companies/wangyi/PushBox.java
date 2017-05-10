package wangyi;

import java.util.Scanner;

/**
 * ���һ������������ӡ�����������Ϸ��������������һ��N*M�ĵ�ͼ�ϣ�
 * ��1����ҡ�1�����ӡ�1��Ŀ�ĵ��Լ������ϰ��������ǿյء�
 * ��ҿ�������������4�������ƶ������ǲ����ƶ�����ͼ�����ƶ����ϰ���ȥ��
 * �������������ƶ��Ƶ������ӣ�����Ҳ�ᰴ��������ƶ�һ��
 * ��Ȼ������Ҳ���ܱ��Ƴ���ͼ���Ƶ��ϰ�������ӱ��Ƶ�Ŀ�ĵ��Ժ�
 * ��ϷĿ���ɡ����ڸ�������Ϸ��ʼ�ǳ�ʼ�ĵ�ͼ���֣�
 * ����������������Ҫ�ƶ����ٲ����ܹ�����ϷĿ���ɡ� 
 * @author Administrator
 *
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
/**
 * Created by Administrator on 2017/3/16.
 */
 
class Stage{
    public Stage(int peoplex, int peopley) {
        this.peoplex = peoplex;
        this.peopley = peopley;
    }
 
    public Stage(int peoplex, int peopley, int boxx, int boxy) {
        this.peoplex = peoplex;
        this.peopley = peopley;
        this.boxx = boxx;
        this.boxy = boxy;
    }
 
    @Override
    public String toString() {
        return "people:("+this.peoplex+","+this.peopley+")  box:("+this.boxx+","+this.boxy+")";
    }
 
    public Stage() {
    }
 
    int peoplex;
    int peopley;
    int boxx;
    int boxy;
    Stage previous;
 
    public boolean equals(Object obj) {
        if (obj instanceof Stage) {
            if (((Stage) obj).peoplex==peoplex&&((Stage) obj).peopley==peopley&&((Stage) obj).boxx==boxx&&((Stage) obj).boxy==boxy)return true;
        }
        return false;
    }
}
 
public class PushBox {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strarr = str.split(" ");
        int n = Integer.valueOf(strarr[0]);
        int m = Integer.valueOf(strarr[1]);
        char[][] map = new char[n][m];
        int r = 0;
        while (r < n){
            
                map[r] = sc.next().toCharArray();
                r++;
            }
            int peoplex=0;
            int peopley=0;
            int boxx=0;
            int boxy=0;
            for (int i=0;i<n;i++){
                for (int j=0;j<m;j++){
                    if (map[i][j]=='X'){
                        peoplex=i;
                        peopley=j;
                    }
                    if (map[i][j]=='*'){
                        boxx=i;
                        boxy=j;
                    }
                }
            }
 
            Stage begin = new Stage(peoplex,peopley,boxx,boxy);
            Stage result = BFS(begin,map,m,n);
            if (result==null){
                System.out.println(-1);
            }else {
            	int p = 0;
                while (result.previous!=null){
                    //System.out.println(result.previous);
                    result = result.previous;
                    p++;
                }
                System.out.println(p);
            }
        
    }
 
    public static Stage BFS(Stage begin,char[][] map,int m,int n){
        Queue<Stage> queue = new LinkedList<Stage>();
        ArrayList<Stage> arrayList = new ArrayList<Stage>();
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
 
        queue.offer(begin);
        while(!queue.isEmpty()){
            Stage local = queue.remove();
            arrayList.add(local);
            for(int i=0; i< dir.length; i++){
                Stage next = new Stage(local.peoplex+dir[i][0], local.peopley+dir[i][1]);
                next.previous = local;
                if (next.peoplex>=0&&next.peoplex<m&&next.peopley<n&&next.peopley>=0&&map[next.peoplex][next.peopley]!='#'){
                    if (next.peoplex==local.boxx&&next.peopley==local.boxy){
                        next.boxx=local.boxx+dir[i][0];
                        next.boxy=local.boxy+dir[i][1];
                    }else {
                        next.boxx=local.boxx;
                        next.boxy=local.boxy;
                    }
                    if (arrayList.contains(next))continue;
                    if (next.boxx>=0&&next.boxx<m&&next.boxy<n&&next.boxy>=0&&map[next.boxx][next.boxy]!='#'){
                        arrayList.add(next);
                        queue.offer(next);
                    }else {
                        continue;
                    }
                    if (map[next.boxx][next.boxy]=='@'){
                        return next;
                    }
                }
            }
        }
        return null;
    }
}