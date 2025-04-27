class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0 , r = numbers.length -1;
    
        int x[] = new int[2];

            while(l < r){

                int sum = numbers[l] + numbers[r];

                if(sum == target){
                    x[0] = l+1;
                    x[1] = r+1;
                }
                
                if(sum < target){
                    l++;
                }else{
                    r--;
                }

            }

            return x;
        
        
    }
}