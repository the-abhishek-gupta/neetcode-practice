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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        traverse(list, root);
        return list.get(k-1);
    }
    void traverse(List<Integer> list, TreeNode node){
        if (node == null)
            return;
        traverse(list, node.left);
        list.add(node.val);
        traverse(list, node.right);
    }
}
