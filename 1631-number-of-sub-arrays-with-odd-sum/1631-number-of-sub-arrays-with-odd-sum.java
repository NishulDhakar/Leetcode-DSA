class Solution {
    public int numOfSubarrays(int[] arr) {
        int sum = 0;
        int count = 0;
        int odd = 0;
        int even = 1;
        int MOD = 1000000007;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum % 2 != 0) { // odd sum
                count = (count + even) % MOD;
                odd++;
            } else { // even sum
                count = (count + odd) % MOD;
                even++;
            }
        }

        return count;
    }
}
