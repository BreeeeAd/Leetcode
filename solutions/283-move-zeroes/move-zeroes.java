// Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//
// Example:
//
//
// Input: [0,1,0,3,12]
// Output: [1,3,12,0,0]
//
// Note:
//
//
// 	You must do this in-place without making a copy of the array.
// 	Minimize the total number of operations.
//


class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int index = 0;
        // find the every non-0 nums in array
        // put it from 0 - index
        for (int i = 0; i < nums.length; i++) {
            if (nums [i] != 0) {
                nums [index] = nums [i] ;
                index++;
            }
        }
        //if the array is not all filled
        //fill 0 from index to the end
        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
        return;
    }
}
