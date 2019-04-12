// Given a collection of distinct integers, return all possible permutations.
//
// Example:
//
//
// Input: [1,2,3]
// Output:
// [
//   [1,2,3],
//   [1,3,2],
//   [2,1,3],
//   [2,3,1],
//   [3,1,2],
//   [3,2,1]
// ]
//
//


class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        helper (res,nums,0);
        return res;
    }
    private void helper (List<List<Integer>> res, int[] nums, int index){
        if (index == nums.length){
            List<Integer> cur = new ArrayList<>();
            for (Integer num : nums){
                cur.add(num);
            }
            res.add(new ArrayList<Integer> (cur));
            return;
        }
        for (int i = index; i < nums.length;i++){
            swap(nums, index, i);
            helper(res,nums, index+1);
            swap(nums,index,i);
        }
        
    }
    private void swap (int [] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
