// Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
//
//  
//
// Example 1:
//
//
// Input: "abab"
// Output: True
// Explanation: It's the substring "ab" twice.
//
//
// Example 2:
//
//
// Input: "aba"
// Output: False
//
//
// Example 3:
//
//
// Input: "abcabcabcabc"
// Output: True
// Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
//
//


class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for(int i = s.length()/2; i>0;i--){
            if (s.length() % i == 0){
                String str = s.substring(0, i);
                //substring(startIndex, len //not endIndex)
                int part = s.length() / i;
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < part; j++){
                    sb.append(str);
                }
                if(sb.toString().equals(s)){
                    return true;
                }
            }
        }
        return false;
    }
}
