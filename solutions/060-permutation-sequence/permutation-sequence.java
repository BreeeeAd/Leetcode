// The set [1,2,3,...,n] contains a total of n! unique permutations.
//
// By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
//
//
// 	"123"
// 	"132"
// 	"213"
// 	"231"
// 	"312"
// 	"321"
//
//
// Given n and k, return the kth permutation sequence.
//
// Note:
//
//
// 	Given n will be between 1 and 9 inclusive.
// 	Given k will be between 1 and n! inclusive.
//
//
// Example 1:
//
//
// Input: n = 3, k = 3
// Output: "213"
//
//
// Example 2:
//
//
// Input: n = 4, k = 9
// Output: "2314"
//
//


class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> numbers = new ArrayList<>();
        // create a list[1,2,3,4 ......n]
        for (int i = 1; i<= n; i++) {
            numbers.add(i); 
        }
        int[] f = new int [n+1];
        int sum = 1;
        f[0] = sum;
        //create a f[] [1,1,2,6,24.....n!]
        for (int i= 1; i <= n; i++) {
            sum = sum *i;
            f[i]=sum;
        }
        k--;
        for (int i = 1; i <= n; i++) {
            int index = k / f[n-i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k -= index * f[n-i];
        }
        return sb.toString();
    }
}
