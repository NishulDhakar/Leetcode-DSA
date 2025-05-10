class Solution {
    public boolean checkInclusion(String s1, String s2) {

          int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;

        int[] count1 = new int[26]; // Frequency of characters in s1
        int[] count2 = new int[26]; // Frequency in current window of s2

        // Fill count1 and first window of count2
        for (int i = 0; i < len1; i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        if (matches(count1, count2)) return true;

        // Slide the window over s2
        for (int i = len1; i < len2; i++) {
            count2[s2.charAt(i) - 'a']++; // Add new char
            count2[s2.charAt(i - len1) - 'a']--; // Remove old char
            if (matches(count1, count2)) return true;
        }

        return false;
    }

    // Helper method to compare two frequency arrays
    private boolean matches(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}