class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        int max = 0;
        int crr = 0;
        for(int i =0 ; i < k ; i++){
            if(isVowel(s.charAt(i))) crr++;
        }
        max = crr;
        for(int i = k; i < n; i++){
            if(isVowel(s.charAt(i))) crr++;
            if(isVowel(s.charAt(i-k))) crr--;
            max = Math.max(crr , max);
        }
        return max;
    }
    public boolean isVowel(char s){
        return s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u' ;
    }
}