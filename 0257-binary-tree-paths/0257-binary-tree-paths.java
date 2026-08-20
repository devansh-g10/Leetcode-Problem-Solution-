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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        path(root,ans,"");
        return ans;
    }
    public static void path(TreeNode root, List<String> ans , String str){
        if(root == null) return ;
        if(str.equals("")){
            str = root.val + "";
        }
        else{
            str += "->" + root.val;
        }
        if(root.left == null && root.right == null){
            ans.add(str);
            return;
        }
        path(root.left,ans,str);
        path(root.right,ans,str);
    }
}