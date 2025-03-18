class Solution {
    public int longestNiceSubarray(int[] nums) {
        
        int left = 0, bitmask = 0, maxLength = 0;
        
        for (int right = 0; right < nums.length; right++) {
            
            while ((bitmask & nums[right]) != 0) {
                bitmask ^= nums[left];  
                left++;
            }
            
            bitmask |= nums[right];

            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
        
    }
}