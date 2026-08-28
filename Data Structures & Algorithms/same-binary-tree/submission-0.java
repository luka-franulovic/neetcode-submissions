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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> bfs1 = new LinkedList<TreeNode>();
        Queue<TreeNode> bfs2 = new LinkedList<TreeNode>();
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        bfs1.add(p);
        bfs2.add(q);
        while (!bfs1.isEmpty() && !bfs2.isEmpty()){
            if (bfs1.size() != bfs2.size()) return false;
            for (int i = 0; i < bfs1.size(); i++){
                TreeNode cur1 = bfs1.remove();
                TreeNode cur2 = bfs2.remove();
                if (cur1.val != cur2.val) return false;

                if(cur1.left == null && cur2.left != null) return false;
                if(cur1.left != null && cur2.left == null) return false;
                if(cur1.right == null && cur2.right != null) return false;
                if(cur1.right != null && cur2.right == null) return false;

                if (cur1.left != null) bfs1.add(cur1.left);
                if (cur1.right != null) bfs1.add(cur1.right);

                if(cur2.left != null) bfs2.add(cur2.left);
                if(cur2.right != null) bfs2.add(cur2.right);
            }
        }
        return true;
    }
}
