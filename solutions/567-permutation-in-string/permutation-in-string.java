// Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
//
//  
//
// Example 1:
//
//
// Input: s1 = "ab" s2 = "eidbaooo"
// Output: True
// Explanation: s2 contains one permutation of s1 ("ba").
//
//
// Example 2:
//
//
// Input:s1= "ab" s2 = "eidboaoo"
// Output: False
//
//
//  
//
// Note:
//
//
// 	The input strings only contain lower case letters.
// 	The length of both given strings is in range [1, 10,000].
//
//


class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1==null) return true;
        if (s2 == null) return false;
        int [] dict = new int [26];// use 26 array to repersent how many 'a' - 'z' in s1;
        for (int i = 0; i < s1.length();i++){
            dict[(int)s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i <= s2.length() - s1.length();i++){
            int j = i;
            int [] cur = new int [26];
            while(j < i + s1.length()){
                cur[(int) s2.charAt(j) - 'a']++;
                j++;
            }
            if (matches(cur,dict)){
                return true;
            }
        }
        return false;
    }
    public boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }
}
