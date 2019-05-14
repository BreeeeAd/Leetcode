// Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
//
//
// In Pascal's triangle, each number is the sum of the two numbers directly above it.
//
// Example:
//
//
// Input: 5
// Output:
// [
//      [1],
//     [1,1],
//    [1,2,1],
//   [1,3,3,1],
//  [1,4,6,4,1]
// ]
//
//


class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows <=0) return res;
        List<Integer> cur = new ArrayList<>();
        cur.add(1);
        res.add(cur);
        for (int i = 1; i < numRows; i++){
            cur = new ArrayList<>();
            List<Integer> prev = res.get(i-1);
            for (int j = 0; j <= i; j++){
                // add 1 at start and end
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add( prev.get(j -1)+ prev.get(j));
                }
            }
            res.add(cur);
        }
        return res;
    }
}
