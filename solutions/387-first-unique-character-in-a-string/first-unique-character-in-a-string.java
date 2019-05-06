//
// Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
//
// Examples:
//
// s = "leetcode"
// return 0.
//
// s = "loveleetcode",
// return 2.
//
//
//
//
// Note: You may assume the string contain only lowercase letters.
//


class Solution {
    public int firstUniqChar(String s) {
        if (s == null) {
            return -1;
        }
        char [] array = s.toCharArray();
        if (array.length == 1) {
            return 0;
        }
        int [] freq = new int [26];
        for(char ch : array){
            freq[ch - 'a']++;
        }
        for (int i = 0; i < array.length; i++) {
            if (freq[array[i] - 'a'] == 1){
                return i;
            }
        }
        return -1 ;
    }
}
