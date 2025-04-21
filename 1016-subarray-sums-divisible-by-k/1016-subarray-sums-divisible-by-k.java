class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        int n = nums.length;

        // int [] p  = new int[n];

        // p[0] = nums[0];

        // for(int i = 1 ; i < n ; i++){
        //     p[i] = p[i -1] + nums[i];
        // }

        // int c = 0;

        // for(int i = 0 ; i < n ; i++){
        //     for(int j = i ; j < n ; j++){

        //         int sum = 0;

        //           if (i > 0) {
        //               sum = p[j] - p[i - 1];
        //           } else {
        //              sum = p[j];
        //           }

        //           if(sum %k == 0){
        //             c++;
        //           }
            
        //     }
        // }
        // return c;

        //----------------------------------\\

    //     int res = 0;

    //    for (int i = 0; i < n; i++) {
    //        int sum = 0;
    //      for (int j = i; j < n; j++) {
    //         sum += nums[j];   

    //          if (sum % k == 0) {
    //         res++;
    //          }
    //      }
    //   }

    //   return res;

    //----------------------------------\\

    int res = 0, sum =0;

     HashMap<Integer , Integer> map = new HashMap<>();

     map.put(0 ,1);

     for(int i = 0 ; i< n ; i++){

        sum += nums[i];
        int rem = sum%k;

         if(rem < 0 ){
            rem += k;
         }

         if(map.containsKey(rem)){
         res += map.get(rem);
        }

         map.put(rem , map.getOrDefault(rem , 0)+1);
         
     }

     return res;

}
}