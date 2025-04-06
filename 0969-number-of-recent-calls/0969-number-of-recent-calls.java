class RecentCounter {

    List<Integer> list;

    int i;
    int j;

    public RecentCounter() {
        list = new ArrayList();
        i = 0;
        j = -1;

    }

    public int ping(int t) {
        list.add(t);
         j++;
        while(i < j && list.get(j) - 3000 > list.get(i)){
            i++;
        }

        return j - i + 1;

    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */