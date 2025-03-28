class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {

        int m = grid.length, n = grid[0].length, k = queries.length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int[][] sortedQueries = new int[k][2];
        for (int i = 0; i < k; i++) {
            sortedQueries[i] = new int[]{queries[i], i};
        }
        Arrays.sort(sortedQueries, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{grid[0][0], 0, 0});

        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;

        int[] result = new int[k];
        int count = 0, index = 0;

        while (index < k) {
            int queryValue = sortedQueries[index][0];

            while (!minHeap.isEmpty() && minHeap.peek()[0] < queryValue) {
                int[] cell = minHeap.poll();
                int r = cell[1], c = cell[2];

                count++;

                for (int[] dir : directions) {
                    int nr = r + dir[0], nc = c + dir[1];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        minHeap.offer(new int[]{grid[nr][nc], nr, nc});
                    }
                }
            }

            result[sortedQueries[index][1]] = count;
            index++;
        }

        return result;
    }
}