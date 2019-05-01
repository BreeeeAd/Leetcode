// Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
//
// Example 1:
//
//
// Input: 121
// Output: true
//
//
// Example 2:
//
//
// Input: -121
// Output: false
// Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
//
//
// Example 3:
//
//
// Input: 10
// Output: false
// Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
//
//
// Follow up:
//
// Coud you solve it without converting the integer to a string?
//


class Solution {
    public boolean isPalindrome(int x) {
        // Solution 1 use extra space ArrayList or StringBuilder
        // Time O(n + n/2)
        // Space O(n)
        // if (x < 0) return false;
        // StringBuilder sb = new StringBuilder();
        // while (x > 0) {
        //     int temp = x % 10;
        //     sb.append(temp);
        //     x /= 10;
        // }
        // String X = sb.toString();
        // int i = 0;
        // int j = X.length() - 1;
        // while (i < j) {
        //     if (X.charAt(i) != X.charAt(j)) return false;
        //     i++;
        //     j--;
        // }
        // return true;
        
        //Solution 2 creat a revers number
        
        if (x < 0) return false;
        int origin = x;
        int res = 0;
        while( x > 0) {
            int temp = x % 10;
            res = res * 10 + temp;
            x /= 10;
        }
        return res == origin;
    }
}
