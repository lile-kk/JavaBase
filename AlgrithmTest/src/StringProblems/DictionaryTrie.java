package StringProblems;

import javax.naming.directory.SearchControls;

import dynamic.programming.NPrincess;

/*
 * 字典树：
 *  字典树又称为前缀树huotrie树
 */
public class DictionaryTrie {
	private TrieNode root;
	public DictionaryTrie(){
		root = new TrieNode();
	}
	
	//插入节点
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
	
	//删除节点
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
	
	//搜索节点
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
	
	//以某个前缀为首的单词数量
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

//字典树中的节点
class TrieNode{
	public int path;//表示有多少个单词共用这个节点，即有多少条路径经过这个节点；
	public int end;//有多少个单词以这个节点结尾，即字典里面出现了这个单词的次数
	public TrieNode[] map;//map为一个hash结构，key代表该节点的一条字符路径，value表示字符路径指向的节点，即存储的是子节点；
	
	public TrieNode(){
		path = 0;
		end = 0;
		map = new TrieNode[26];
	}
}
