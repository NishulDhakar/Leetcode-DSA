class Solution {
    public int countCompleteSubarrays(int[] nums) {

        int n = nums.length;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int totalDistinct = set.size();

        int count = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

           
            while (freq.size() == totalDistinct) {
                count += (n - right); 
                freq.put(nums[left], freq.get(nums[left]) - 1);
                if (freq.get(nums[left]) == 0) {
                    freq.remove(nums[left]);
                }
                left++;
            }
        }

        return count;
    }
}