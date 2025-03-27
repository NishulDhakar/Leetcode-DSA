class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        int count = 0;
        int dominant = -1;

        for (int num : nums) {
            if (count == 0) {
                dominant = num;
                count = 1;
            } else if (num == dominant) {
                count++;
            } else {
                count--;
            }
        }

        int totalCount = 0;
        for (int num : nums) {
            if (num == dominant) {
                totalCount++;
            }
        }

        if (totalCount * 2 <= n) return -1;

        int leftCount = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == dominant) {
                leftCount++;
            }

            int leftSize = i + 1;
            int rightSize = n - leftSize;
            int rightCount = totalCount - leftCount;

            if (leftCount * 2 > leftSize && rightCount * 2 > rightSize) {
                return i;
            }
        }

        return -1;
    }
}
