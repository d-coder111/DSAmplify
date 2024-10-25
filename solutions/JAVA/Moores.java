public class Moores {
    public static int getNeighborState(int[][] grid, int x, int y) {
        int[][] neighbors = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1}, {1, 0}, {1, 1}
        };

        int liveNeighbors = 0;
        for (int[] neighbor : neighbors) {
            int newX = x + neighbor[0];
            int newY = y + neighbor[1];

            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length) {
                liveNeighbors += grid[newX][newY];
            }
        }

        if (grid[x][y] == 1) {
            if (liveNeighbors < 2 || liveNeighbors > 3) {
                return 0; // Cell dies (underpopulation or overpopulation)
            } else {
                return 1; // Cell survives
            }
        } else {
            if (liveNeighbors == 3) {
                return 1; // Cell is born (reproduction)
            } else {
                return 0; // Cell remains dead
            }
        }
    }

    public static int[][] updateGrid(int[][] grid) {
        int numRows = grid.length;
        int numCols = grid[0].length;
        int[][] newGrid = new int[numRows][numCols];

        for (int x = 0; x < numRows; x++) {
            for (int y = 0; y < numCols; y++) {
                newGrid[x][y] = getNeighborState(grid, x, y);
            }
        }

        return newGrid;
    }

    public static void displayGrid(int[][] grid) {
        for (int[] row : grid) {
            for (int cell : row) {
                System.out.print(cell == 1 ? "X" : " ");
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] initialGrid = {
            {0, 1, 0},
            {0, 0, 1},
            {1, 1, 1}
        };

        for (int i = 0; i < 5; i++) {
            displayGrid(initialGrid);
            initialGrid = updateGrid(initialGrid);
        }
    }
}
