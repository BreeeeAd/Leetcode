/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    if (s.length == t.length) {
    	var srtS = (s+ '').split('').sort().join('');
    	var srtT = (t+ '').split('').sort().join('');
    	return srtS == srtT;
    } else {
    	return false;
    }
};