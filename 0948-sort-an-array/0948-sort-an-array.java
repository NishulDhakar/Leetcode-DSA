class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void mergeSort(int[] nums, int si, int ei) {
        if (si >= ei) return; 

        int mid = si + (ei - si) / 2;
        
        mergeSort(nums, si, mid);
        mergeSort(nums, mid + 1, ei);

        merge(nums, si, mid, ei);
    }

    public static void merge(int[] nums, int si, int mid, int ei) {
        int[] temp = new int[ei - si + 1];
        int i = si, j = mid + 1, k = 0;

        while (i <= mid && j <= ei) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= ei) {
            temp[k++] = nums[j++];
        }

        for (k = 0, i = si; k < temp.length; k++, i++) {
            nums[i] = temp[k];
        }
    }
}
