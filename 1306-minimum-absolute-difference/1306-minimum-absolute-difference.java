class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;

        for(int i = 1 ; i < arr.length ; i++){

            int diff = arr[i] - arr[i -1];
            minDiff = Math.min(diff , minDiff);
        }

        for(int i = 1 ; i < arr.length ; i++){
            int diff = arr[i] - arr[i -1];

             if(diff == minDiff){

             List<Integer> list = new ArrayList<>();
                
                list.add(arr[i -1]);
                list.add(arr[i]);

                res.add(list);
             }

        }

         return res;

            }


        }

