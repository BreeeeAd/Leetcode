// Given a binary tree, return the inorder traversal of its nodes' values.
//
// Example:
//
//
// Input: [1,null,2,3]
//    1
//     \
//      2
//     /
//    3
//
// Output: [1,3,2]
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        TreeNode cur = root;
        while(cur != null || !q.isEmpty()){
            if (cur != null){
                q.offerFirst(cur);
                cur = cur.left;
            } else {
                cur = q.pollFirst();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }
}
