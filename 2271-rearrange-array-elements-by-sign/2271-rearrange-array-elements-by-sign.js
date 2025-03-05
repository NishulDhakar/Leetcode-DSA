/**
 * @param {number[]} nums
 * @return {number[]}
 */
var rearrangeArray = function(nums) {
    let n = nums.length;
    let result = new Array(n); 

    let posIndex = 0, negIndex = 1; 

    for (let num of nums) {
        if (num > 0) {
            result[posIndex] = num; 
            posIndex += 2; 
        } else {
            result[negIndex] = num; 
            negIndex += 2; 
        }
    }

    return result; 
};
