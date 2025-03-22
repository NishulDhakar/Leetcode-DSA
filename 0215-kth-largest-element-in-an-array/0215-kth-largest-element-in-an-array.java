class Solution {
    public int findKthLargest(int[] nums, int k) {

    return quickSort(nums , 0 , nums.length -1 , nums.length - k);
    
    }

     public static int quickSort(int [] nums , int si , int ei , int kth){

        if(si == ei) return nums[si];

        int pidx = partitions(nums , si , ei);

        if(pidx == kth) return nums[pidx];

else if(kth < pidx){
      return  quickSort(nums , si , pidx - 1 ,kth);

}else{
      return  quickSort(nums , pidx + 1 , ei , kth);

}
     }


     public static int partitions(int [] nums , int si , int ei){

        int pivot = nums[ei];
        int i = si -1;

        for (int j = si ; j < ei ; j++){

            if(nums[j] < pivot){

            i++;

            swap(nums , i , j);

            }

        }

        i++;
        swap(nums , i , ei);
        return i;

     }


     public static void swap(int []nums, int i , int j ){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
     }
     
}