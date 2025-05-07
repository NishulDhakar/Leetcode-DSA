class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                ans = Math.min(right - left + 1, ans);
                sum -= nums[left];
                left++;
            }
        }
        if (left == 0 && sum < target) return 0;
        return ans;
    }
}