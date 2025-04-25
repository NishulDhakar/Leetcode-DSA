class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {

        Map<Integer, Long> map = new HashMap<>();
        map.put(0, 1l);
        
        long result = 0;
        int count = 0; 

        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) % modulo == k) {
                count++;
            }

            int target = (count - k + modulo) % modulo;

            result += map.getOrDefault(target, 0l);

            int key = count % modulo;
            map.put(key, map.getOrDefault(key, 0l) + 1);
        }

        return result;
    }
}
