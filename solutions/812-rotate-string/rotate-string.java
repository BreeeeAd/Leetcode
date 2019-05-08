// We are given two strings, A and B.
//
// A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.
//
//
// Example 1:
// Input: A = 'abcde', B = 'cdeab'
// Output: true
//
// Example 2:
// Input: A = 'abcde', B = 'abced'
// Output: false
//
//
// Note:
//
//
// 	A and B will have length at most 100.
//
//


class Solution {
    public boolean rotateString(String A, String B) {
        if (A == null && B == null) return true;
        if (A == null || B == null) return false;
        if (A.length() != B.length()) return false;
        if(A.length() == 0) return true;
        for(int i = 0; i < A.length() - 1; i++){
            if(helper(A, i).equals(B)) return true;
        }
        return false;
    }
    private String helper(String s, int i){
        char[] ch = s.toCharArray();
        reverse(ch, 0, s.length()-1);
        reverse(ch, 0, i);
        reverse(ch, i+1, s.length() -1);
        return new String(ch);
    }
    private void swap(char [] ch, int i, int j){
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
    private void reverse(char [] ch, int i, int j){
        while(i<j){
            swap(ch, i++,j--);
        }
    }
}
