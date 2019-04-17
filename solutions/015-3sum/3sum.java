// Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
// Note:
//
// The solution set must not contain duplicate triplets.
//
// Example:
//
//
// Given array nums = [-1, 0, 1, 2, -1, -4],
//
// A solution set is:
// [
//   [-1, 0, 1],
//   [-1, -1, 2]
// ]
//
//


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        List<Integer> cur = new ArrayList<>();
        if(n <3){
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < n; i++){
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int remain = 0 - nums[i];
            int left = i + 1; 
            int right = n -1 ;
            while (left < right){
                if (nums[left] + nums[right] == remain){
                    cur.add(nums[i]);
                    cur.add(nums[left]);
                    cur.add(nums[right]);
                    res.add(cur);
                    cur = new ArrayList<>();
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left -1]){
                        left++;
                    }
                    while(right > left && nums[right] == nums[right + 1]){
                        right--;
                    }
                } else if (nums[left] + nums[right] < remain){
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
