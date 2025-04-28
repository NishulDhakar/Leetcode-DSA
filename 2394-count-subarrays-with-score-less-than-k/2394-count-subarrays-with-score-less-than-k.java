class Solution {
    public long countSubarrays(int[] nums, long k) {
        long strt = 0; 
        long currSum = 0; 
        long res = 0; 
       
        for (int end = 0; end < nums.length; end++) {
          
            currSum += nums[end];

        
            while (currSum * (end - strt + 1) >= k) {

                currSum -= nums[(int)strt];

                strt++;
            }

            res += (end - strt + 1);
        }

        return res;
    }
}
