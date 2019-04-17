// You are given an n x n 2D matrix representing an image.
//
// Rotate the image by 90 degrees (clockwise).
//
// Note:
//
// You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
//
// Example 1:
//
//
// Given input matrix = 
// [
//   [1,2,3],
//   [4,5,6],
//   [7,8,9]
// ],
//
// rotate the input matrix in-place such that it becomes:
// [
//   [7,4,1],
//   [8,5,2],
//   [9,6,3]
// ]
//
//
// Example 2:
//
//
// Given input matrix =
// [
//   [ 5, 1, 9,11],
//   [ 2, 4, 8,10],
//   [13, 3, 6, 7],
//   [15,14,12,16]
// ], 
//
// rotate the input matrix in-place such that it becomes:
// [
//   [15,13, 2, 5],
//   [14, 3, 4, 1],
//   [12, 6, 8, 9],
//   [16, 7,10,11]
// ]
//
//


class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n <= 1){
            return;
        }
        int round = n /2;
        for(int level =0; level< round; level++){
            int left = level;//start point for each round
            int right = n - 2 - level; // offset for each round
            for (int j = left; j <=right; j ++){
                int temp = matrix[left][j];
                //generally for each point 
                //m[0][0]             m[0][n-2] m[0][n-1]
                //
                //
                //m[n-2][0]
                //m[n-1][0]           m[n-1][n-2]m[n-1][n-1] 
                matrix[left][j] = matrix[n - 1- j][left];
                matrix[n -1- j][left] = matrix[n -1- left][n -1-j];
                matrix[n -1- left] [n - 1- j] = matrix[j][n - 1- left];
                matrix[j] [ n-1-left] = temp;
            }
        }
    }
}
