// Given a set of distinct integers, nums, return all possible subsets (the power set).
//
// Note: The solution set must not contain duplicate subsets.
//
// Example:
//
//
// Input: nums = [1,2,3]
// Output:
// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]
//


class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<> ();
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> cur = new ArrayList<> ();
        helper(res, cur, nums,0);
        return res;
    }
    private void helper (List<List<Integer>> res, List<Integer> cur, int[] nums, int index) {
        if (index == nums.length ) {
            res.add(new ArrayList<Integer> (cur));
            return;
        }
        helper(res,cur,nums,index+1);
        cur.add(nums[index]);
        helper(res,cur, nums, index+1);
        cur.remove(cur.size() -1);
    }
}
