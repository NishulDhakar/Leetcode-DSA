class Solution {
    public int[] findEvenNumbers(int[] digits) {

        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for(int digit : digits){
            map.put(digit, map.getOrDefault(digit, 0)+1); 
        }

        for(int i = 1; i <= 9 ;i++){
            if(map.getOrDefault(i ,0) ==0) continue;
            map.put(i ,map.get(i) -1);

            for(int j = 0; j <= 9 ; j++){
                if(map.getOrDefault(j ,0) ==0) continue;
                 map.put(j ,map.get(j) -1);

                for(int k = 0 ; k <= 8 ; k+=2){
                    if(map.getOrDefault(k ,0) ==0) continue;
                    map.put(k ,map.get(k) -1);
                    
                    int num = i*100 + j *10 + k;
                    res.add(num);
                     map.put(k ,map.get(k) + 1);
                }
                  map.put(j ,map.get(j) + 1);
            }
              map.put(i ,map.get(i) + 1);
        }
        int arr[] = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            arr[i] = res.get(i);
        }
        return arr;
    }
}