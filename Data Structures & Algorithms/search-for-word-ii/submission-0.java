class Solution {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }
    private TrieNode root = new TrieNode();
    private List<String> result = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        for(String word : words){
            insert(word);
        }
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dfs(board, i, j, root);
            }
        }
        return result;
    }
    private void insert(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }

        node.word = word;   // mark complete word
    }
    private void dfs(char[][] board, int i, int j, TrieNode node){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length){
            return;
        }
        char c = board[i][j];

        if(c == '#' || node.children[c - 'a'] == null) return;
        node = node.children[c - 'a'];
        if(node.word != null) {
            result.add(node.word);
            node.word = null;
        }
        board[i][j] = '#';
        dfs(board, i + 1, j, node); // down
        dfs(board, i - 1, j, node); // up
        dfs(board, i, j + 1, node); // right
        dfs(board, i, j - 1, node); // left

        board[i][j] = c;
    }
}
