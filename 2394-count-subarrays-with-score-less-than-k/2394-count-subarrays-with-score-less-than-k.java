class Solution {
    public long countSubarrays(int[] nums, long k) {
        long start = 0; // Left pointer of the sliding window
        long currentSum = 0; // Current sum of the subarray
        long result = 0; // To count the valid subarrays

        // Iterate through the array with the `end` pointer
        for (int end = 0; end < nums.length; end++) {
            // Add the current element to the sum
            currentSum += nums[end];

            // While the score condition is violated, shrink the window from the left
            while (currentSum * (end - start + 1) >= k) {
                currentSum -= nums[(int)start];
                start++;
            }

            // Add the number of valid subarrays ending at `end`
            result += (end - start + 1);
        }

        return result;
    }
}
