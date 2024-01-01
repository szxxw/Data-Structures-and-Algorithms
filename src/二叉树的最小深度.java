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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        // TreeNode left = root.left;
        // TreeNode right = root.right;
        // if(left == null && right == null) return 1;
        int minDepth = 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        loop: while(!q.isEmpty()) {
            int size = q.size();
            minDepth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                TreeNode left = node.left;
                TreeNode right = node.right;
                if(left != null) q.offer(left);
                if(right != null) q.offer(right);
                if(left == null && right == null) {
                    break loop;
                }
            }
        }
        return minDepth;
    }
}
