class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1 || s.length()<numRows) return s;
        StringBuilder[] rows = new StringBuilder[numRows];

        for(int i=0;i<numRows;i++) rows[i] = new StringBuilder();

        int currentRow = 0;
        boolean isGoingDown=false;

        for(char ch: s.toCharArray()){
            rows[currentRow].append(ch);
            if(currentRow==0 || currentRow==numRows-1) isGoingDown=!isGoingDown;
            currentRow+=isGoingDown?1:-1;
        }
        StringBuilder result = new StringBuilder();
        for(StringBuilder row: rows) result.append(row);
        return result.toString();
    }
}