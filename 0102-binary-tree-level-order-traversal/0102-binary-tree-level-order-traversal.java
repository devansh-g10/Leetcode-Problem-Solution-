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
        List<List<Integer>> arr = new ArrayList<>();
        pre(root , arr , 0);
        return arr;
    }
    static void pre(TreeNode root , List<List<Integer>> arr , int level){
        if(root == null){
            return;
        }
        if(level == arr.size()){
            arr.add(new ArrayList<>());
        }
        arr.get(level).add(root.val);
        pre(root.left , arr , level + 1);
        pre(root.right , arr , level + 1);
    }
}