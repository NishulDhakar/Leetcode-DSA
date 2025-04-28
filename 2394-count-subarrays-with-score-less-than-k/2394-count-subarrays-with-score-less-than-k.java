class Solution {
    public long countSubarrays(int[] nums, long k) {
        long start = 0; 
        long currentSum = 0; 
        long result = 0; 
       
        for (int end = 0; end < nums.length; end++) {
          
            currentSum += nums[end];

        
            while (currentSum * (end - start + 1) >= k) {

                currentSum -= nums[(int)start];
                
                start++;
            }

            result += (end - start + 1);
        }

        return result;
    }
}
