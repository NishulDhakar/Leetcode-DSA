class Solution {
    public boolean isHappy(int n) {

        HashSet<Integer> seen = new HashSet<>();

        while(n != 1){
            if(seen.contains(n)){
                return false;
            }

            seen.add(n);
            n = sqaure(n);
        }
        return true;   
    }

    public int sqaure (int num ){

        int sum = 0;

        while(num > 0) {

        int lastNum = num % 10 ;
        sum += lastNum * lastNum;
        num/=10;
        }

        return sum;
    }
}
