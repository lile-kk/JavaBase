package xh.collection.tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;

public class RebuildTrees {
	public static void main(String[] args){
		RebuildTrees rt = new RebuildTrees();
		int pre[] = {1,2,4,5,8,9,3,6,7};
		int in[] = {4,2,8,5,9,1,6,3,7};
		int pos[] = {4,8,9,5,2,6,7,3,1};
		System.out.println(ArrayUtils.toString(rt.getPosArray(pre, in)));
//		TraversalRecurrent tr = new TraversalRecurrent();
//		tr.preOrder(root);s
	}

	//����ǰ������������ؽ�������
	public Node preInToTree(int[] pre,int[] in){
		if((pre== null) ||(in== null)){
			return null;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < in.length; i++){
			map.put(in[i], i);
		}
		return preIn(pre, 0, pre.length - 1, in, 0, in.length - 1, map);
		
	}
	public Node preIn(int[] p,int pi,int pj,int[] n,int ni,int nj,HashMap<Integer, Integer> map){
		if(pi > pj){
			return null;
		}
		Node head = new Node(p[pi]);
		int index = map.get(p[pi]);
		head.leftChild = preIn(p, pi + 1, pi + index - ni, n, ni, index - 1, map);
		head.rightChild = preIn(p, pi + index - ni + 1, pj, n, index + 1,nj, map);
		return head;
	}
	
	//����ͺ��������ؽ�������
	/**
	 * �ڵ�ֵ����ͬ�Ķ�����������õ�����ȷ������ͺ������飬�ڴ���������Ҳ����ͨ������������
	 * �ؽ�ԭ���Ķ�������������Ϊ�ܶ�ṹ��ͬ�����У����������������һ���ġ����һ�Ŷ�������Ҷ�ӽڵ��⣬�������еĽڵ㶼�����Ӻ��Һ��ӣ�
	 * ֻ�����������ſ��Ա�����ͺ��������ع�������
	 * @param in
	 * @param pos
	 * @return
	 */
	public Node inPosToTree(int[] in,int[] pos){
		if((pos== null) ||(in== null)){
			return null;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < in.length; i++){
			map.put(in[i], i);
		}
		return inPos(in, 0, in.length - 1,pos, 0, pos.length - 1, map);
	}
	public Node inPos(int[] n,int ni,int nj,int[] s,int si,int sj,HashMap<Integer, Integer> map){
		if(si > sj){
			return null;
		}
		Node head = new Node(s[sj]);
		int index = map.get(s[sj]);
		head.leftChild = inPos(n, ni, index - 1, s, si, si + index - ni - 1, map);
		head.rightChild = inPos(n, index + 1, nj, s, si + index - ni, sj - 1, map);
		return head;
	}
	
	//��������ͺ��������ؽ�������
	public Node prePosToTree(int[] pre,int[] pos){
		if((pos== null) ||(pre== null)){
			return null;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < pos.length; i++){
			map.put(pos[i], i);
		}
		return prePos(pre,0 , pre.length - 1, pos, 0, pos.length - 1, map);
		
	}
	public Node prePos(int[] p,int pi,int pj,int[] s, int si,int sj,HashMap<Integer, Integer> map){
		Node head = new Node(s[sj--]);
		if(pi== pj){
			return head;
		}
		int index = map.get(p[++pi]);
		head.leftChild = prePos(p, pi, pi + index - si, s, si, index, map);
		head.rightChild = prePos(p, pi + index -si + 1, pj, s, index + 1, sj, map);
		return head;
		
	}
	
	
	/**
	 * ͨ���������������ֱ�����ɺ������飬��Ҫ�ؽ�������
	 * 
	 */
	public int[] getPosArray(int[] pre,int[] in){
		if(pre== null || in== null){
			return null;
		}
		int len = pre.length;
		int[] pos = new int[len];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < len;i ++){
			map.put(in[i], i);
		}
		
		setPos(pre, 0, len - 1, in, 0, len - 1, len - 1, pos, map);
		return pos;
	}
	//��������������ú�������s
	//siΪ��������s�����λ��
	//����ֵΪs�������һλ��
	public int setPos(int[] p,int pi,int pj,int[] n,int ni,int nj,int si,int[] s,HashMap<Integer, Integer> map){
		if(pi > pj){
			return si;
		}
		s[si--] = p[pi];
		int i = map.get(p[pi]);
		si = setPos(p, pj - nj + i + 1, pj, n, i + 1, nj, si, s, map);
		return setPos(p, pi + 1, pi + i - ni, n, ni, i - 1, si, s, map);
	}
}
