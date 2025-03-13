class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
         return Integer.MAX_VALUE;

        int x = (dividend < 0) ^ (divisor < 0) ? -1 : 1;

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int ans = 0;

        while (a >= b) {
            long temp = b, multiple = 1;

            while (a >= (temp << 1)) {
                temp <<= 1;  
                multiple <<= 1;  
            }
            a -= temp;
            ans += multiple;
        }
        return x * ans;
    }
}
