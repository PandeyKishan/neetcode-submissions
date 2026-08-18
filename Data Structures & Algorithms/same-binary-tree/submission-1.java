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
    // public boolean isSameTree(TreeNode p, TreeNode q) {
    // ArrayList<Integer> listP = new ArrayList<>();
    // ArrayList<Integer> listQ = new ArrayList<>();

    //     createList(p, listP);
    //     createList(q, listQ);

    //     return listP.equals(listQ);
    // }

    // private void createList(TreeNode node, ArrayList<Integer> list) {
    //     if (node == null) {
    //         list.add(null);
    //         return;
    //     }

    //     list.add(node.val);

    //     createList(node.left, list);
    //     createList(node.right, list);
    // }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if (p == null || q == null)
            return false;

        if (p.val != q.val)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }    
}
