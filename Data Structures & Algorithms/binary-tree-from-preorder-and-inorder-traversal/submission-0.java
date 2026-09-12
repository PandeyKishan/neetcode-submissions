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
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int inStart, int inEnd) {
        if(inStart > inEnd)
            return null;

        int rootValue = preorder[preIndex];
        preIndex++;

        TreeNode root = new TreeNode(rootValue);
        int index = inStart;

        while (inorder[index] != rootValue)
            index++;
        
        root.left = build(preorder, inorder, inStart, index - 1);
        root.right = build(preorder, inorder, index + 1, inEnd);

        return root;
    }
}
