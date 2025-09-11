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
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> list = new LinkedList<>();
        list.offer(root);
        while(!list.isEmpty()){
            List<Integer> row = new ArrayList<>();
            int n = list.size();
            for(int i = 0; i<n; i++){
                TreeNode front = list.poll();
                row.add(front.val);
                if(front.left != null) list.offer(front.left);
                if(front.right != null) list.offer(front.right);
            }
            res.add(row);
        }
        return res;
    }
}