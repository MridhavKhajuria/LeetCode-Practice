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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        back(root,targetSum,new ArrayList<>(), res);
        return res;
    }
    private void back(TreeNode node,int remaining, List<Integer> path, List<List<Integer>> res){
        if(node == null) return;
        path.add(node.val);
        remaining -= node.val;
        if(node.left == null && node.right == null && remaining == 0){
            res.add(new ArrayList<>(path));
        }else{
            back(node.left, remaining, path, res);
            back(node.right,remaining, path, res);
        }
        path.remove(path.size() - 1);
    }
}