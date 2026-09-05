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
    Long prev;
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        if(!isValidBST(root.left))
            return false;
        if(prev != null && root.val <= prev)
            return false; 
        prev = (long) root.val;
        // Check right subtree
        if (!isValidBST(root.right))
            return false;
        return true;       
        // if(root == null)
        //     return false;
        // Queue<TreeNode> nodes = new LinkedList<>();
        // Queue<Long> mins = new LinkedList<>();
        // Queue<Long> maxs = new LinkedList<>();

        // nodes.offer(root);
        // mins.offer(Long.MIN_VALUE);
        // maxs.offer(Long.MAX_VALUE);

        // while(!nodes.isEmpty()) {
        //     TreeNode node = nodes.poll();
        //     long min = mins.poll();
        //     long max = maxs.poll();

        //     if(node.val <= min || node.val >= max)
        //         return false;
        //     if(node.left != null) {
        //         nodes.offer(node.left);
        //         mins.offer(min);
        //         maxs.offer((long) node.val);
        //     }    
        //     if(node.right != null) {
        //         nodes.offer(node.right);
        //         mins.offer((long) node.val);
        //         maxs.offer(max);
        //     }       
        // }
        // return true;    
        
    }
}
