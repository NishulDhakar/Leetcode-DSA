class Solution {
    public long minSum(int[] nums1, int[] nums2) {

        long sum1 = 0;
        long sum2 = 0;

        long zeroInnNum1 = 0, zeroInnNum2 = 0;

        long ans = Integer.MIN_VALUE;

        for(int i = 0; i < nums2.length; i++){
            sum2 += nums2[i];
            if(nums2[i] ==0){
                sum2++;
                zeroInnNum2++;
            }
        }

        for(int i = 0; i < nums1.length; i++){
            sum1 += nums1[i];
            if(nums1[i] ==0){
                sum1++;
                zeroInnNum1++;
            }
        }

        if(sum1 < sum2 && zeroInnNum1 == 0){
            return -1;
        }
        if(sum2 < sum1 && zeroInnNum2 == 0){
            return -1;
        }

         ans = Math.max(sum1 , sum2);

     return ans;
        
    }
}