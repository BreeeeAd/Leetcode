// Given a non-empty array of integers, every element appears twice except for one. Find that single one.
//
// Note:
//
// Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
//
// Example 1:
//
//
// Input: [2,2,1]
// Output: 1
//
//
// Example 2:
//
//
// Input: [4,1,2,1,2]
// Output: 4
//
//


class Solution {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];
        int res = 0;
        for (int n : nums){
            res ^= n;
            // n ^ n == 1;
            // 1 ^ n == n;
            // cause there is only one single number, it means the others all show up in pairs
            // XOR opreation will only have the single one
        }
        return res;
    }
}
