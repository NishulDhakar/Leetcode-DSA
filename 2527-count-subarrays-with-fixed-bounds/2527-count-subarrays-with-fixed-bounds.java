class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {

         long res = 0;
        int leftBound = -1;
        int lastMin = -1, lastMax = -1;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                leftBound = i;
                lastMin = -1;
                lastMax = -1;
            } else {
                if (nums[i] == minK) {
                    lastMin = i;
                }
                if (nums[i] == maxK) {
                    lastMax = i;
                }
                if (lastMin != -1 && lastMax != -1) {
                    res += Math.min(lastMin, lastMax) - leftBound;
                }
            }
        }
        return res;
    }
}
    