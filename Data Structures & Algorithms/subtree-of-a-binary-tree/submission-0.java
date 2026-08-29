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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if (root == null && subRoot == null) return true;
        if (root == null) return false;
        if (subRoot == null) return false;
        q.add(root);
        while (!q.isEmpty()){
            TreeNode cur = q.remove();
            boolean same = sameTree(cur, subRoot);
            if (same) return true;
            
            if (cur.left != null) q.add(cur.left);
            if (cur.right != null) q.add(cur.right);
        }
        return false;

    }
    private boolean sameTree(TreeNode root, TreeNode subRoot){
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();

        if (root == null && subRoot == null) return true;
        if (root == null) return false;
        if (subRoot == null) return false;

        q1.add(root);
        q2.add(subRoot);

        while (!q1.isEmpty() && !q2.isEmpty()){
            if(q1.size() != q2.size()) return false;
            
            for (int i = 0; i < q1.size(); i++){
                TreeNode cur1 = q1.remove();
                TreeNode cur2 = q2.remove();

                if (cur1.val != cur2.val) return false;

                if (cur1.left == null && cur2.left != null) return false;
                if (cur1.left != null && cur2.left == null) return false;
                if (cur1.right == null && cur2.right != null) return false;
                if (cur1.right != null && cur2.right == null) return false;

                if (cur1.left != null && cur2.left != null){
                    q1.add(cur1.left);
                    q2.add(cur2.left);
                }
                if (cur1.right != null && cur2.right != null){
                    q1.add(cur1.right);
                    q2.add(cur2.right);
                }
            }
        }
        if (q1.size() != q2.size()) return false;
        else return true;
    }
}
