class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        long res = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            if (num % modulo == k) {
                count++;
            }

            int rem = count % modulo;
            int rem2 = (count - k + modulo) % modulo;
            res += map.getOrDefault(rem2, 0);
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return res;
    }
}
