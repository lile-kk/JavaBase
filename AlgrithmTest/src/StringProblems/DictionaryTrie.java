package StringProblems;

import javax.naming.directory.SearchControls;

import dynamic.programming.NPrincess;

/*
 * �ֵ�����
 *  �ֵ����ֳ�Ϊǰ׺��huotrie��
 */
public class DictionaryTrie {
	private TrieNode root;
	public DictionaryTrie(){
		root = new TrieNode();
	}
	
	//����ڵ�
	public void insert(String word){
		if(word == null){
			return ;
		}
		char[] arr = word.toCharArray();
		TrieNode node = root;
		int index = 0;
		for(int i = 0; i < arr.length; i++){
			index = arr[i] - 'a';
			if(node.map[index] == null)
				node.map[index] = new TrieNode();
			node = node.map[index];
			node.path++;
		}
		node.end++;
	}
	
	//ɾ���ڵ�
	public void delete(String word){
		if(search(word)){
			char[] arr = word.toCharArray();
			TrieNode node = root;
			int index = 0;
			for(int i = 0; i< arr.length; i++){
				index = arr[i] - 'a';
				if(node.map[index].path-- == 1){
					node.map[index] = null;
					return;
				}
				node = node.map[index];
			}
			node.end--;
		}
	}
	
	//�����ڵ�
	public boolean search(String word){
		if(word == null)
			return false;
		char[] arr = word.toCharArray();
		TrieNode node = root;
		int index = 0;
		for(int i = 0; i < arr.length; i++){
			index = arr[i] - 'a';
			if(node.map[index] == null)
				return false;
			node = node.map[index];
		}
		return node.end != 0;
	}
	
	//��ĳ��ǰ׺Ϊ�׵ĵ�������
	public int prefixNumber(String pre){
		if(pre == null)
			return 0;
		char[] arr = pre.toCharArray();
		TrieNode node = new TrieNode();
		int index = 0;
		for(int i = 0; i < arr.length; i++){
			index = arr[i] - 'a';
			if(node.map[index] == null)
				return 0 ;
			node = node.map[index];
		}
		return node.path;
	}
	
}

//�ֵ����еĽڵ�
class TrieNode{
	public int path;//��ʾ�ж��ٸ����ʹ�������ڵ㣬���ж�����·����������ڵ㣻
	public int end;//�ж��ٸ�����������ڵ��β�����ֵ����������������ʵĴ���
	public TrieNode[] map;//mapΪһ��hash�ṹ��key����ýڵ��һ���ַ�·����value��ʾ�ַ�·��ָ��Ľڵ㣬���洢�����ӽڵ㣻
	
	public TrieNode(){
		path = 0;
		end = 0;
		map = new TrieNode[26];
	}
}
