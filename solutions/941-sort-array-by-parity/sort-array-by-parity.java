// Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
//
// You may return any answer array that satisfies this condition.
//
//  
//
//
// Example 1:
//
//
// Input: [3,1,2,4]
// Output: [2,4,3,1]
// The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
//
//
//  
//
// Note:
//
//
// 	1 <= A.length <= 5000
// 	0 <= A[i] <= 5000
//
//
//


class Solution {
    public int[] sortArrayByParity(int[] A) {
        //2 pointer start , end
        //if start point to even and end point to odd 
        //swap each other
        if (A == null || A.length < 2){
            return A;
        }
        int start = 0;
        int end = A.length -1;
        while (start < end) {
            if (!isOdd(A[start]) && isOdd(A[end])){
                swap(A, start, end);
                start++;
                end--;
            } else if (isOdd(A[start])){
                start++;
            } else if (!isOdd(A[end])){
                end--;
            }
        }
        return A;
    }
    private boolean isOdd (int n) {
        return n % 2 == 0;
    }
    private void swap(int [] a, int i ,int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
