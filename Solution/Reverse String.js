/**
 * @param {string} s
 * @return {string}
 */
var reverseString = function(s) {
    var result;
    result = (s+'').split('').reverse().join('');
    return result;
};