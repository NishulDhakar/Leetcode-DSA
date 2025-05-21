class Solution {
    public int findDuplicate(int[] nums) {
       
       int n = nums.length;
        Arrays.sort(nums);

        int l = 0;
        int r = 1;

        while(r < n){
            if(nums[l] == nums[r]){
                return nums[l];
            }

            l++;
            r++;
        }
        return -1;
      }
    }