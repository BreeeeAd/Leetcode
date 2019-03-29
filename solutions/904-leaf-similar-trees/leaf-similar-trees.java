// Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
//
//
//
// For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
//
// Two binary trees are considered leaf-similar if their leaf value sequence is the same.
//
// Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
//
//  
//
// Note:
//
//
// 	Both of the given trees will have between 1 and 100 nodes.
//
//


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = new ArrayList <>();
        List<Integer> leaf2 = new ArrayList <>();
        dfs(root1, leaf1);
        dfs(root2, leaf2);
        return leaf1.equals(leaf2);
    }
    private void dfs(TreeNode root, List<Integer> leaf){
        if (root != null) {
            if(root.left == null && root.right == null) {
                leaf.add(root.val);
            }
            dfs(root.left, leaf);
            dfs(root.right, leaf);
        }
    }
}
