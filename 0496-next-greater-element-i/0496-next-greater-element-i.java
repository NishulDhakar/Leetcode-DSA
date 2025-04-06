class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int res [] = new int[nums1.length];
        boolean f = false;

        for(int i = 0 ; i < nums1.length; i++){

            f = false;

            for(int j = 0 ; j < nums2.length; j++){

                if(nums1[i] == nums2[j]){
                    f = true;
                }

                if(f && nums2[j] > nums1[i]){
                    res[i] = nums2[j];
                    break;
                }
            }
        }

        for(int i = 0 ; i < res.length; i++){
            if(res[i] == 0){
                res[i] = -1;
            }
        }
        return res;
    }
}