class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n - 1;
        int pos = n - 1;

        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {

                result[pos] = nums[left] * nums[left];
                pos--;
                left++;
            } else {
                
                result[pos] = nums[right] * nums[right];
                pos--;
                right--;
            }
        }

        return result;
    }
}
