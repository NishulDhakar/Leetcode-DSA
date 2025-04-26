class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {

        long res = 0;
        int count = 0;

        HashMap<Integer , Integer> map = new HashMap<>();
        map.put(0,1);

        for(int i = 0; i< nums.size(); i++){
            if(nums.get(i) % modulo ==k){
                count++;
            }

            int r1 = count % modulo;
            int r2 = (count - k + modulo) % modulo;

            res += map.getOrDefault(r2 , 0);
            map.put(r1 , map.getOrDefault(r1 , 0)+1);
        }

        return res;
        
    }
}