class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //your code goes here
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int lastFreetime = intervals[0][1], count = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (lastFreetime <= intervals[i][0]) {
                count++;
                lastFreetime = intervals[i][1];
            }
        }
        return intervals.length - count;
    }
}
