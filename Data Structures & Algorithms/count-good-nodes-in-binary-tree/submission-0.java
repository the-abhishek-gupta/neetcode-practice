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
    int ct;
    public int goodNodes(TreeNode root) {
        if (root == null)
            return 0;
        find(root, root.val);
        return ct;
    }
    private void find(TreeNode node, int maxVal){
        if (node == null)
            return;
        if (node.val >= maxVal)
            ct++;
        find(node.left, Math.max(maxVal, node.val));
        find(node.right, Math.max(maxVal, node.val));
    }
}
