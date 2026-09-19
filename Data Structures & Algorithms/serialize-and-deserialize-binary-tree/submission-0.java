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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer result = new StringBuffer();
        dfs(root, result);

        return result.toString();
    }

    public void dfs(TreeNode root, StringBuffer result) {
        if(root == null) {
            result.append("null").append(",");
            return;
        }    
        result.append(root.val).append(",");
        dfs(root.left, result);
        dfs(root.right, result);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        Queue<String> q = new LinkedList<>(Arrays.asList(values));

        return dfs(q);
    }

    public TreeNode dfs(Queue<String> q) {
        String value = q.poll();

        if(value.equals("null"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(value));  
        root.left = dfs(q);
        root.right = dfs(q);

        return root;
    }
}


// StringBuffer result = new StringBuffer(); as a class-level variable. If      serialize() is called more than once on the same Codec object, the results will get appended together.
