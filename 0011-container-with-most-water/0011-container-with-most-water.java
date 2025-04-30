class Solution {
    public int maxArea(int[] height) {

        int n = height.length;

        int i = 0; 
        int j = n -1;

       int  maxArea = Integer.MIN_VALUE;

       int  area  = 0;


        while(i < j){

            int  w = j - i;

            int h = Math.min(height[j] , height[i]);

            area = w * h;

           maxArea = Math.max(area , maxArea);

           if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxArea;
        
    }
}