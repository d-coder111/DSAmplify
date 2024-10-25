import java.util.*;

class spiralMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the rows");
        int rows = sc.nextInt();
        System.out.println("Enter the columns");
        int col = sc.nextInt();
        int arr[][] = new int[rows][col];
        System.out.println("Enter the elements in the matrix");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // Display the input matrix
        System.out.println("Input Matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        List<Integer> spiralOrderList = spiralOrder(arr);
        System.out.println("Spiral Order:");
        for (int num : spiralOrderList) {
            System.out.print(num + " ");
        }

        sc.close();
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int numrows = matrix.length;
        int numcol = matrix[0].length;
        boolean[][] seen = new boolean[numrows][numcol];
        ArrayList<Integer> List = new ArrayList<Integer>(numrows * numcol);

        // Check if the matrix is empty
        if (matrix.length == 0) {
            return List;
        }

        int[] dr = {0, 1, 0, -1}; // Row direction: right, down, left, up
        int[] dc = {1, 0, -1, 0}; // Column direction: right, down, left, up
        int x = 0, y = 0, di = 0; // x and y are current positions, di is the current direction

        // Loop through the matrix in a spiral order
        for (int i = 0; i < numrows * numcol; i++) {
            List.add(matrix[x][y]); // Add the current element to the list
            seen[x][y] = true;

            int cr = x + dr[di]; // Calculate the next row position
            int cc = y + dc[di]; // Calculate the next column position

            // Check if the next position is within bounds and has not been visited
            if (0 <= cr && cr < numrows && 0 <= cc && cc < numcol && !seen[cr][cc]) {
                x = cr;
                y = cc;
            } else {
                di = (di + 1) % 4; // Change direction (right -> down -> left -> up -> right)
                x += dr[di]; // Update the row position
                y += dc[di]; // Update the column position
            }
        }
        return List;
    }
}
