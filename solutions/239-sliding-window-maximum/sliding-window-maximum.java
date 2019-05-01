// Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
//
// Example:
//
//
// Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
// Output: [3,3,5,5,6,7] 
// Explanation: 
//
// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7
//
//
// Note: 
// You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
//
// Follow up:
// Could you solve it in linear time?


class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
    // Solution 1 use a pq to find the max number in sliding windows
    // Time O(NKlogk)
    // Space O(k)
    //     if (nums == null || nums.length == 0) return new int[0];
    //     int [] res = new int[nums.length -k +1];
    //     for (int i =0; i <= nums.length - k ; i++){
    //         res[i] = findMax(nums, i ,i+k );
    //     }
    //     return res;
    // }
    // private int findMax(int [] nums, int l, int r){
    //     PriorityQueue<Integer> pq = new PriorityQueue<>( Collections.reverseOrder());
    //     for (int i = l; i < r; i++){
    //         pq.offer(nums[i]);
    //     }
    //     return pq.peek();
    
        
        
    //****************************************
    // Solution 2 use deque to find the max number
    // put the new one in right, pop from both left/ right
    // Time 
    // Space
        if (nums == null || nums.length == 0) return new int [0];
        int [] res = new int [nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        int index = 0;
        for (int i = 0; i < nums.length; i++){
            // compare the left index in q with the new index
            // if the index in q is smaller than new one pollFirst
            while (!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}
			// remove smaller numbers in k range as they are useless
			while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
				q.pollLast();
			}
			// q contains index... r contains content
			q.offer(i);
			if (i >= k - 1) {
				res[index++] = nums[q.peek()];
			}
        }
        return res;
    }
}
