// Given an array A of integers, return true if and only if we can partition the array into three non-empty parts with equal sums.
//
// Formally, we can partition the array if we can find indexes i+1 < j with (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])
//
//  
//
// Example 1:
//
//
// Input: [0,2,1,-6,6,-7,9,1,2,0,1]
// Output: true
// Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
//
//
//
// Example 2:
//
//
// Input: [0,2,1,-6,6,7,9,-1,2,0,1]
// Output: false
//
//
//
// Example 3:
//
//
// Input: [3,3,6,5,-2,2,5,1,-9,4]
// Output: true
// Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
//
//
//
//
//  
//
// Note:
//
//
// 	3 <= A.length <= 50000
// 	-10000 <= A[i] <= 10000
//
//


class Solution {
    //Time O(n)
    //Space O(1)
    public boolean canThreePartsEqualSum(int[] A) {
        //check input
        if (A == null || A.length == 0) {
            return false;
        }
        //check the sum of A
        //if the sum can be devided by 3 put it into the loop
        //else return false
        int allSum = 0;
        for (int i = 0; i< A.length; i++) {
            allSum += A[i];
        }
        if (allSum % 3 != 0){
            return false;
        }
        int partsSum = allSum / 3;
        int curSum = 0;
        int count = 0;
        //find the first part which sum == partsSum
        //increas the count 
        //reset the curSum
        for (int i = 0; i <A.length ; i++) {
            curSum += A[i];
            if (curSum == partsSum && count <2) {
                count++;
                curSum = 0;
            }
        }
        //if there is 3 part which sum == partSum
        // the last part == partsSum
        return (count == 2 && curSum == partsSum);
    }
}
