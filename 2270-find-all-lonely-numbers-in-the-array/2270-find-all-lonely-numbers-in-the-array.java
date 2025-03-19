class Solution {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> lonelyNumbers = new ArrayList<>();
        Arrays.sort(nums); 

        for (int i = 0; i < nums.length; i++) {
            
            boolean isUnique = (i == 0 || nums[i] != nums[i - 1]) && 
            (i == nums.length - 1 || nums[i] != nums[i + 1]);

            boolean noAdjacent = (i == 0 || nums[i - 1] != nums[i] - 1) && 
            (i == nums.length - 1 || nums[i + 1] != nums[i] + 1);

            if (isUnique && noAdjacent) {
                lonelyNumbers.add(nums[i]); 
            }
        }

        return lonelyNumbers;
    }
}
