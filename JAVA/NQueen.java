import java.util.Scanner;

public class NQueen {
    final int N;

    public NQueen(int N) {
        this.N = N;
    }

    /* This is the function to print the solution for the problem*/
    void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] == 1 ? "Q " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /*It checks if a queen can be placed on board[row][col] */
    boolean isSafe(int board[][], int row, int col) {
        // Check this row on left side
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // It checks upper diagonal on left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        //It checks lower diagonal on left side
        for (int i = row, j = col; j >= 0 && i < N; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    /*It is used to solve the N-Queen problem using backtracking */
    boolean solveNQUtil(int board[][], int col) {
        if (col >= N) {
            printSolution(board);
            return true;
        }

        boolean res = false;
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;

                //It is recursively placing rest of the queens
                res = solveNQUtil(board, col + 1) || res;

                //It is used for backtracking and removing queen
                board[i][col] = 0;
            }
        }

        return res;
    }

    /* This function will solve the N-Queen problem and prints all solutions */
    void solveNQ() {
        int board[][] = new int[N][N];

        if (!solveNQUtil(board, 0)) {
            System.out.println("Solution does not exist");
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of N");
        int N = sc.nextInt(); //Here the input is taken from the user
        NQueen Queen = new NQueen(N);
        Queen.solveNQ();
    }
}
