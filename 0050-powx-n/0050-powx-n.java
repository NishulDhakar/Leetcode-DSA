class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;

        long power = n; // Use long to avoid overflow
        if (n < 0) {
            power = -power;
            x = 1 / x;
        }

        double halfPow = myPow(x, (int) (power / 2));
        double pow = halfPow * halfPow;

        if (power % 2 != 0) {
            return x * pow;
        }

        return pow;
    }
}
