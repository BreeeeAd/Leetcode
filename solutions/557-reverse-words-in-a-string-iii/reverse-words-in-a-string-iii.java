// Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
//
// Example 1:
//
// Input: "Let's take LeetCode contest"
// Output: "s'teL ekat edoCteeL tsetnoc"
//
//
//
// Note:
// In the string, each word is separated by single space and there will not be any extra space in the string.
//


class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() <2) return s;
        char [] ch = s.toCharArray();
        int l = 0;
        int r = 0;
        while (r < ch.length){
            if (Character.isWhitespace(ch[r])){
                reverse(ch,l,r-1);
                r++;
                l=r;
            } else {
                r++;
            }
        }
        if (r == ch.length && l < r){
            reverse(ch, l, r-1);
        }
        return new String(ch);
    }
    private void reverse(char [] ch, int l, int r){
        while(l<r){
            char temp = ch[l];
            ch[l] = ch[r];
            ch[r] = temp;
            l++;
            r--;
        }
    }
}
