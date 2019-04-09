// Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
// Each element in the array represents your maximum jump length at that position.
//
// Determine if you are able to reach the last index.
//
// Example 1:
//
//
// Input: [2,3,1,1,4]
// Output: true
// Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
//
//
// Example 2:
//
//
// Input: [3,2,1,0,4]
// Output: false
// Explanation: You will always arrive at index 3 no matter what. Its maximum
//              jump length is 0, which makes it impossible to reach the last index.
//
//


class Solution {
    //Time O(N^2) for every element we need to check back M[i]
    // i --> N  we need check most N-1 times M[0] to M[N-1]
    //Space O(N) boolean array size
    public boolean canJump(int[] nums) {
        boolean [] M = new boolean [nums.length];
        M [0] = true;
        for (int i = 1; i < nums.length; i++) {
                for (int j = i - 1; j >= 0; j--){
                    if (nums[j] >= i - j && M[j] == true){
                        M[i] = true;
                        break;
                    }
            }
        }
        return M[nums.length -1];
    }
}
