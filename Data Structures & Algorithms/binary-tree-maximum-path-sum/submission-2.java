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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode node) {
        dfs(node);
        return max;
    }
    private int dfs(TreeNode node){
        if (node == null)
            return 0;

        int leftSum = Math.max(0, dfs(node.left));
        int rightSum = Math.max(0,dfs(node.right));
        max = Math.max(max, leftSum + rightSum + node.val);
        return Math.max(leftSum, rightSum) + node.val;
    }
}
