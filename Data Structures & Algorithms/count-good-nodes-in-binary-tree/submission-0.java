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
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;

        int count = 0;
        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
        queue.offer(new Pair<>(root, root.val));

        while(!queue.isEmpty()){
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int maxSoFar = pair.getValue();

            if(node.val >= maxSoFar){
                count++;
            }
            int newMax = Math.max(maxSoFar, node.val);

            if(node.left != null){
                queue.offer(new Pair<>(node.left, newMax));
            }
            if(node.right != null){
                queue.offer(new Pair<>(node.right, newMax));
            }
        }
        return count;
    }
}
