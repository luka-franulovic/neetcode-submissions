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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if (root == null) return new ArrayList<>();
        q.add(root);
        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size - 1; i++){
                TreeNode cur = q.remove();
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
            TreeNode last = q.remove();
            if (last.left != null) q.add(last.left);
            if (last.right != null) q.add(last.right);
            result.add(last.val); 
        }
        return result;
    }
}
