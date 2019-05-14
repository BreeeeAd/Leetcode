// We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
//
// (Here, the distance between two points on a plane is the Euclidean distance.)
//
// You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
//
//  
//
//
// Example 1:
//
//
// Input: points = [[1,3],[-2,2]], K = 1
// Output: [[-2,2]]
// Explanation: 
// The distance between (1, 3) and the origin is sqrt(10).
// The distance between (-2, 2) and the origin is sqrt(8).
// Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
// We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
//
//
//
// Example 2:
//
//
// Input: points = [[3,3],[5,-1],[-2,4]], K = 2
// Output: [[3,3],[-2,4]]
// (The answer [[-2,4],[3,3]] would also be accepted.)
//
//
//  
//
// Note:
//
//
// 	1 <= K <= points.length <= 10000
// 	-10000 < points[i][0] < 10000
// 	-10000 < points[i][1] < 10000
//
//
//


class Solution {
    class Cell{
        int x;
        int y;
        double distance;
        
        public Cell(int x, int y, double distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Cell> pq = new PriorityQueue<>(new Comparator<Cell>(){
            @Override
            public int compare(Cell c1, Cell c2){
                if(c1.distance == c2.distance) return 0;
                return c1.distance > c2.distance ? -1 : 1;
            }
        });
        for (int [] p : points){
            if (pq.size() < K){
                pq.offer(new Cell(p[0],p[1],getDistance(p[0],p[1])));
            } else {
                pq.offer(new Cell(p[0],p[1],getDistance(p[0],p[1])));
                pq.poll();
            }
        }
        int[][] res = new int [K][2];
        int i = 0;
        while(!pq.isEmpty()){
            Cell cur = pq.poll();
            res[i][0] = cur.x;
            res[i][1] = cur.y;
            i++;
        }
        return res;
    }
    
    public double getDistance(int i, int j){
        return Math.sqrt(i*i + j*j);
    }
}
