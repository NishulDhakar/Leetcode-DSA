class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        double maxAvg;
        int sum = 0;

        for(int i = 0; i < k; i++){
            sum += nums[i];
        }

        maxAvg = sum;

        for(int i = k ; i < nums.length; i++){
            sum = sum - nums[i-k] + nums[i];

            maxAvg = Math.max(maxAvg , sum);
        }

        return maxAvg /k;
    }
}