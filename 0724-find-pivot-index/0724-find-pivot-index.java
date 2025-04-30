class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;

        int[] p = new int[n];
        p[0] = nums[0];

        for (int i = 1; i < n; i++) {
            p[i] = p[i - 1] + nums[i];
        }

        int total = p[n - 1];

        if (total - nums[0] == 0) return 0; 

        for (int i = 1; i < n; i++) {
            int left = p[i - 1];
            int right = total - p[i];

            if (left == right) return i;
        }

        return -1;
    }
}
