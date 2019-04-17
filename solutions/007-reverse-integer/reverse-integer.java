// Given a 32-bit signed integer, reverse digits of an integer.
//
// Example 1:
//
//
// Input: 123
// Output: 321
//
//
// Example 2:
//
//
// Input: -123
// Output: -321
//
//
// Example 3:
//
//
// Input: 120
// Output: 21
//
//
// Note:
// Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
//


class Solution {
    public int reverse(int x) {
        // if (x < 10 && x > -10){
        //     return x;
        // }
        return rev(x);
    }
    private int rev (int x){
        int res = 0;
        int temp = 0;
        while (x != 0){
            temp = x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE / 10 && temp > 7)) return 0;
            if (res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE / 10 && temp < -8)) return 0;
            res = res * 10 + temp;
            }
        return res;
    }
}
