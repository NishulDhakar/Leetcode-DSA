class Solution {
    public void solveSudoku(char[][] board) {
        solver(board, 0, 0);
    }

    public static boolean solver(char[][] board, int row, int col) {
        if (row == 9) return true; // If we reach past the last row, solution found

        int nextRow = row, nextCol = col + 1;
        if (col == 8) { // Move to the next row if the current column is the last one
            nextRow = row + 1;
            nextCol = 0;
        }

        if (board[row][col] != '.') return solver(board, nextRow, nextCol); // Skip already filled cells

        for (char digit = '1'; digit <= '9'; digit++) {
            if (isSafe(board, row, col, digit)) {
                board[row][col] = digit;

                if (solver(board, nextRow, nextCol)) return true; // If solution found, return true

                board[row][col] = '.'; // Backtrack
            }
        }

        return false; // No valid number found, trigger backtracking
    }

    public static boolean isSafe(char[][] board, int row, int col, int digit) {
        // Check row and column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == digit || board[row][i] == digit) return false;
        }

        // Check 3x3 subgrid
        int sr = (row / 3) * 3, sc = (col / 3) * 3;
        
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == digit) return false;
            }
        }

        return true;
    }
}

