package string;
/*
 * ��ά������ַ����󣬸���һ���ַ���word�����ܲ������ַ��������ҵ����word���ַ������е��ַ��������������ĸ������γ��ַ�����
 * Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
 */
public class WordSearch79 {
	
	public static void main(String[] args){
		char[][] board = {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
		};
		String str = "ABCCED";
		System.out.println(new WordSearch79().exist(board, str));
	}

	 public boolean exist(char[][] board, String word) {  
	        int m = board.length;  
	        int n = board[0].length;  
	        boolean[][] visited = new boolean[m][n];  
	        for (int i = 0; i < m; i++) {  
	            for (int j = 0; j < n; j++) {  
	                if (dfs(board, visited, i, j, word, 0)) return true;  
	            }  
	        }  
	        return false;  
	    }  
	      
	    public boolean dfs(char[][] board, boolean[][] visited, int x, int y, String word, int k) {  
	        if (k == word.length()) return true;  
	        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return false;  
	        if (visited[x][y]) return false;  
	        if (board[x][y] != word.charAt(k)) return false;  
	          
	        visited[x][y] = true;  
	        if (dfs(board, visited, x - 1, y, word, k + 1)) return true;  
	        if (dfs(board, visited, x + 1, y, word, k + 1)) return true;  
	        if (dfs(board, visited, x, y - 1, word, k + 1)) return true;  
	        if (dfs(board, visited, x, y + 1, word, k + 1)) return true;  
	        visited[x][y] = false;  
	          
	        return false;  
	    }  
}
