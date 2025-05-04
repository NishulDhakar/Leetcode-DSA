class Solution {
    public int sumOddLengthSubarrays(int[] arr) {

        int n = arr.length;

        int total = 0;

        for(int i = 0; i <n ; i++){

            int left = i + 1;

            int right = n - i;

            int totalSubArray = left * right;

            int oddCount = (totalSubArray +1) / 2;

            total += arr[i] * oddCount; 
        }
        return total;
    }
}