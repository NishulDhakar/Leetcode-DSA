class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        // Frequency map for characters in t
        HashMap<Character, Integer> requiredFreq = new HashMap<>();
        for (char ch : t.toCharArray()) {
            requiredFreq.put(ch, requiredFreq.getOrDefault(ch, 0) + 1);
        }

        int required = requiredFreq.size(); // Number of unique characters needed
        int formed = 0;

        HashMap<Character, Integer> windowFreq = new HashMap<>();

        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;

        while (right < s.length()) {
            // Expand window by including current character
            char ch = s.charAt(right);
            windowFreq.put(ch, windowFreq.getOrDefault(ch, 0) + 1);

            // If frequency matches with requiredFreq, increment formed
            if (requiredFreq.containsKey(ch) &&
                windowFreq.get(ch).intValue() == requiredFreq.get(ch).intValue()) {
                formed++;
            }

            // Try to shrink the window from the left while it's valid
            while (left <= right && formed == required) {
                // Update the minimum window
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    startIndex = left;
                }

                // Shrink from the left
                char leftChar = s.charAt(left);
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);

                if (requiredFreq.containsKey(leftChar) &&
                    windowFreq.get(leftChar).intValue() < requiredFreq.get(leftChar).intValue()) {
                    formed--;
                }

                left++;
            }

            // Expand to the right
            right++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLength);
    }
}
