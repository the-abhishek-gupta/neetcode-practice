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
        convert(list,root);
        return checkInList(list);
    }
    boolean checkInList(List<Integer> list){
        for (int i = 0; i < list.size()-1; i++)
            if (list.get(i) >= list.get(i+1))
                return false;
        for (int i = 1; i < list.size()-1; i++)
            if (list.get(i) <= list.get(i-1) || list.get(i)>=list.get(i+1))
                return false;
        return true;
    }
    void convert(List<Integer> list, TreeNode node){
        if (node == null)
            return;
        convert(list, node.left);
        list.add(node.val);
        convert(list, node.right);
    }
}
