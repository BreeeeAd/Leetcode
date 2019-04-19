// Given a balanced parentheses string S, compute the score of the string based on the following rule:
//
//
// 	() has score 1
// 	AB has score A + B, where A and B are balanced parentheses strings.
// 	(A) has score 2 * A, where A is a balanced parentheses string.
//
//
//  
//
//
// Example 1:
//
//
// Input: "()"
// Output: 1
//
//
//
// Example 2:
//
//
// Input: "(())"
// Output: 2
//
//
//
// Example 3:
//
//
// Input: "()()"
// Output: 2
//
//
//
// Example 4:
//
//
// Input: "(()(()))"
// Output: 6
//
//
//  
//
// Note:
//
//
// 	S is a balanced parentheses string, containing only ( and ).
// 	2 <= S.length <= 50
//
//
//
//
//
//


class Solution {
    public int scoreOfParentheses(String S) {
        if(S == null) {
            return -1;
        }
        char [] array = S.toCharArray();
        int cur = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (char c : array){
            if (c == '('){
                stack.push(cur);
                cur = 0;
            } else if (c == ')'){
                cur =stack.pop() + Math.max(2 * cur , 1);
                
            }
        }
        return cur;
    }
}
