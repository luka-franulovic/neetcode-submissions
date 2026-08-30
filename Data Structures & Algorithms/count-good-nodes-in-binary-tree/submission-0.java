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
    private int number = 0;
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        dfs(root, root.val);
        return number;
    }

    private void dfs(TreeNode root, int maxSeen){
        if (root == null) return;

        if (root.val >= maxSeen) number++;
        dfs(root.left, Math.max(root.val, maxSeen));
        dfs(root.right, Math.max(root.val, maxSeen));
    }

}
