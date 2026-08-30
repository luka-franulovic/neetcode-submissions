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
    
    private boolean valid = true;

    public boolean isValidBST(TreeNode root) {
        validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return valid;
        
    }

    private void validate(TreeNode root, long min, long max) {
        if (root == null || !valid) return;
        if (root.val >= max || root.val <= min){
            valid = false;
            return;
        }

        validate(root.left, min, root.val);
        validate(root.right, root.val, max);
    }
}
