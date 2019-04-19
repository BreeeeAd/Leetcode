// Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
//
// Example:
//
//
// Input: 
//
// 1 0 1 0 0
// 1 0 1 1 1
// 1 1 1 1 1
// 1 0 0 1 0
//
// Output: 4
//


class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null) {
            return -1;
        }
        int n = matrix.length;
        if (n == 0){
            return 0;
        }
        int m = matrix[0].length;
        int [][] dp = new int [n][m];
        int res = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (i == 0|| j == 0){
                    dp[i][j] = matrix[i][j] == '1'? 1:0;
                } else if (matrix[i][j] == '1'){
                    dp[i][j] = Math.min(dp[i -1][j] + 1, dp[i][j-1] + 1);
                    dp[i][j] = Math.min(dp[i-1][j-1] + 1, dp [i][j]);
                }
                res = Math.max(res, dp[i][j]); 
            }
        }
        return res * res;
    }
}
