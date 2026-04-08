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

public class Codec {

    private int index = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "null,";
        return root.val + "," + serialize(root.left) + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        return buildTree(nodes);
    }
    private TreeNode buildTree(String[] nodes){
        if(nodes[index].equals("null")){
            index++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodes[index]));
        index++;
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);

        return node;
    }
}
