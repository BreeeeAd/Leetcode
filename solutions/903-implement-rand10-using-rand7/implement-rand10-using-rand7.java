// Given a function rand7 which generates a uniform random integer in the range 1 to 7, write a function rand10 which generates a uniform random integer in the range 1 to 10.
//
// Do NOT use system's Math.random().
//
//
//
//
//  
//
//
// Example 1:
//
//
// Input: 1
// Output: [7]
//
//
//
// Example 2:
//
//
// Input: 2
// Output: [8,4]
//
//
//
// Example 3:
//
//
// Input: 3
// Output: [8,1,10]
//
//
//  
//
// Note:
//
//
// 	rand7 is predefined.
// 	Each testcase has one argument: n, the number of times that rand10 is called.
//
//
//  
//
// Follow up:
//
//
// 	What is the expected value for the number of calls to rand7() function?
// 	Could you minimize the number of calls to rand7()?
//
//
//
//
//


/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    int [][] p = new int [][]{
            {1,2,3,4,5,6,7},
            {8,9,10,1,2,3,4},
            {5,6,7,8,9,10,1},
            {2,3,4,5,6,7,8},
            {9,10,1,2,3,4,5},
            {6,7,8,9,10,0,0},
            {0,0,0,0,0,0,0},
        };
    public int rand10() {

        int res = 0;
        while(res == 0){
            int i = rand7()-1;
            int j = rand7()-1;
            res = p[i][j];
        }
        return res;
    }
}
