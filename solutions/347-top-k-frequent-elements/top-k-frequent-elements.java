// Given a non-empty array of integers, return the k most frequent elements.
//
// Example 1:
//
//
// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]
//
//
//
// Example 2:
//
//
// Input: nums = [1], k = 1
// Output: [1]
//
//
// Note: 
//
//
// 	You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
// 	Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
//
//


class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0){
            return res;
        }
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        //     < nums,    freq>   <key, value>
        //     <1,3> <2,2> <3,1>
        for(int num : nums){
            freqMap.put(num,freqMap.getOrDefault(num,0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer> (k,(n1, n2) -> freqMap.get(n1) - freqMap.get(n2));
        for(int n : freqMap.keySet()){
            if (minHeap.size() <k){
                minHeap.add(n);
            } else {
                if (freqMap.get(minHeap.peek()) <= freqMap.get(n)){
                    minHeap.poll();
                    minHeap.add(n);
                }
            }
        }
        // topK(freqMap, minHeap);
        while (!minHeap.isEmpty()){
            res.add(minHeap.poll());
        }
        return res;
    }
    // private void topK(HashMap<Integer,Integer> freqMap, PriorityQueue<Integer> minHeap){
    //     for (int n : freqMap.keySet()){
    //         minHeap.add(n);
    //         }
    //     }
}
