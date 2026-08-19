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

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        // column -> list of [row, value]
        HashMap<Integer, List<int[]>> map = new HashMap<>();

        dfs(root, 0, 0, map);

        List<Integer> columns = new ArrayList<>(map.keySet());
        Collections.sort(columns);
        List<List<Integer>> ans = new ArrayList<>();
        for (int col : columns) {
            List<int[]> list = map.get(col);
            Collections.sort(list, (a, b) -> {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            });
            List<Integer> temp = new ArrayList<>();
            for (int[] node : list) {
                temp.add(node[1]);
            }
            ans.add(temp);
        }
        return ans;
    }
    private void dfs(TreeNode node, int row, int col,HashMap<Integer, List<int[]>> map) {
        if (node == null) {
            return;
        }
        map.putIfAbsent(col, new ArrayList<>());
        map.get(col).add(new int[]{row, node.val});
        dfs(node.left, row + 1, col - 1, map);
        dfs(node.right, row + 1, col + 1, map);
    }
}