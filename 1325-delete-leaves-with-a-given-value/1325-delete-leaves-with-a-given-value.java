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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        root = solve(root , target);
        return root;
    }
    public TreeNode solve(TreeNode root , int target){
        if(root == null){
            return null;
        }

        root.left = solve(root.left,target);
        root.right = solve(root.right, target);
        
        if(root.val == target && root.left == null && root.right == null){
            return null;
        }
        return root;
    }
}