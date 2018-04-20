/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
    var zeros = 0 ;
    var numsL = nums.length;
    for (var i = 0; i < nums.length; i++) {
    	if (nums[i] == 0) {
    		nums.splice(i,0);
    		zeros ++;
    	}
    }
   nums.push(nums.concat(zeros))  ;
};