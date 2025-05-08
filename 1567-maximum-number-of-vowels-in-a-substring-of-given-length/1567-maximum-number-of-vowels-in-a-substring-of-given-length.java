class Solution {
    public int maxVowels(String s, int k) {

        int n = s.length();

        int ans = 0;
        int max = 0;

        int j = 0;
        int i = 0;

        while(j < n){
            if(isVowel(s.charAt(j))) ans++;

            while(j - i + 1 == k){
                max = Math.max(max , ans);
                 if(isVowel(s.charAt(i))) ans--;
                 i++;
            }

            j++;
        }
        return max;
    }

    public boolean isVowel(char ch){
        return ch == 'a' || ch ==  'e'|| ch == 'i' || ch == 'o' || ch == 'u' ;
    }
}