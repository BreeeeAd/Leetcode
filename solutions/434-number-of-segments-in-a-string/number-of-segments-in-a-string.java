// Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
//
// Please note that the string does not contain any non-printable characters.
//
// Example:
//
// Input: "Hello, my name is John"
// Output: 5
//
//


class Solution {
    public int countSegments(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        char [] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            // basecase  first char is ' '
            // case 1 ith char is not ' ' i-1th char is ' '
            // case 2 ith char is ' ' i != 1, i-1 th char is ' ' count++ 
            if ((i == 0 || str[i - 1] == ' ' )&& str[i] != ' '){
                count++;
            }
        }
        return count;
    }
}
