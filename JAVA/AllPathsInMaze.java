public class AllPathsInMaze {
    public static void main(String[] args) {
        // Define the maze with a matrix of boolean values.
        // To add obstacles , mark the required elements as false.
        boolean[][] maze = {
            {true, true, true},
            {true, true, true},
            {true, true, true}
        };

        // Start finding and printing all paths from the top-left corner to the bottom-right corner of the maze.
        findAllPaths("", maze, 0, 0);
    }

    // Recursive function to find and print all paths in the maze.
    static void findAllPaths(String pathSoFar, boolean[][] maze, int row, int col) {
        // Check if we have reached the bottom-right corner of the maze.
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(pathSoFar);
            return;
        }
        
        // Check if the current cell is blocked.
        if (!maze[row][col]) {
            return;
        }
        
        // Mark the current cell as visited to avoid revisiting it in the same path.
        maze[row][col] = false;

        // Explore all possible directions: down, right, up, and left.
        if (row < maze.length - 1) {
            findAllPaths(pathSoFar + 'D', maze, row + 1, col);
        }
        if (col < maze[0].length - 1) {
            findAllPaths(pathSoFar + 'R', maze, row, col + 1);
        }
        if (row > 0) {
            findAllPaths(pathSoFar + 'U', maze, row - 1, col);
        }
        if (col > 0) {
            findAllPaths(pathSoFar + 'L', maze, row, col - 1);
        }

        // Revert the current cell to unvisited when backtracking.
        maze[row][col] = true;
    }
}
