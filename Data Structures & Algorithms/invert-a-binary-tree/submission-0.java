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
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        if(root == null) return null;

        while (!q.isEmpty()){
            TreeNode tmp = q.remove();

            TreeNode left = tmp.left;
            tmp.left = tmp.right;
            tmp.right = left;

            q2.add(tmp);

            if(tmp.left != null) q.add(tmp.left);
            if(tmp.right != null) q.add(tmp.right);

        }
        return q2.remove();
    }
}
