// Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
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
// return its bottom-up level order traversal as:
//
// [
//   [15,7],
//   [9,20],
//   [3]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<> ();
        if (root == null){
            return res;
        }
        List<Integer> cur = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        Deque<List<Integer>> stack = new ArrayDeque<>();
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
            stack.offerFirst(cur);
            cur = new ArrayList<Integer>();
        }
        while(!stack.isEmpty()){
            res.add(stack.pollFirst());
        }
        return res;
    }
}
