// Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
//
// Note: The solution set must not contain duplicate subsets.
//
// Example:
//
//
// Input: [1,2,2]
// Output:
// [
//   [2],
//   [1],
//   [1,2,2],
//   [2,2],
//   [1,2],
//   []
// ]
//
//


class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        List<Integer> cur = new ArrayList<>();
        helper(nums,0,cur,res);
        return res;
    }
    private void helper(int [] nums, int index,List<Integer> cur, List<List<Integer>> res){
        if(index <= nums.length ){
            res.add(new ArrayList<>(cur));
        }
        while(index < nums.length){
            cur.add(nums[index]);
            helper(nums,index+1,cur,res);
            cur.remove(cur.size()-1);
            index++;
            while(index < nums.length && nums[index] == nums[index-1]){
                index++;
            }
        }
        return;
    }
}
