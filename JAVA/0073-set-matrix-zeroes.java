public class Main {
    public static void main(String[] args) {
        // Create a sample 2D matrix
        int[][] matrix = {
            {1, 2, 3},
            {4, 0, 6},
            {7, 8, 9}
        };

        // Print the original matrix
        System.out.println("Original Matrix:");
        printMatrix(matrix);

        // Create an instance of the Solution class
        Solution solution = new Solution();

        // Call the setZeroes method to set zeroes in the matrix
        solution.setZeroes(matrix);

        // Print the modified matrix with zeroes set
        System.out.println("Matrix with Zeroes Set:");
        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
