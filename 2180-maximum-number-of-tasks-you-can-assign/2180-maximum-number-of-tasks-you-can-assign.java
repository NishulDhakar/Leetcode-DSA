class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int left = 0;
        int right = Math.min(tasks.length, workers.length);
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canComplete(tasks, workers, pills, strength, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private boolean canComplete(int[] tasks, int[] workers, int pills, int strength, int k) {
        if (k == 0) return true;
        if (k > workers.length) return false;
        
        TreeMap<Integer, Integer> workerMap = new TreeMap<>();
        for (int i = workers.length - k; i < workers.length; i++) {
            workerMap.put(workers[i], workerMap.getOrDefault(workers[i], 0) + 1);
        }
        
        int remainingPills = pills;
        for (int i = k - 1; i >= 0; i--) {
            int task = tasks[i];
            Integer worker = workerMap.ceilingKey(task);
            if (worker != null) {
                if (workerMap.get(worker) == 1) {
                    workerMap.remove(worker);
                } else {
                    workerMap.put(worker, workerMap.get(worker) - 1);
                }
            } else {
                if (remainingPills <= 0) return false;
                worker = workerMap.ceilingKey(task - strength);
                if (worker == null) return false;
                if (workerMap.get(worker) == 1) {
                    workerMap.remove(worker);
                } else {
                    workerMap.put(worker, workerMap.get(worker) - 1);
                }
                remainingPills--;
            }
        }
        return true;
    }
}