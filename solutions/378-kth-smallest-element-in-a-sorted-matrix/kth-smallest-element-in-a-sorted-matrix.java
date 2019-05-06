// Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
//
//
// Note that it is the kth smallest element in the sorted order, not the kth distinct element.
//
//
// Example:
//
// matrix = [
//    [ 1,  5,  9],
//    [10, 11, 13],
//    [12, 13, 15]
// ],
// k = 8,
//
// return 13.
//
//
//
// Note: 
// You may assume k is always valid, 1 ≤ k ≤ n2.


class Solution {
    class Cell{
        int x;
        int y;
        int val;
        public Cell(int x, int y, int val){
            this.x = x;
            this.y= y;
            this.val = val;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return -1;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        PriorityQueue <Cell> pq = new PriorityQueue<>(new Comparator<Cell>(){
            @Override
            public int compare(Cell c1, Cell c2){
                if(c1.val == c2.val) return 0;
                return c1.val < c2.val ? -1: 1;
            }
        });
        boolean [][] visited = new boolean [row][col];
        pq.offer(new Cell(0,0,matrix[0][0]));
        while(k>1){
                Cell cur = pq.poll();
                int i = cur.x;
                int j = cur.y;
                if (i + 1 < row && !visited[i+1][j]){
                    pq.offer(new Cell(i+1, j, matrix[i+1][j]));
                    visited[i+1][j] = true;
                }
                if (j + 1< col && !visited[i][j+1]){
                    pq.offer(new Cell(i, j+1, matrix[i][j+1]));
                    visited[i][j+1] = true;
                } 
                k--;
        }
        int res = pq.peek().val;
        return res;
    }
}
