class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        List<Integer> list = new ArrayList<>();
        for (int f : freq) {
            if (f > 0) list.add(f);
        }
        Collections.sort(list); 
        int ans = Integer.MAX_VALUE;
        int n = list.size();

        for (int i = 0; i < n; i++) {
            int baseFreq = list.get(i);  
            int deletions = 0;

            for (int f : list) {
                if (f < baseFreq) {
                    deletions += f;      
                } else if (f > baseFreq + k) {
                    deletions += f - (baseFreq + k);  
                }
            }

            ans = Math.min(ans, deletions);
        }

        return ans;
    }
}
