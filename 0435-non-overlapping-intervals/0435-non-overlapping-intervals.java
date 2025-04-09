import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) return 0;

        // Sort by end time
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

        int count = 0;
        int lastEnd = intervals[0][1]; // End of the first interval

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < lastEnd) {
                // Overlapping interval — needs to be removed
                count++;
            } else {
                // No overlap — update the end time
                lastEnd = intervals[i][1];
            }
        }

        return count; // Total overlaps removed
    }
}
