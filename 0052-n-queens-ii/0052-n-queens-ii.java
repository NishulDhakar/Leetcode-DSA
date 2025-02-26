class Solution {
    public int totalNQueens(int n) {

        char[][] board = new char[n][n];

        // Initialize board with 'X' (empty spaces)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }

        // Start solving from the first row
        count = 0; //reset count
        solveNQueens(board, 0);
        return count;
    }

    static int count = 0;

    public static void solveNQueens(char[][] board, int row) {
        if (row == board.length) {
            count++;
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';  // Place queen
                solveNQueens(board, row + 1);
                board[row][col] = 'X';  // Backtrack
            }
        }
    }

    public static boolean isSafe(char[][] board, int row, int col) {
        // Check vertical column
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') return false;
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }
}
