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
    int count = 0;
    TreeNode res;
    public int kthSmallest(TreeNode root, int k) {

        find(root, k);
        return res.val;
    }
    private void find(TreeNode node, int k){
        if(node == null) return;
        find(node.left, k);
        count++;
        if(count == k){
            res = node;
            return;
        }
        find(node.right, k);
    }
}