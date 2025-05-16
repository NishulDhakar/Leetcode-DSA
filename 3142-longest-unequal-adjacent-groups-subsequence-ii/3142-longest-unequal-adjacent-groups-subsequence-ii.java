class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] dp = new int[n]; // dp[i] = max length of subsequence ending at i
        int[] parent = new int[n]; // for reconstruction
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);
        
        int maxLen = 1, maxIndex = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // Only consider if groups are different and words same length and hamming distance == 1
                if (groups[i] != groups[j] && words[i].length() == words[j].length() && hammingDistance(words[i], words[j]) == 1) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        parent[i] = j;
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIndex = i;
            }
        }

        // Reconstruct the subsequence
        List<String> result = new ArrayList<>();
        while (maxIndex != -1) {
            result.add(words[maxIndex]);
            maxIndex = parent[maxIndex];
        }

        Collections.reverse(result);
        return result;
    }

    // Helper to compute hamming distance
    private int hammingDistance(String a, String b) {
        int dist = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) dist++;
        }
        return dist;
    }
}
