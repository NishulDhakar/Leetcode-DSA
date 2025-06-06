class Solution {
    public String robotWithString(String s) {

        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int n = s.length();

        char [] temp = new char[n +1];
        Arrays.fill(temp, 'z');

        for(int i = n -1 ; i >= 0; i--){
        temp[i] = (char) Math.min(temp[i + 1] , s.charAt(i));
        }

        for(int i = 0 ; i < n ; i++){
            st.push(s.charAt(i));

            while(!st.isEmpty() && st.peek() <= temp[i + 1]){
                sb.append(st.pop());
            }
        }
        return sb.toString();
    }
}