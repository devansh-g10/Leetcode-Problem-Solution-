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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        return right(root, 0, arr);
    }
    static List<Integer> right(TreeNode root, int level, List<Integer> arr){
        if(root == null){
            return arr;
        }
        if(arr.size() == level){
            arr.add(root.val);
        }
        right(root.right, level + 1, arr);
        right(root.left, level + 1, arr);
        return arr;
    }
}