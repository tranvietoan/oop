
public class TetrisGrid {
    private boolean[][] grid;  // grid[col][row]

    /**
     * Constructs a new instance with the given grid.
     * Does not make a copy.
     * @param grid
     */
    public TetrisGrid(boolean[][] grid) {
        this.grid = grid;
    }

    /**
     * Does row-clearing on the grid (see handout).
     * Clear any row that is completely full,
     * and slide down the above rows. New empty rows appear on top.
     */
    public void clearRows() {
        int height = grid[0].length;
        int width = grid.length;

        int nextRow = 0;

        for (int row = 0; row < height; row++) {
            if (!isFullRow(row)) {
                for (int col = 0; col < width; col++) {
                    grid[col][nextRow] = grid[col][row];
                }
                nextRow++;
            }
        }

        for (int row = nextRow; row < height; row++) {
            for (int col = 0; col < width; col++) {
                grid[col][row] = false;
            }
        }
    }

    private boolean isFullRow(int row) {
        for (int col= 0; col < grid.length; col++) {
            if (!grid[col][row]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the internal 2d grid array.
     * @return 2d grid array
     */
    boolean[][] getGrid() {
        return grid;
    }

}
