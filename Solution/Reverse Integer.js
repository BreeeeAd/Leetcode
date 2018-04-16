/**
 * @param {number} x
 * @return {number}
 */
var reverse = function(x){
	var negative = x < 0;
	var result ;
	x = Math.abs(x);
	result = parseInt((x + '').split('').reverse().join(''), 10);

	if (result > Math.pow(2,31) - 1 || result <= -Math.pow(2,31)) {
		return 0;
	}
    if (negative) {
        return 0 - result 
    } else {
        return result
    }
}