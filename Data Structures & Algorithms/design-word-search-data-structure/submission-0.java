class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord = false;
}

class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(node.children[index] == null){
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int pos, TrieNode node){
        if(node == null) return false;

        if(pos == word.length()) return node.isEndOfWord;

        char c = word.charAt(pos);

        if(c != '.'){
            int index = c - 'a';
            return dfs(word, pos + 1, node.children[index]);
        }

        for(int i = 0; i < 26; i++){
            if(node.children[i] != null){
                if(dfs(word, pos + 1, node.children[i])){
                    return true;
                }
            }
        }
        return false;
    }
}
