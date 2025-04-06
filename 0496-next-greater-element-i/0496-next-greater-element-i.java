class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] nextGreater = new int[nums2.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
 
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }

            nextGreater[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums2[i]);
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            
            int j = 0;
            while (j < nums2.length && nums2[j] != nums1[i]) {
                j++;
            }
            ans[i] = (j < nums2.length) ? nextGreater[j] : -1;
        }
        
        return ans;
    }
}