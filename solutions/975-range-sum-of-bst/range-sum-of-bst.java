// Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
//
// The binary search tree is guaranteed to have unique values.
//
//  
//
//
// Example 1:
//
//
// Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
// Output: 32
//
//
//
// Example 2:
//
//
// Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
// Output: 23
//
//
//  
//
// Note:
//
//
// 	The number of nodes in the tree is at most 10000.
// 	The final answer is guaranteed to be less than 2^31.
//
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
    //Time O(N) worst case every node.val between L,R
    //Space O(height);
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        if (root.val < L)  return rangeSumBST(root.right, L, R);
        // if root.val smaller then L , we need find the rest sum in right subtree;
        if (root.val > R)  return rangeSumBST(root.left, L, R);
        // if root.val greater then R, we nee find the rest sum in left subtree;
        return rangeSumBST(root.right, L, R) +rangeSumBST(root.left, L, R) +root.val;
        // if root.val between L, R add root.val, left sum and right sum; 
    }
}
