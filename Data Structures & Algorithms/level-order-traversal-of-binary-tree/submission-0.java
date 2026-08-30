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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        q.add(root);
        while (!q.isEmpty()){
            List<Integer> currentLevel = new ArrayList<Integer>();
            int size = q.size();
            for (int i = 0; i < size; i++){
                TreeNode cur = q.remove();
                currentLevel.add(cur.val);
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
            result.add(currentLevel);
        }
        return result;
    }
}
