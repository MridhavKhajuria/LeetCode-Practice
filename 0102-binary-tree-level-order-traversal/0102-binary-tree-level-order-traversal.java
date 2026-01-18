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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        level(root, ans, count);
        return ans;
    }
    private void level(TreeNode node, List<List<Integer>> ans, int count){
        if(node == null) return;
        if(count == ans.size()) ans.add(new ArrayList<>());
        ans.get(count).add(node.val);
        level(node.left, ans, count+1);
        level(node.right, ans, count+1);
    }
}