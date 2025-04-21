class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;
            if (rem < 0) {
                rem += k;
            }

            if (map.containsKey(rem)) { 
                int prev = map.get(rem);
                if (i - prev >= 2) {
                    return true;
                }
            } else {
                map.put(rem, i); 
            }
        }

        return false;
    }
}
