class Solution {
    public int fib(int n) {

        if(n == 1 || n == 0 ){
            return n;
        }

         return fib(n -2) + fib(n-1);

    }
}