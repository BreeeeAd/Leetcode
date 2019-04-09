// Given an array, rotate the array to the right by k steps, where k is non-negative.
//
// Example 1:
//
//
// Input: [1,2,3,4,5,6,7] and k = 3
// Output: [5,6,7,1,2,3,4]
// Explanation:
// rotate 1 steps to the right: [7,1,2,3,4,5,6]
// rotate 2 steps to the right: [6,7,1,2,3,4,5]
// rotate 3 steps to the right: [5,6,7,1,2,3,4]
//
//
// Example 2:
//
//
// Input: [-1,-100,3,99] and k = 2
// Output: [3,99,-1,-100]
// Explanation: 
// rotate 1 steps to the right: [99,-1,-100,3]
// rotate 2 steps to the right: [3,99,-1,-100]
//
//
// Note:
//
//
// 	Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
// 	Could you do it in-place with O(1) extra space?
//


class Solution {
    public void rotate(int[] nums, int k) {
        // reverse 3 times
        // #1 whole array
        // #2 [0,k -1]
        // #3 [k, end]
        // Time O(2N --> N)
        // Space O(1)
        if (k >= nums.length){
            k %= nums.length;
        }
        reverse(nums, 0, nums.length -1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length -1);
    }
    private void reverse (int [] nums, int i, int j) {
        if (nums.length < 2) {
            return;
        }
        while (i < j){
            swap(nums, i ,j);
            i++;
            j--;
        }
    }
    private void swap (int [] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
