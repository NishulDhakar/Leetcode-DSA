class Solution {
    public int totalFruit(int[] fruits) {

        int n = fruits.length;
        int j = 0;
        int max  = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n ; i++){

            int right = fruits[i];
            map.put(right , map.getOrDefault(right, 0)+1);
    
             while(map.size() > 2){

            int left = fruits[j];
            map.put(left , map.get(left) - 1);
            if(map.get(left) == 0){
                map.remove(left);
            }
            j++;

        }

         max = Math.max(max , i - j +1);

    }

        return max;
      
    }

}
