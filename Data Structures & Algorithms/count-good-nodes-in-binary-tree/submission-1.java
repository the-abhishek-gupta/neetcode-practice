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
        return dfs(root, Integer.MIN_VALUE);
    }
    private int dfs(TreeNode root, int currentMax){
        int ct = 0;
        if (root == null)
            return ct;
        if (root.val >= currentMax)
            ct += 1;
        currentMax = Math.max(currentMax, root.val);
        return ct + dfs(root.left, currentMax) + dfs(root.right, currentMax);
    }
}
