//
// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//
//
// For example, given n = 3, a solution set is:
//
//
// [
//   "((()))",
//   "(()())",
//   "(())()",
//   "()(())",
//   "()()()"
// ]
//


class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n ==0){
            return res;
        }
        int left = 0;
        int right = 0;
        StringBuilder sb = new StringBuilder();
        helper(sb, n,0, 0,res);
        return res;
    }
    private void helper(StringBuilder sb, int n, int left,int right, List<String> res){
        if (left + right == n * 2){
            res.add(sb.toString());
            return;
        }
        if (left < n){
            helper(sb.append('('), n, left+1,right,res);
             sb.deleteCharAt(sb.length() -1);
        }
        if (right < left && right < n){
            helper(sb.append(')'), n, left, right+1, res);
             sb.deleteCharAt(sb.length() -1);
        }
    }
}
