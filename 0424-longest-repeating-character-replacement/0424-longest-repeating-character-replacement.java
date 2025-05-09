class Solution {
    public int characterReplacement(String s, int k) {

        int l = 0 , mr =0, nr= 0, m =Integer.MIN_VALUE;

        HashMap<Character , Integer> map = new HashMap<>();        

        for(int i = 0; i < s.length() ;i++){

            char crrCh = s.charAt(i);

            map.put(crrCh , map.getOrDefault(crrCh , 0)+1);


            mr = Math.max(mr , map.get(crrCh));

            nr = (i -l +1) - mr;

            if(nr > k){

                map.put(s.charAt(l) , map.get(s.charAt(l)) -1);
                l++;
            }

          m = Math.max(m , i -l +1);
        }

        return m;
    }
}