class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

        int c = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                c++;
            }

            max = Math.max(max , c);

            if(nums[i] ==0){
                c = 0;
            }

           

        }
        return max; 
    }
}