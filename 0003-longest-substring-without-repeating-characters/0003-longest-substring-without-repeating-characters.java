class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int right =0;

        int max= 0;

        while(right < s.length()){

            char currCh = s.charAt(right);

            if(!set.contains(currCh)){
                set.add(currCh);
                max = Math.max(max , right - left + 1);
               right++;

            }else{
                  set.remove(s.charAt(left));
                  left++;
            }
            
        }

        return max;
        
    }
}