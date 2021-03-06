// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
//
//
// For example:
// Given binary tree [3,9,20,null,null,15,7],
//
//     3
//    / \
//   9  20
//     /  \
//    15   7
//
//
//
// return its level order traversal as:
//
// [
//   [3],
//   [9,20],
//   [15,7]
// ]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<> ();
        if (root == null){
            return res;
        }
        List<Integer> cur = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0 ;i < size ;i++) {
                TreeNode temp = q.poll();
                cur.add(temp.val);
                if (temp.left !=null) {
                    q.offer(temp.left);
                }
                if(temp.right!= null){
                    q.offer(temp.right);
                }
            }
            res.add(cur);
            cur = new ArrayList<Integer>();
        }
        return res;
        }
}
