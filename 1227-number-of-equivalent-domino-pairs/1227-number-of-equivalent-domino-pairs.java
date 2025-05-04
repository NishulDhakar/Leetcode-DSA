class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        
        HashMap <Integer , Integer > map = new HashMap<>();
        int c =0;
        for(int []d : dominoes){
            int a = Math.min(d[0] , d[1]);
            int b = Math.max(d[0] , d[1]);

            int key = a *10 +b;

          int val =  map.getOrDefault(key ,0);
            c +=val;
            map.put(key , val +1);
        }

        return c;
        
    }
}