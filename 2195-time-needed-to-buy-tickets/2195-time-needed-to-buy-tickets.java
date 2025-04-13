class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> queue = new LinkedList<>();
        int time = 0;
        
        // Initialize queue with indices [0, 1, ..., n-1]
        for (int i = 0; i < tickets.length; i++) {
            queue.add(i);
        }
        
        while (!queue.isEmpty()) {
            int currentPerson = queue.poll();
            time++;  // Increment time for this turn
            
            // Buy 1 ticket
            tickets[currentPerson]--;
            
            // Check termination condition
            if (currentPerson == k && tickets[currentPerson] == 0) {
                return time;
            }
            
            // Re-add to queue if still needs tickets
            if (tickets[currentPerson] > 0) {
                queue.add(currentPerson);
            }
        }
        
        return time;
    }
}