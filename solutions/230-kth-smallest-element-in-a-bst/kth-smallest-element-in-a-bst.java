// Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
//
// Note: 
// You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
//
// Example 1:
//
//
// Input: root = [3,1,4,null,2], k = 1
//    3
//   / \
//  1   4
//   \
//    2
// Output: 1
//
// Example 2:
//
//
// Input: root = [5,3,6,2,4,null,null,1], k = 3
//        5
//       / \
//      3   6
//     / \
//    2   4
//   /
//  1
// Output: 3
//
//
// Follow up:
// What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
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
    public int kthSmallest(TreeNode root, int k) {
        // in order the BST then return the index k-1 element;
        // Time O(n)
        // Space O(height + n)
    //     if (root == null) return -1;
    //     List<Integer> res = new ArrayList<>();
    //     inorder(root,res);
    //     return res.get(k-1);
    // }
    // private void inorder(TreeNode root, List<Integer> res){
    //     Deque<TreeNode> stack = new ArrayDeque<>();
    //     TreeNode cur = root;
    //     stack.offerFirst(root);
    //     while(cur != null || !stack.isEmpty()){
    //         if(cur == null){
    //             cur = stack.pollFirst();
    //             res.add(cur.val);
    //             cur = cur.right;
    //         } else {
    //             stack.offerFirst(cur);
    //             cur = cur.left;
    //         }
    //     }
        if(root == null) return -1;
        int[] count = new int[2];
        inorder(root,count,k);
        return count[1];
    }
    private void inorder(TreeNode root,int [] count, int k){
        if (root.left != null){
            inorder(root.left,count, k);
        }
        count[0]++;
        if (count[0] == k){
            count[1] = root.val;
            return;
        }
        if(root.right != null){
            inorder(root.right, count, k);
        }
    }
}
