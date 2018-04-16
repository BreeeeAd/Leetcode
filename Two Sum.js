/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    var result = [];
    for (var i = 0; i < nums.length; i++) {
    	for (var j = 1; i < nums.length; j++) {
    		if (nums[i] + nums [j] = target) {
    			result.push(i);
    			result.push(j);
    		}
    	}
    }
    return
};
