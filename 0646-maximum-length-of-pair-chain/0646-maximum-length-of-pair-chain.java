class Solution {
    public int findLongestChain(int[][] pairs) {


        Arrays.sort(pairs , (a ,b) -> a[1] - b[1]);

        int ans = 1;

        int lastEl = pairs[0][1];

        for(int i = 1 ; i < pairs.length ; i++){

            if(lastEl < pairs[i][0]){
                ans++;
                lastEl = pairs[i][1];
            }
        
    }

    return ans;
    }
}
