class Solution {
    public List<Integer> majorityElement(int[] nums) {

        List<Integer> res = new ArrayList<>();

        HashMap<Integer , Integer> map = new HashMap<>();

        for(int key : nums){
           map.put(key , map.getOrDefault(key , 0) +1);
        }

        for(Integer key :  map.keySet()){
            if(map.get(key) > nums.length/3){

                  res.add(key);

            }
        }

        return res;
        
    }
}