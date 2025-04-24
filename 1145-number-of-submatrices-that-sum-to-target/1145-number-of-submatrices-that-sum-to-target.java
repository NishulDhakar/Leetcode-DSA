class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int count = 0;


        for(int r = 0 ; r < rows ; r++){
            for(int c = 1; c < cols; c++){

                matrix[r][c] += matrix[r][c-1];
            }
        }

  

        for(int sc = 0 ; sc< cols ; sc++){
            for(int j = sc ; j< cols ; j++){

                HashMap<Integer , Integer> map = new HashMap<>();
                map.put(0 ,1);

                      int sum = 0;

                for(int row = 0 ; row < rows ; row++){

                    if(sc > 0){
                        sum+= matrix[row][j] - matrix[row][sc -1];

                    }else{
                          sum+= matrix[row][j];
                    }

                    if(map.containsKey(sum - target)){
                        count += map.get(sum - target);
                    }

                     map.put(sum, map.getOrDefault(sum, 0) + 1);

                   
                }


            }
        }


        return count;
        
    }
}