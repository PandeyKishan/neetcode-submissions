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
    // Integer prev = null;
    // List<Integer> result = new ArrayList<>();
    // public int kthSmallest(TreeNode root, int k) {
    //   if(isValidBST(root)) {
    //     return result.get(k - 1);
    //   } 
    //   return 0;
    // }

    // public boolean isValidBST(TreeNode root) {
    //     if(root == null)
    //         return true;
    //     if(!isValidBST(root.left))
    //         return false;
    //     if(prev != null && root.val <= prev) 
    //         return false;
    //     prev = root.val;
    //     result.add(prev);
    //     if(!isValidBST(root.right))
    //         return false;
    //     return true;            
    // }
    int count = 0;
    int answer = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return answer;
    } 

    public void inorder(TreeNode root, int k) {
        if(root == null)
            return;
        inorder(root.left, k);
        count++;
        if(count == k) {
            answer = root.val;
            return;
        }
        inorder(root.right, k);    
    }
}
