class Solution {
    public String getSmallestString(int n, int k) {

        char[] ans = new char[n];

        for(int i = 0; i < n; i++){
            ans[i] = 'a';
            k--;
        }

        int index = n - 1;

        while(k >= 25){
            ans[index] = 'z'; 
            k -= 25;
            index--;
        }

        if(k > 0){

        ans[index] = (char) ('a' + k);
        }
        

        return new String(ans);
    }
}
