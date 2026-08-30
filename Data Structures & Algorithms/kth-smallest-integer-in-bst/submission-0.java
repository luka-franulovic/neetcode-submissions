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
    private ArrayList<Integer> smallest;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        smallest = new ArrayList<Integer>();
        inorder(root);
        return smallest.get(k - 1);
    }

    private void inorder(TreeNode root){
        if (root == null) return;

        inorder(root.left);
        smallest.add(root.val);
        inorder(root.right);
    }
}
