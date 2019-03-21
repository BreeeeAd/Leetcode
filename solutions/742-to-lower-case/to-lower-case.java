// Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
//
//  
//
//
// Example 1:
//
//
// Input: "Hello"
// Output: "hello"
//
//
//
// Example 2:
//
//
// Input: "here"
// Output: "here"
//
//
//
// Example 3:
//
//
// Input: "LOVELY"
// Output: "lovely"
//
//
//
//
//


class Solution {
    public String toLowerCase(String str) {
        if (str == null) {
            return null;
        }
        char [] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 'A' && array[i] <= 'Z') {
                array[i] = (char) (array[i] -'A' +'a');
            }
        }
        return new String(array);
    }
}
