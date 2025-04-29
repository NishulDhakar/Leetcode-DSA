class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int n = nums.length;
        int left = 0;
        int countMax = 0;
        long result = 0;

        for (int right = 0; right < n; right++) {
            if (nums[right] == max) {
                countMax++;
            }

            while (countMax >= k) {
                result += (n - right);
                if (nums[left] == max) {
                    countMax--;
                }
                left++;
            }
        }

        return result; // method now returns long
    }
}



        