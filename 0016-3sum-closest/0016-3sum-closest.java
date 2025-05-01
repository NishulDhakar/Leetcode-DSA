class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int  n = nums.length;

        int currSum =nums[0] + nums[1] + nums[2];

        for(int i = 0 ; i < n -2; i++){

            int l = i+1, r = n-1;

            while(l <r){
                int sum = nums[i] + nums[l] + nums[r];

                if(Math.abs(currSum - target) > Math.abs(sum -target)){
                        currSum = sum ;
                }
                if (sum < target){
                    l++;
                }else if(sum > target){
                    r--;
                } else{
                    return sum;
                }
            }
            
        }

        return currSum;
        
    }
}