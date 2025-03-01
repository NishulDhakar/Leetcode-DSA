class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int depth = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                if (depth > 0) { // Ignore outermost '('
                    sb.append(c);
                }
                depth++; // Increase depth
            } else { // c == ')'
                depth--; // Decrease depth

                if (depth > 0) { // Ignore outermost ')'
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }
}
