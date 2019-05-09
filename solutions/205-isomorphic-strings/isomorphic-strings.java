// Given two strings s and t, determine if they are isomorphic.
//
// Two strings are isomorphic if the characters in s can be replaced to get t.
//
// All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
//
// Example 1:
//
//
// Input: s = "egg", t = "add"
// Output: true
//
//
// Example 2:
//
//
// Input: s = "foo", t = "bar"
// Output: false
//
// Example 3:
//
//
// Input: s = "paper", t = "title"
// Output: true
//
// Note:
// You may assume both s and t have the same length.
//


class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;
        int[] dicts = new int [256];
        int[] dictt = new int [256];
        for(int i = 0; i< s.length();i++){
            char chs = s.charAt(i);
            char cht = t.charAt(i);
            if(dicts[chs] != dictt[cht]) return false;
            dicts[chs] = i + 1;
            dictt[cht] = i + 1;
        }
        return true;
    }
}
