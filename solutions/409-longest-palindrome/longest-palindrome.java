// Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
//
// This is case sensitive, for example "Aa" is not considered a palindrome here.
//
// Note:
// Assume the length of given string will not exceed 1,010.
//
//
// Example: 
//
// Input:
// "abccccdd"
//
// Output:
// 7
//
// Explanation:
// One longest palindrome that can be built is "dccaccd", whose length is 7.
//
//


class Solution {
    public int longestPalindrome(String s) {
        if(s == null) {
            return 0;
        }
        int count = 0;
        char [] array = s.toCharArray();
        Set<Character> set = new HashSet<> ();
        for (char c : array){
            if (!set.contains(c)){
                set.add(c);
            } else {
                set.remove(c);
                count++;
            }
        }
        return set.isEmpty() ? count * 2: count * 2 + 1;
    }
}
