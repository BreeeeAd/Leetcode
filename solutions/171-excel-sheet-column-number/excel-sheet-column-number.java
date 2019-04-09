// Given a column title as appear in an Excel sheet, return its corresponding column number.
//
// For example:
//
//
//     A -> 1
//     B -> 2
//     C -> 3
//     ...
//     Z -> 26
//     AA -> 27
//     AB -> 28 
//     ...
//
//
// Example 1:
//
//
// Input: "A"
// Output: 1
//
//
// Example 2:
//
//
// Input: "AB"
// Output: 28
//
//
// Example 3:
//
//
// Input: "ZY"
// Output: 701
//


class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        if (s == null) {
            return res;
        }
        char [] array = s.toCharArray();
        int l = array.length - 1;
        for (int i = 0; i < array.length; i++){
            res += (array[i] - 'A' +1) * Math.pow(26, l);
            l--;
        }
        return res;
    }
}
