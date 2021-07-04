package hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TrieNode{
    String word = "";
    TrieNode[] children = new TrieNode[26];
}

class Trie{
    TrieNode root = new TrieNode();

    public void insert(String word){
        TrieNode node = root;
        for(Character c: word.toCharArray()){
            if(node.children[c-'a']==null)
                node.children[c-'a'] = new TrieNode();
            node = node.children[c-'a'];
        }
        node.word = word;
    }

    public boolean search(String word){
        TrieNode node = root;
        for(Character c: word.toCharArray()){
            if(node.children[c-'a']==null)
                return false;
            node = node.children[c-'a'];
        }
        if(node.word.equals(word))
            return true;
        else
            return false;
    }

    public boolean startsWith(String word){
        TrieNode node = root;
        for(Character c: word.toCharArray()){
            if(node.children[c-'a']==null)
                return false;
            node = node.children[c-'a'];
        }
        return true;
    }
}
public class WordSearchII {
    Set<String> result = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word: words){
            trie.insert(word);
        }
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++)
            for(int j =0;j<n;j++)
                dfs(board,visited,"",i,j,trie);

        return new ArrayList<String>(result);
    }

    private void dfs(char[][] board, boolean[][] visited, String str, int i, int j, Trie trie) {
        int m = board.length, n =board[0].length;
        if(i<0 || j<0 || i>=m ||j>=n) return;
        if(visited[i][j])
            return;
        str+=board[i][j];

        if(!trie.startsWith(str))
            return;
        if(trie.search(str))
            result.add(str);

        visited[i][j]=true;
        dfs(board,visited,str,i-1,j,trie);
        dfs(board,visited,str,i+1,j,trie);
        dfs(board,visited,str,i,j-1,trie);
        dfs(board,visited,str,i,j+1,trie);
        visited[i][j]=false;
    }
}
