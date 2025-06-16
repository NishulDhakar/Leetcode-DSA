class Solution {
    public int maximumDifference(int[] nums) {

        int ans = 0;

        for(int i = 0 ; i < nums.length -1; i++){
            for (int j = i ; j < nums.length; j++){
                 if(nums[i] < nums[j]){
                    int temp = nums[j] - nums[i];
                    ans = Math.max(ans , temp);
                 }
            }
        }
       if(ans > 0){
        return ans;
       }else{
        return -1;
       }
    }
}