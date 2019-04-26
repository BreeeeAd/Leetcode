// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
// An input string is valid if:
//
//
// 	Open brackets must be closed by the same type of brackets.
// 	Open brackets must be closed in the correct order.
//
//
// Note that an empty string is also considered valid.
//
// Example 1:
//
//
// Input: "()"
// Output: true
//
//
// Example 2:
//
//
// Input: "()[]{}"
// Output: true
//
//
// Example 3:
//
//
// Input: "(]"
// Output: false
//
//
// Example 4:
//
//
// Input: "([)]"
// Output: false
//
//
// Example 5:
//
//
// Input: "{[]}"
// Output: true
//
//


class Solution {
    public boolean isValid(String s) {
        //if == 3 left add the right into the stack
        //if top of stack != ch means cant make a pair return false
        //if stack is empty and want add a right, return false
        //Time O(n)
        //Space O(n) worst case
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()){
            if(ch == '('){
                stack.offerFirst(')');
            } else if (ch == '{'){
                stack.offerFirst('}');
            } else if (ch == '['){
                stack.offerFirst(']');
            } else if (stack.isEmpty() || stack.pollFirst() != ch){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
