class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {

        int res = Integer.MAX_VALUE;

         for(int val = 1 ; val <= 6 ; val++){

            int steps = find(tops, bottoms, val);
            if(steps != -1){
                res = Math.min(res , steps);
            }
         }
         if(res == Integer.MAX_VALUE){ 
            return -1;
         }else {
           return res;
            }
    }

    private int find(int[] tops, int[] bottoms ,int val){

        int swapTop =0;
        int swapBottoms =0;

        for(int i = 0 ; i < tops.length ; i++){

            if(tops[i] != val && bottoms[i] != val){
                return -1;
            }else if(tops[i] != val){
                swapTop++;
            }else if(bottoms[i] != val){
                swapBottoms++;
            }
        }

        return Math.min(swapTop , swapBottoms);
    }
}