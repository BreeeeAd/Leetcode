// Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
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
// return its zigzag level order traversal as:
//
// [
//   [3],
//   [20,9],
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<> ();
        List<Integer> cur = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque <TreeNode> deque = new ArrayDeque<> ();
        deque.offerFirst(root);
        int layer = 0;
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i< size; i++){
                if (layer == 0) {
                    TreeNode temp = deque.pollLast();
                    cur.add(temp.val);
                    if (temp.left != null){
                        deque.offerFirst(temp.left);
                    }
                    if(temp.right != null){
                        deque.offerFirst(temp.right);
                    }
                }else {
                    TreeNode temp = deque.pollFirst();
                    cur.add(temp.val);
                    if (temp.right != null) {
                        deque.offerLast(temp.right);
                    }
                    if (temp.left != null){
                        deque.offerLast(temp.left);
                    }
                }
            }
            res.add(cur);
            cur = new ArrayList<>();
            layer = 1- layer;
        }
        return res;
    }
}
