class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Step 1: Create a frequency map for string t
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Sliding window initialization
        int required = tMap.size();  // Number of unique characters in t that need to be matched
        int formed = 0;  // Number of characters currently matching
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int minLeft = 0;

        // Frequency map for characters in the current window
        HashMap<Character, Integer> windowMap = new HashMap<>();

        // Step 3: Expand the window using the right pointer
        while (right < s.length()) {
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            // If the current character's frequency matches the one in t
            if (tMap.containsKey(c) && windowMap.get(c).intValue() == tMap.get(c).intValue()) {
                formed++;
            }

            // Step 4: Try to shrink the window from the left to get the smallest valid window
            while (left <= right && formed == required) {
                char leftChar = s.charAt(left);

                // Update the answer if we have a smaller valid window
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minLeft = left;
                }

                // Shrink the window by moving left pointer
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                if (tMap.containsKey(leftChar) && windowMap.get(leftChar).intValue() < tMap.get(leftChar).intValue()) {
                    formed--;
                }
                left++;
            }

            // Move the right pointer forward
            right++;
        }

        // Return the smallest window or empty string if no valid window found
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);
    }
}
