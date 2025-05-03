class Solution {
    public String pushDominoes(String dominoes) {

        int n = dominoes.length();

       int[] leftClosestR = new int[n];
       int[] rightClosestL = new int[n];

        //left to right find leftClosestR

        for(int i = 0; i< n ;i++){
            if(dominoes.charAt(i) == 'R'){
                leftClosestR[i] = i;
            }else if(dominoes.charAt(i) == '.'){
                leftClosestR[i] = i > 0 ? leftClosestR[i -1] :  -1;
            }else{
                 leftClosestR[i] = -1  ;
            }
        }

        //right to left find rightClosestL

        for(int i = n-1; i >= 0;i--){
            if(dominoes.charAt(i) == 'L'){
                rightClosestL[i] = i;
            }else if(dominoes.charAt(i) == '.'){
                rightClosestL[i] = i < n-1  ? rightClosestL[i +  1] :  -1;
            }else{
                 rightClosestL[i] = -1;
            }
        }

        char[] res = new char[n];

        for(int i = 0; i< n ;i++){

            if (dominoes.charAt(i) != '.') {
                res[i] = dominoes.charAt(i);
                continue;
            }

             int distLeftR = (leftClosestR[i] == -1) ? 
             Integer.MAX_VALUE : Math.abs(i - leftClosestR[i]);

             int distRightL = (rightClosestL[i] == -1) ?
             Integer.MAX_VALUE : Math.abs(i - rightClosestL[i]);

            if(distRightL == distLeftR || leftClosestR[i] == rightClosestL[i]){

                res[i] = '.';

            }else if(leftClosestR[i] == -1){
                res[i] = 'L';
            }else if(rightClosestL[i] == -1){
                res[i] = 'R';
            }else{

                res[i] = distRightL < distLeftR ? 'L' : 'R';

            }
           
        }

         return new String(res);
    }
}