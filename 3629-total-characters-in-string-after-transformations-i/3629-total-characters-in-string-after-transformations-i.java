class Solution {
    static int MOD = 1000000007;

    static public int lengthAfterTransformations(String s, int t) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            freq[arr[i] - 'a']++;
        }

        while (t >= 26) {
            int[] temp = new int[26];
            for (int j = 0; j < 25; j++) {
                temp[j + 1] = (freq[j] + temp[j + 1]) % MOD;
                temp[j] = (temp[j] + freq[j]) % MOD;
            }
            temp[25] = (temp[25] + freq[25]) % MOD;
            temp[0] = (temp[0] + freq[25]) % MOD;
            temp[1] = (temp[1] + freq[25]) % MOD;
            freq = temp;
            t -= 26;
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            int diff = 26 - i;
            if (t >= diff) {
                freq[i] = (2 * freq[i]) % MOD;
            }
            ans = (ans + freq[i]) % MOD;
        }

        return ans;
    }
}