class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        List<Integer> ans = new ArrayList<>();
        if (s == null || words.length == 0 || words[0].length() == 0) return ans;

        int wordLen = words[0].length();
        int totalWords = words.length;
        int totalLen = wordLen * totalWords;

        if (s.length() < totalLen) return ans;

        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        // Try wordLen starting points to cover all alignments
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i;
            Map<String, Integer> seen = new HashMap<>();
            int count = 0;

            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordMap.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    count++;

                    while (seen.get(word) > wordMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    if (count == totalWords) {
                        ans.add(left);
                    }

                } else {
                    seen.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return ans;
    }
}