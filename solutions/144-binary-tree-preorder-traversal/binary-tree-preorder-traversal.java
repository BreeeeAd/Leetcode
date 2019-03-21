// Given a binary tree, return the preorder traversal of its nodes' values.
//
// Example:
//
//
// Input: [1,null,2,3]
//    1
//     \
//      2
//     /
//    3
//
// Output: [1,2,3]
//
//
// Follow up: Recursive solution is trivial, could you do it iteratively?
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<> ();
        if (root == null){
            return preOrder;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.offerFirst(root);
        while (! stack.isEmpty()){
            TreeNode cur = stack.pollFirst();
            if (cur.right != null){
                stack.offerFirst(cur.right);
            }
            if (cur.left != null){
                stack.offerFirst(cur.left);
            }
            preOrder.add(cur.val);
        }
        return preOrder;
    }
}
