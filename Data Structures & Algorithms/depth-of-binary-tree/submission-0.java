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
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int level = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                TreeNode cur = q.remove();
                
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
            level++;
        }

        return level;
    }
}
