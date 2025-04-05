class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int maxLength = 0;
        String longest = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, i, j)) {
                    int len = j - i + 1;
                    if (len > maxLength) {
                        maxLength = len;
                        longest = s.substring(i, j + 1);
                    }
                }
            }
        }

        return longest;
    }

    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
