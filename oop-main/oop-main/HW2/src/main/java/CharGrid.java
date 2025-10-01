// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
    private char[][] grid;

    /**
     * Constructs a new CharGrid with the given grid.
     * Does not make a copy.
     * @param grid
     */
    public CharGrid(char[][] grid) {
        this.grid = grid;
    }

    /**
     * Returns the area for the given char in the grid.
     * @param ch char to look for
     * @return area for given char
     */
    public int charArea(char ch) {
        int rows = grid.length;
        int cols = grid[0].length;

        int minRow = rows, maxRow = -1;
        int minCol = cols, maxCol = -1;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == ch) {
                    if (r < minRow) minRow = r;
                    if (r > maxRow) maxRow = r;
                    if (c < minCol) minCol = c;
                    if (c > maxCol) maxCol = c;
                }
            }
        }

        if (maxRow == -1) {
            return 0;
        }

        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
    }

    /**
     * Returns the count of '+' figures in the grid.
     * A plus is defined as equal length arms in all 4 directions.
     * @return number of + in grid
     */
    public int countPlus() {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                char ch = grid[r][c];
                if (ch == ' ') continue;

                int up = 0;
                for (int i = r - 1; i >= 0 && grid[i][c] == ch; i--) up++;

                int down = 0;
                for (int i = r + 1; i < rows && grid[i][c] == ch; i++) down++;

                int left = 0;
                for (int j = c - 1; j >= 0 && grid[r][j] == ch; j--) left++;

                int right = 0;
                for (int j = c + 1; j < cols && grid[r][j] == ch; j++) right++;

                if (up > 0 && up == down && left == right && up == left) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        char[][] sampleGrid = {
                {' ', 'X', ' '},
                {'X', 'X', 'X'},
                {' ', 'X', ' '}
        };

        CharGrid cg = new CharGrid(sampleGrid);

        System.out.println( cg.charArea('X'));
        System.out.println( cg.countPlus());
    }
}
