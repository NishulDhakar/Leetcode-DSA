class Solution {
    public int pivotIndex(int[] nums) {

        int prefix[] = new int[nums.length + 1];

        for(int i = 0 ; i < nums.length ; i++){
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int total = prefix[nums.length];

        for( int i = 0 ; i < nums.length ; i++){
                int left = prefix[i];
                int right = total - prefix[i+1];

                if(left == right){
                    return i;
                }
            }

        return -1; 

    }
    
}