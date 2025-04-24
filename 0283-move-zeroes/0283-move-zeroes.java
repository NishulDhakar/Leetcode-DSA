class Solution {
    public void moveZeroes(int[] nums) {

        int []arr = new int[nums.length];
        int left = 0;
        
        for(int i = 0; i < nums.length ; i++){

            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] =temp;

                left++;
            }


        }
        
    }
}