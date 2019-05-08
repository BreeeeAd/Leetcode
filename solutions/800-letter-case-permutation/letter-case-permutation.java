// Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.
//
//
// Examples:
// Input: S = "a1b2"
// Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
//
// Input: S = "3z4"
// Output: ["3z4", "3Z4"]
//
// Input: S = "12345"
// Output: ["12345"]
//
//
// Note:
//
//
// 	S will be a string with length between 1 and 12.
// 	S will consist only of letters or digits.
//
//


class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        if(S == null || S.length() == 0) return res;
        helper(S.toCharArray(),0,res);
        return res;
    }
    private void helper(char[] s, int index,List<String> res){
        if(index == s.length){
            res.add(new String(s));
            return;
        }
        if (Character.isLetter(s[index])){
            s[index] = Character.toLowerCase(s[index]);
            helper(s,index+1,res);
            
            s[index] = Character.toUpperCase(s[index]);
            helper(s,index+1,res);           
        }else{
            helper(s,index+1,res);
        }
        
        
    }
}
