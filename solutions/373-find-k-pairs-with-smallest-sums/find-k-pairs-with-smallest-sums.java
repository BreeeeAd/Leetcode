// You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
//
// Define a pair (u,v) which consists of one element from the first array and one element from the second array.
//
// Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
//
// Example 1:
//
//
// Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
// Output: [[1,2],[1,4],[1,6]] 
// Explanation: The first 3 pairs are returned from the sequence: 
//              [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
//
// Example 2:
//
//
// Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
// Output: [1,1],[1,1]
// Explanation: The first 2 pairs are returned from the sequence: 
//              [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
//
// Example 3:
//
//
// Input: nums1 = [1,2], nums2 = [3], k = 3
// Output: [1,3],[2,3]
// Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
//
//


class Solution {
    class Cell{
	int x;
	int y;
	int val;
	public Cell(int x , int y, int val){
		this.x = x;
		this.y = y;
		this.val = val;
    }
}

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>(); 
        if(nums1.length == 0){
            return res;
        } else if (nums2.length == 0){
            return kSmallestPairs(nums2,nums1,k);
        } else {
            dijk(nums1,nums2,k,res);
            return res;
        }

    }
    
    private void dijk(int [] a , int [] b ,int k, List<int []> res) {
        PriorityQueue<Cell> pq = new PriorityQueue<>(k, new Comparator<Cell> () {
            @Override
            public int compare(Cell c1, Cell c2){
                if (c1.val == c2.val) return 0;
                return c1.val < c2.val ? -1 : 1;
            }
        });
        boolean[][] visited = new boolean[a.length][b.length];
        visited[0][0] = true;
        pq.offer(new Cell(0,0,a[0] + b[0]));
        if(k >= a.length * b.length) k = a.length * b.length;
        while(k >= 1){
            k--;
            Cell cur = pq.poll();
            int [] temp = new int [2];
            temp[0] = a[cur.x];
            temp[1] = b[cur.y];
            res.add(temp);
            int i = cur.x;
            int j = cur.y;
            if (i + 1 < a.length && !visited[i+1][j]){
                visited[i+1][j] = true;
                pq.offer(new Cell(i+1, j, a[i+1]+b[j]));
            }
            if (j + 1< b.length && !visited[i][j+1]){
                visited[i][j+1] = true;
                pq.offer(new Cell(i,j+1,a[i] + b[j+1]));
            }
        }
        return ;
        }

}
