class Solution {
    public int countLargestGroup(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            int sum = getDigitSum(i);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        int max = 0;
        for (int freq : map.values()) {
            max = Math.max(max, freq);
        }

        int ans = 0;
        for (int freq : map.values()) {
            if (freq == max) {
                ans++;
            }
        }

        return ans;
    }

    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
