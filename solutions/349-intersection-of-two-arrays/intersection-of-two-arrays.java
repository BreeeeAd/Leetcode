// Given two arrays, write a function to compute their intersection.
//
// Example 1:
//
//
// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2]
//
//
//
// Example 2:
//
//
// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [9,4]
//
//
// Note:
//
//
// 	Each element in the result must be unique.
// 	The result can be in any order.
//
//
//  
//


class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int n : nums1){
            set1.add(n);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int n : nums2){
            set2.add(n);
        }
        int [] res = new int [Math.min(nums1.length, nums2.length)];
        int index = 0;
        for (Integer m : set1){
            if (set2.contains(m)){
                res[index] = m;
                index++;
            }
        }
        return Arrays.copyOf(res, index);
    }
}
