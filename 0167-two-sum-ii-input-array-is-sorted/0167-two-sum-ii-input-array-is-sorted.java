class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int n = numbers.length;
        int l = 0;
        int r = n-1;

        int arr[] = new int[2];

        while(l < r){

            int crrSum = numbers[l] + numbers[r];

            if(crrSum == target){

               return new int[]{l + 1, r + 1};
                
            }else if(crrSum< target) {
                l++;

            }else{
                if(crrSum > target) r--;
            }

        }

        return new int[2];
        
    }
}