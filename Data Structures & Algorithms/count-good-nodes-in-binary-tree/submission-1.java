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
    public int count = 0;
    public int goodNodes(TreeNode root) {
        int value = root.val;
        int max = Integer.MIN_VALUE;
        dfs(root, value, max);
        return count;
    }

    public void dfs(TreeNode root, int value, int max) {
        if(root == null)
            return;
        if(root.val >= max) {
            count++;
            max = root.val;
        }
        dfs(root.left, value, max);
        dfs(root.right, value, max);    
    }
}
