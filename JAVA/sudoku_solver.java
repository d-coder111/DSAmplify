public class sudoku_solver {
    public static void solveSudoku(char[][] board) {
        boolean foundSolution = solve(board, 0, 0);
        if (foundSolution) {
            System.out.println("Sudoku Can be solved");
            printSudoku(board);
        } else {
            System.out.println("Sudoku Can Not be solved");
        }
    }

    public static boolean solve(char[][] board, int row, int col) {
        if (col == board[0].length) {
            col = 0;
            row += 1;
        }
        if (row == board.length) {
            return true;
        }
        if (board[row][col] != '.') return solve(board, row, col + 1);
        boolean foundSolution = false;
        for (char num = '1'; num <= '9'; num++) {
            if (checkIfValid(board, row, col, num)) {
                board[row][col] = num;
                foundSolution = solve(board, row, col + 1);
                if (foundSolution) return true;
                else board[row][col] = '.';
            }
        }
        return foundSolution;
    }

    public static boolean checkIfValid(char[][] board, int row, int col, char value) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == value) return false;
            if (board[row][i] == value) return false;
        }
        int boxRow = row / 3;
        int boxCol = col / 3;
        for (int i = boxRow * 3; i < (boxRow + 1) * 3; i++) {
            for (int j = boxCol * 3; j < (boxCol + 1) * 3; j++) {
                if (board[i][j] == value) return false;
            }
        }
        return true;
    }

    public static void printSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] sudokuBoard = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        solveSudoku(sudokuBoard);
    }
}
