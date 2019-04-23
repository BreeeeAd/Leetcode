// Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
//
// You may assume that the array is non-empty and the majority element always exist in the array.
//
// Example 1:
//
//
// Input: [3,2,3]
// Output: 3
//
// Example 2:
//
//
// Input: [2,2,1,1,1,2,2]
// Output: 2
//
//


class Solution {
    public int majorityElement(int[] nums) {
        //Solution 1 use hashmap count each number
        //if count > 1/2 * length return number
        // Time O(N)
        // Space O(N)
        // Map<Integer, Integer> map = new HashMap<>();
        // for (int i = 0; i <nums.length; i++) {
        //     map.put(nums[i] , map.getOrDefault(nums[i], 0) + 1);
        //     if (map.get(nums[i]) > 0.5 * nums.length){
        //         return nums[i];
        //     }
        // }
        // return -1;
        //********************************
        //Solution 2 voting algrothm
        //assum the first one is majority one
        //campare with others if same count++/ different count--
        //if count == 0 set new number as majority number
        //return number with count == 1;
        int res = nums[0];
        int count = 0;
        for (int n : nums){
            if (n == res) count ++;
            if (n != res) {
                if(--count == 0){
                    res = n;
                    count = 1;
                }
            }
        }
        return res;
    }
}
