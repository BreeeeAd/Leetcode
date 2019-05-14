// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
// (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
//
// You are given a target value to search. If found in the array return its index, otherwise return -1.
//
// You may assume no duplicate exists in the array.
//
// Your algorithm's runtime complexity must be in the order of O(log n).
//
// Example 1:
//
//
// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4
//
//
// Example 2:
//
//
// Input: nums = [4,5,6,7,0,1,2], target = 3
// Output: -1
//


class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int length = nums.length;
        int l = 0;
        int r = length - 1;
        while(l <= r){
            int mid = l + (r -l) /2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[l]){
              if (target >= nums[l] && target < nums[mid]){
                  r = mid - 1;
              } else {
                  l = mid + 1;
              }
            } else {
                if (target <= nums[r] && target > nums[mid]){
                    l = mid +1;
                } else {
                    r = mid -1;
                }
            }
        }
        return -1;
    }
}
