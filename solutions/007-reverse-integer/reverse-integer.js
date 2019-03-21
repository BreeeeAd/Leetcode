// Given a 32-bit signed integer, reverse digits of an integer.
//
// Example 1:
//
//
// Input: 123
// Output: 321
//
//
// Example 2:
//
//
// Input: -123
// Output: -321
//
//
// Example 3:
//
//
// Input: 120
// Output: 21
//
//
// Note:
// Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
//


/**
 * @param {number} x
 * @return {number}
 */
	var reverse = function(x) {
    var isNeg = x < 0;
    var result = 0;
    
    x = Math.abs(x);
    
    while(x) {
        var lastDigit = x%10;
        result *= 10;
        result += lastDigit;
        x = parseInt(x/10);
    }

    result = isNeg ? -result : result;
    
    if(result > Math.pow(2,31) - 1 || result < -Math.pow(2,31)) {
        return 0;
    }
    
    return result;
};
