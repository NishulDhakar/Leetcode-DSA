class Solution {
    public int subarraySum(int[] nums, int k) {

        // int[] prefix = new int[nums.length +1];

        // for(int i = 0 ; i < nums.length ; i++){
        //     prefix[i + 1] = prefix[i] + nums[i];
        // }

        // int c = 0;

        // for(int i = 0 ; i < nums.length ; i++){
        //     for(int j = i ; j < nums.length ; j++){
            
        //     if(prefix[j+1] - prefix[i] == k )

        //     c++;
        // }
        // }

        // return c;

        // ---------------------------------------------

        int sum = 0, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            sum += num;
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;

         }
       }

  