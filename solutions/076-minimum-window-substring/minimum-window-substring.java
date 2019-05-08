// Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
//
// Example:
//
//
// Input: S = "ADOBECODEBANC", T = "ABC"
// Output: "BANC"
//
//
// Note:
//
//
// 	If there is no such window in S that covers all characters in T, return the empty string "".
// 	If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
//
//


class Solution {
    public String minWindow(String s, String t) {
        //Time O(s+t) worst case;
        //Space O(256*2) two char map to store the char in s and t
        if (s == null || t == null) return "";
        int [] dictS = new int[256];
        int [] dictT = new int[256];
        for(char ch : t.toCharArray()){
            dictT[ch]++;
        }
        int l = 0;
        int r = 0;
        int found = 0;
        String res = "";
        int length = Integer.MAX_VALUE;
        while(r < s.length()){
            char b = s.charAt(r);
            if (found < t.length()){
                if (dictT[b] > 0){
                    dictS[b]++;
                    if(dictS[b] <= dictT[b]){
                        found++;
                    }
                }
            }
            r++;
            while(found == t.length() ){
                if(r-l < length){
                    length = r-l;
                    res = s.substring(l,r);
                }
                char a = s.charAt(l);
                if(dictT[a] > 0){
                    dictS[a]--;
                    if(dictS[a] < dictT[a]){
                        found--;
                    }
                }
                l++;
            }
        }
        return res;
    }
}
