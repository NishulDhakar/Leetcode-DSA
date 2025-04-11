class Solution {
    public int balancedStringSplit(String s) {

        int b = 0;
        int c = 0;

        for(int i = 0 ; i < s.length(); i++){
            
            char ch = s.charAt(i);

            if (ch == 'R') b++; else b--;
            
            if (b == 0) c++;
        }

        return c;
        
    }
}