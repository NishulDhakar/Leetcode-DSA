class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        int count = 0;

        for(int r = 0 ; r < rows ; r++){
            for(int c = 1 ; c < cols ; c++){

                matrix[r][c] += matrix[r][c-1];

               }
        }

        //apply leetcode 560 concept now

        int result = 0;

        for(int startCol = 0 ; startCol < cols ; startCol++){
            for(int j = startCol ; j < cols ; j++){

                HashMap <Integer , Integer> map = new HashMap<>();

                map.put(0 ,1);

                int sum = 0;

                for(int row = 0 ; row < rows ; row++){

                    if(startCol > 0){

                        sum += matrix[row][j] - matrix[row][startCol -1];

                    }else{
                        sum += matrix[row][j];
                    }

                    if(map.containsKey(sum - target)){
                        result += map.get(sum - target);
                    }

                    map.put(sum , map.getOrDefault(sum , 0) + 1);

                }
 
            }
        }

        return result;
        
    }
}