// Given a collection of numbers that might contain duplicates, return all possible unique permutations.
//
// Example:
//
//
// Input: [1,1,2]
// Output:
// [
//   [1,1,2],
//   [1,2,1],
//   [2,1,1]
// ]
//
//


class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        helper(nums, 0, res);
        return res;
    }
    private void helper(int[] nums, int index, List<List<Integer>> res){
        if (index == nums.length) {
            List<Integer> cur = new ArrayList<>();
            for (int n : nums){
                cur.add(n);
            }
            res.add(cur);
        }
        Set<Integer> used = new HashSet<>();
        for (int i = index; i < nums.length; i++){
            if (used.add(nums[i])){
                swap(nums, i, index);
                helper(nums, index+1, res);
                swap(nums, i, index);
            }
        }
    }
    private void swap(int [] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
