// Write a function to find the longest common prefix string amongst an array of strings.
//
// If there is no common prefix, return an empty string "".
//
// Example 1:
//
//
// Input: ["flower","flow","flight"]
// Output: "fl"
//
//
// Example 2:
//
//
// Input: ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.
//
//
// Note:
//
// All given inputs are in lowercase letters a-z.
//


class Solution {
    public String longestCommonPrefix(String[] strs) {
        //Time O(n);
        //Space O(prefix.length ~= 1)
        if(strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for(int i = 0; i < strs.length;i++){
            // form the first one, compare each two of string in String[];
            // return the prefix with s1 and s2, then use it to compare s3
            while(strs[i].indexOf(prefix) != 0){
                // check the prefix is indexOf str == 0
                // if not , delete the last char in prefix and try again until prefix == ""
                prefix = prefix.substring(0, prefix.length() -1);
                if(prefix == "") return "";
            }
        }
        return prefix;
    }
}
