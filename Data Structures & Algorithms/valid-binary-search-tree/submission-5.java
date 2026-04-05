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
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrderTraverse(list, root);
        for (int i = 0; i < list.size()-1; i++){
            if (list.get(i) >= list.get(i+1))
                return false;
        }
        return true;
    }
    private void inOrderTraverse(List<Integer> list, TreeNode root){
        if (root == null)
            return;
        inOrderTraverse(list, root.left);
        list.add(root.val);
        inOrderTraverse(list, root.right);
    }
}
