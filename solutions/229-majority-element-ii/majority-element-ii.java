// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
//
// Note: The algorithm should run in linear time and in O(1) space.
//
// Example 1:
//
//
// Input: [3,2,3]
// Output: [3]
//
// Example 2:
//
//
// Input: [1,1,1,3,3,2,2,2]
// Output: [1,2]
//


class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        int n1 = nums[0];
        int n2 = nums[0];
        int count1 = 0;
        int count2 = 0;
        for (int n : nums){
            if (n == n1) count1++;
            else if (n == n2) count2++;
            else if ( count1 == 0) {n1 = n; count1++;}
            else if ( count2 == 0) {n2 = n; count2++;}
            else {count1--; count2--;}
        }
        if(n1 == n2) {
            res.add(n1);
            return res;
        }
        count1 = 0;
        count2 = 0;
        for (int n : nums){
            if ( n == n1) count1++;
            if ( n == n2) count2++;
        }
        if(count1 > nums.length / 3) res.add(n1);
        if(count2 > nums.length / 3) res.add(n2);
        return res;
    }
}
