class Solution {
    public int maxArea(int[] height) {

        int i = 0;
        int j = height.length -1;
        int mostWater = Integer.MIN_VALUE;

        while(i < j){

        int currHeight = Math.min(height[i] ,height[j]);
        int w = j -i;
        int area = w* currHeight;

        mostWater = Math.max(mostWater , area);

        if( height[i] < height[j]){
            i++;
        }else{
            j--;
        }

        }

        return mostWater;
  
    }
}