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
        ArrayDeque<TreeNode> dq = new ArrayDeque<>();
        if(root == null) return arr;

        dq.offer(root);
        while(!dq.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = dq.size();
            for(int i = 0;i < size ; i++){
                TreeNode node = dq.poll();
                if(i == size-1){
                    arr.add(node.val);
                }
                if(node.left != null) dq.offer(node.left);
                if(node.right != null) dq.offer(node.right);
            }
        }
        return arr;
    }
}