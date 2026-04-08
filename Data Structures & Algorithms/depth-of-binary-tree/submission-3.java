/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxDepth(TreeNode root) {
        // DFS
         if(root == null) return 0;
        // int leftDepth = maxDepth(root.left);
        // int rightDepth = maxDepth(root.right);
        // return 1 + Math.max(leftDepth, rightDepth);
        // BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int height = 0;
        while(!queue.isEmpty()){
            height++;
            int n = queue.size();
            for(int i = 0; i < n; i++){
                TreeNode node = queue.poll();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        return height;
    }
}
