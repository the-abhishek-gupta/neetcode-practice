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
        TreeNode root = new TreeNode(preorder[0]);
        int rootIndex = findRootIndex(preorder[0], inorder);
        int[] leftPreorder = getArr(preorder, 1, rootIndex);
        int[] rightPreorder = getArr(preorder, rootIndex+1, preorder.length-1);
        int[] leftInorder = getArr(inorder, 0, rootIndex-1);
        int[] rightInorder = getArr(inorder, rootIndex+1, inorder.length-1);
        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);

        return root;
    }

    private int[] getArr(int[] arr, int start, int end){
        int[] ans = new int[end-start+1];
        int index = 0;
        while (start <= end){
            ans[index++] = arr[start++];
        }
        return ans;
    }
    private int findRootIndex(int val, int[] arr){
        
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == val)
                return i;
        return -1;
    }


    
}
