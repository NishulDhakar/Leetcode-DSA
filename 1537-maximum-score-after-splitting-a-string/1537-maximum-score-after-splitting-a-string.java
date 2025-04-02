class Solution {
    public int maxScore(String s) {
        int totalOnes = 0, leftZeros = 0, maxScore = 0;

       for (int i = 0; i < s.length(); i++) {
                 char c = s.charAt(i);
                 if (c == '1') totalOnes++;
        }
        for (int i = 0; i < s.length() - 1; i++) { 
            if (s.charAt(i) == '0') {
                leftZeros++;
            } else {
                totalOnes--; 
            }

            maxScore = Math.max(maxScore, leftZeros + totalOnes);
        }

        return maxScore;
    }
}
