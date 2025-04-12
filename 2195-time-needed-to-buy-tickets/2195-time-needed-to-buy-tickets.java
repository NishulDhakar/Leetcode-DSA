class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {

        Queue<Integer> q = new LinkedList<>();

        int count = 0;

        for(int i = 0 ; i< tickets.length ; i++){
            q.add(i);
        }

        while(!q.isEmpty()){

            int cp = q.poll();
            tickets[cp]--;
            count++;

            if(cp == k && tickets[cp] == 0){
                return count;
            }

            if(tickets[cp] >0){
                q.add(cp);
            }

        }

        
        return count;
        
    }
}