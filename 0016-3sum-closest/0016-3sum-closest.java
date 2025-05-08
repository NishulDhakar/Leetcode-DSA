class Solution {
    public int threeSumClosest(int[] nums, int target) {

        int closet = nums[0] + nums[1] + nums [2];

           Arrays.sort(nums);

        for(int i = 0 ; i < nums.length -2 ; i++){

            int l = i+1;
            int r = nums.length -1 ;

            while(l < r){

            int closetSum = nums[i] + nums[l] + nums [r];

            if(closetSum == target){
                return closetSum;

            }
            
            if(Math.abs(closetSum - target) < Math.abs(closet - target)){
                closet = closetSum;
            }
            
            if(closetSum > target){
                 r--;
            }else if(closetSum < target){
                l++;
            }
        }

        }

        return closet;
        
    }
}