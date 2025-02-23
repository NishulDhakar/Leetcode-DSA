class Solution {
    public int majorityElement(int[] nums) {
        int majority = 0 , lead = 0;

        for(int i = 0 ; i < nums.length ; i++){

            if (lead == 0){
                majority = nums[i];
            }
            
            if (majority == nums[i]){

                lead++;

            }else{
                lead--;
            }


    }

     return majority;

}

}