// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
//
//
// The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
//
// Example:
//
//
// Input: [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
//


class Solution {
  //Solution 1  Brute force 
  // Time O(N^2) for each int we need to check the leftmax and rightmax n * n
  // Space O(1);
  //   if (height.length < 3){
  //       return 0;
  //   }
  //   int sum = 0;
  //   for (int i = 1; i < height.length -1 ; i++){
  //       int leftMax = findMax(height, 0, i - 1);
  //       int rightMax = findMax(height, i+1, height.length -1);
  //       if (leftMax >= height[i] && rightMax >= height[i]){
  //           int waterLeft = leftMax - height[i];
  //           int waterRight = rightMax - height[i];
  //           sum += Math.min(waterLeft, waterRight);
  //       }
  //   }
  //   return sum;
  // }
  // private int findMax(int [] array, int l ,int r){
  //     int max = 0;
  //     for (int i = l; i <= r; i++){
  //         max = Math.max(max,array[i]);
  //     }
  //     return max;
  // *********************************************
        //Solution 2 
        // to enhance the time we can use int[] to store the leftmax and rightmax
        // when we need two element just check the in[] so that we dont need to traverse all height array;
        // Time O(3N -> N);
        // Space O(2N -> N);
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        for (int i =0; i < height.length;i++){
            if (i == 0) leftMax[i] = height[i];
            else leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
        for (int i =height.length -1; i >= 0;i--){
            if (i == height.length -1) rightMax[i] = height[i];
            else rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }
        int sum =0;
        for (int i =0; i < height.length;i++){
            if (leftMax[i] >= height[i] && rightMax[i] >= height[i]){
                sum += Math.min(leftMax[i] - height[i], rightMax[i] - height[i]);
            }
        }
        return sum;
  }
}
