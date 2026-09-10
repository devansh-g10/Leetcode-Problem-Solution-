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
    int result = 0;

    public int averageOfSubtree(TreeNode root) {
        solve(root);
        return result;
    }

    private int[] solve(TreeNode root){
        if(root == null){
            return new int[]{0,0};
        }
            int[] left = solve(root.left);
            int[] right = solve(root.right);

            int subtreeSum = left[0] + right[0] + root.val;
            int subtreeCount = left[1] + right[1] + 1;

            if(subtreeSum / subtreeCount == root.val){
                result++;
            }
            return new int[]{subtreeSum , subtreeCount};
        }
}