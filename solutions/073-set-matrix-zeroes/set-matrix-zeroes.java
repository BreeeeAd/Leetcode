// Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
//
// Example 1:
//
//
// Input: 
// [
//   [1,1,1],
//   [1,0,1],
//   [1,1,1]
// ]
// Output: 
// [
//   [1,0,1],
//   [0,0,0],
//   [1,0,1]
// ]
//
//
// Example 2:
//
//
// Input: 
// [
//   [0,1,2,0],
//   [3,4,5,2],
//   [1,3,1,5]
// ]
// Output: 
// [
//   [0,0,0,0],
//   [0,4,5,0],
//   [0,3,1,0]
// ]
//
//
// Follow up:
//
//
// 	A straight forward solution using O(mn) space is probably a bad idea.
// 	A simple improvement uses O(m + n) space, but still not the best solution.
// 	Could you devise a constant space solution?
//
//


class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null ||matrix.length == 0|| matrix[0].length == 0) {
            return;
        }
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length;i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == 0 && visited[i][j] == false){
                    helper(matrix, visited,i,j);
                }
            }
        }
        return;
    }
    private void helper(int[][] matrix, boolean[][] visited, int x, int y){
        for (int i = 0; i < matrix[0].length; i++){
            if (matrix[x][i] != 0 && !visited[x][i]){
                matrix[x][i] = 0;
                visited[x][i] = true;
            } 
        }
        for (int j = 0; j < matrix.length; j++){
            if (matrix[j][y] != 0 && !visited[j][y] ) {
            matrix[j][y] = 0;
            visited[j][y] = true;}
        }
    }
}
