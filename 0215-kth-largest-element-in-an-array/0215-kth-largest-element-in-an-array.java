class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public static int quickSelect(int[] nums, int si, int ei, int kth) {
        if (si == ei) return nums[si];

        // Random pivot selection
        int randomIdx = si + (int)(Math.random() * (ei - si + 1));
        swap(nums, randomIdx, ei);

        int pidx = partition(nums, si, ei);

        if (pidx == kth) return nums[pidx];
        else if (kth < pidx) return quickSelect(nums, si, pidx - 1, kth);
        else return quickSelect(nums, pidx + 1, ei, kth);
    }

    public static int partition(int[] nums, int si, int ei) {
        int pivot = nums[ei];
        int i = si - 1;

        for (int j = si; j < ei; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, ++i, ei);
        return i;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
