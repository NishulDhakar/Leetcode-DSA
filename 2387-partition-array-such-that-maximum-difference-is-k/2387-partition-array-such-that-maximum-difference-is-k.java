class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = 0, count = 0;
        int n = nums.length;
        while (j < n) {
            if (nums[j] - nums[i] > k) {
                count++;
                i = j;
            }
            j++;
        }
        return count + 1;
    }
}