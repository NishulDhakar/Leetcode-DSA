class Solution {
    public String minWindow(String s, String t) {
 
        if (s.length() < t.length()) return "";

        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;
        int matched = 0;

        Map<Character, Integer> windowMap = new HashMap<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            if (targetMap.containsKey(c) &&
                windowMap.get(c).intValue() <= targetMap.get(c).intValue()) {
                matched++;
            }

            while (matched == t.length()) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minStart = left;
                }

                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                if (targetMap.containsKey(leftChar) &&
                    windowMap.get(leftChar) < targetMap.get(leftChar)) {
                    matched--;
                }

                left++;
            }

            right++;
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(minStart, minStart + minLength);
        }
    }
}
