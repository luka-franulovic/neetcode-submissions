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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int smaller = Math.min(p.val, q.val);
        int bigger = Math.max(p.val, q.val);

        while (root != null){
            if (root.val >= smaller && root.val <= bigger){
                return root;
            }
            else{
                if (smaller <= root.val && bigger <= root.val){
                    root = root.left;
                }
                else{
                    root = root.right;
                }
            }
        }
        return null;
    }


}
