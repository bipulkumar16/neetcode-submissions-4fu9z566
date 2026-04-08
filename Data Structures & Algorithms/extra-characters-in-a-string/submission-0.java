class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}

class Solution {

    private TrieNode root = new TrieNode();

    private void insert(String word){
        TrieNode node = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(node.children[index] == null){
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }
    public int minExtraChar(String s, String[] dictionary) {
        for(String word : dictionary){
            insert(word);
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 0;
        for(int i = n - 1; i >= 0; i--){
            dp[i] = 1 + dp[i + 1];
            TrieNode node = root;

            for(int j = i; j < n; j++){
                int index = s.charAt(j) - 'a';

                if(node.children[index] == null){
                    break;
                }
                node = node.children[index];
                if(node.isEnd){
                    dp[i] = Math.min(dp[i], dp[j + 1]);
                }
            }
        }
        return dp[0];
    }
}