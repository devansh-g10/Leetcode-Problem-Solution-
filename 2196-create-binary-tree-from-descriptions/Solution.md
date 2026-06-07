# Code in java with 75% Beats 

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
Each description [parent, child, isLeft] represents a parent-child relationship in the binary tree.

To build the tree efficiently:

Use a HashMap to store and access nodes by their values.
Connect each child node to its parent's left or right pointer based on isLeft.
Keep track of all nodes that appear as children in a HashSet.
The root is the only node that never appears as a child.
# Approach
<!-- Describe your approach to solving the problem. -->
Create a HashMap<Integer, TreeNode> to store all nodes.
Iterate through each description:
Create parent and child nodes if they do not already exist.
Connect the child to the parent's left or right side.
Add the child value to a HashSet.
After processing all descriptions, iterate through all node values.
The node that is not present in the child set is the root.
Return that root node.
# Complexity
- Time complexity: O(n)
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity: O(n)
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```java []
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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] d : descriptions) {
            int parent = d[0];
            int child = d[1];
            int isLeft = d[2];

            map.putIfAbsent(parent, new TreeNode(parent));
            map.putIfAbsent(child, new TreeNode(child));

            TreeNode parentNode = map.get(parent);
            TreeNode childNode = map.get(child);

            if (isLeft == 1) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }

            children.add(child);
        }

        for (int node : map.keySet()) {
            if (!children.contains(node)) {
                return map.get(node);
            }
        }

        return null;
    }
}
```