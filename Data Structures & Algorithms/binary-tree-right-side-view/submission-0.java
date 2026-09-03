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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightViewDfs(root, 0, result);
        return result;
    }

    public void rightViewDfs(TreeNode root, int depth, List<Integer> result) {
        if(root == null)
            return;
        if(result.size() == depth)
            result.add(root.val);
        rightViewDfs(root.right, depth + 1, result);
        rightViewDfs(root.left, depth + 1, result);        
    }
}
