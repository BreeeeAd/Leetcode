// Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//
// If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
//
// The replacement must be in-place and use only constant extra memory.
//
// Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
//
// 1,2,3 → 1,3,2
// 3,2,1 → 1,2,3
// 1,1,5 → 1,5,1
//


class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        } // Find 1st id i that breaks descending order
        if(i >= 0) {                           // If not entirely descending
            int j = nums.length - 1;              // Start from the end
            while(nums[j] <= nums[i]) {
                j--;
            }          // Find rightmost first larger id j
            swap(nums, i, j);                     // Switch i and j
        }
            reverse(nums, i + 1, nums.length - 1); 
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int [] nums, int i, int j){
        while(i<j){
            swap(nums, i++,j--);
        }
        return;
    }
}
