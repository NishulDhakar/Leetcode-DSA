class Solution {
    public int[] nextGreaterElements(int[] nums) {
       int nge [] = new int[nums.length];
       int n = nums.length;
        Stack<Integer> st = new Stack<>();
        for(int i = n*2 -1 ; i >= 0 ; i--){
            int num = nums[i % n];
        while(!st.isEmpty() && st.peek() <= num){
            st.pop();
        }

        if(i < n){
            nge[i] = st.isEmpty () ? -1 : st.peek();
        }

        st.push(num);
        }
        return nge;
    }
}