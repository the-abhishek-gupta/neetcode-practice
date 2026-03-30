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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        TreeNode rootVal = new TreeNode(preorder[0]);
        int rootIndex = findRootIndex(preorder[0], inorder);
        int[] leftInorder = getLeft(inorder, rootIndex);
        int[] rightInorder = getRight(inorder, rootIndex);
        int[] leftPreorder = getLeftPre(preorder, rootIndex);
        int[] rightPreorder = getRightPre(preorder, rootIndex);
        rootVal.left = buildTree(leftPreorder, leftInorder);
        rootVal.right = buildTree(rightPreorder, rightInorder);
        return rootVal;
    }
    int[] getRightPre(int[] preorder, int index){
        int n = preorder.length - index - 1;
        int ans[] = new int[n];
        int j = 0;
        for (int i = index + 1; i < preorder.length; i++)
            ans[j++] = preorder[i];
        return ans;
    }
    int[] getLeftPre(int[] preorder, int index){
        int ans[] = new int[index];
        for (int i = 1; i < index+1; i++)
            ans[i-1] = preorder[i];
        return ans;
    }
    private int findRootIndex(int val, int[] arr){
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == val)
                return i;
        return -1;
    }
    int[] getLeft(int[] inorder, int index){
        int[] ans = new int[index];
        for (int i = 0; i < index; i++)
            ans[i] = inorder[i];
        return ans;
    }
    int[] getRight(int[] inorder, int index){
        int n = inorder.length - index -1;
        int[] ans = new int[n];
        int j = 0;
        for (int i = index + 1; i < inorder.length; i++)
            ans[j++] = inorder[i];
        return ans;
    }
}
