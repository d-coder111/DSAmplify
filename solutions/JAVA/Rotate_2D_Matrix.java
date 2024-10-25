import java.util.Arrays;

public class Rotate_2D_Matrix {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    // Approach 1
    // First Transpose then reverse each row or vice-versa
    // Generic, can work for nxm also
    public static void rotate(int[][] matrix) {
        for (int r = 0; r < matrix.length - 1; r++) {
            for (int c = r + 1; c < matrix.length; c++) {
                // Swap
                matrix[r][c] = matrix[r][c] ^ matrix[c][r];
                matrix[c][r] = matrix[r][c] ^ matrix[c][r];
                matrix[r][c] = matrix[r][c] ^ matrix[c][r];
            }
        }
        for (int r = 0; r < matrix.length; r++) {
            reverse(matrix[r]);
        }
    }

    public static int[] reverse(int[] arr) {
        int s = 0;
        int e = arr.length - 1;
        while (s < e) {
            arr[s] = arr[s] ^ arr[e];
            arr[e] = arr[s] ^ arr[e];
            arr[s] = arr[s] ^ arr[e];
            s++;
            e--;
        }
        return arr;
    }

    // Optimized approach
    // Rotate in Cycle , Observe the output matrix and work on pattern

    public static void rotateOpt(int[][] matrix) {
        int left = 0;
        int right = matrix.length - 1;
        while (left < right) {
            for (int i = 0; i < right - left; i++) // right - left because when we get sub matrix i.e. removing outer
                                                   // later which is sorted we will have l-r elements always
            {
                int top = left;
                int bottom = right;

                // Storing top left and then moving each one of cycle to next one and at then
                // end topLeft to its correct position
                int topLeft = matrix[top][left + i];
                matrix[top][left + i] = matrix[bottom - i][left];
                matrix[bottom - i][left] = matrix[bottom][right - i];
                matrix[bottom][right - i] = matrix[top + i][right];
                matrix[top + i][right] = topLeft;
            }
            left += 1;
            right -= 1;
        }
    }

    // Approach 3
    // Similar to above with different variables and loop (x)
    // Here we know we have n/2 square or cycles with 0 to n-1-x elements in each
    // cycle do rotate them. (x can be assumed as left and N-1 as right)
    public static void rotateMatrix(int mat[][]) {
        int N = mat.length;
        for (int x = 0; x < N / 2; x++) // Consider all squares one by one
        {
            // Consider elements in group
            // of 4 in current square
            for (int y = x; y < N - x - 1; y++) {
                // temp variable
                int temp = mat[x][y];

                // Move values from right to top
                mat[x][y] = mat[y][N - 1 - x];

                // Move values from bottom to right
                mat[y][N - 1 - x] = mat[N - 1 - x][N - 1 - y];

                // Move values from left to bottom
                mat[N - 1 - x][N - 1 - y] = mat[N - 1 - y][x];

                // Assign temp to left
                mat[N - 1 - y][x] = temp;
            }
        }
    }

}
