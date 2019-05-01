// Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. Find this single element that appears only once.
//
//  
//
// Example 1:
//
//
// Input: [1,1,2,3,3,4,4,8,8]
// Output: 2
//
//
// Example 2:
//
//
// Input: [3,3,7,7,10,11,11]
// Output: 10
//
//
//  
//
// Note: Your solution should run in O(log n) time and O(1) space.
//


class Solution {
    public int singleNonDuplicate(int[] nums) {
        //Solution1 liner scan
        //compare the nums[i] and nums[i+1] if equals, i move the next pair which is i+=2;
        //if not, means the nums[i] is the single element
        //Time O(n)
        //Space O(1);
        // if (nums == null || nums.length == 0) return -1;
        // if (nums.length == 1) return nums[0];
        // for (int i = 0; i < nums.length - 1; ){
        //     if(nums[i] != nums[i+1]){
        //         return nums[i];
        //     }
        //     i+=2;
        // }
        // return nums[nums.length -1];
        
        //******************************
        //Solution 2 binary search
        //the single element's index has to be odd number
        //also, the pair before single element <even, odd> after is <odd, even>
        //so we can delete the wrong half and search in the right half
        //Time O(logn)
        //Space O(1)
        int left = 0;
        int right = nums.length -1;
        while (left < right){
            int mid = (left + right) / 2;
            int n = mid % 2 == 0 ? mid+1: mid-1; // make sure the pair is <even, odd>
            if (nums[mid] == nums[n]) {
                left = mid +1;
            } else {
                right = mid -1; //
            }
        }
        return nums[left];
    }
}
