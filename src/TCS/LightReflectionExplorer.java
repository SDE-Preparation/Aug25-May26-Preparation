
import java.util.*;


public class LightReflectionExplorer {

    // Movement directions: up, right, down, left
    private static final int[] verticalMoves = {-1, 0, 1, 0};
    private static final int[] horizontalMoves = {0, 1, 0, -1};

    // Mirror reflection mapping for each direction
    private static final int[][] directionChanges = {
            {1, 3},   // Facing North: / sends East, \ sends West
            {0, 2},   // Facing East: / sends North, \ sends South
            {3, 1},   // Facing South: / sends West, \ sends East
            {2, 0}    // Facing West: / sends South, \ sends North
    };

    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);

        // Read grid dimensions
        String[] sizeInfo = inputReader.nextLine().split(" ");
        int rowCount = Integer.parseInt(sizeInfo[0]);
        int colCount = Integer.parseInt(sizeInfo[1]);

        // Read the mirror grid
        char[][] mirrorGrid = new char[rowCount][colCount];
        for (int r = 0; r < rowCount; r++) {
            String[] rowData = inputReader.nextLine().split(" ");
            for (int c = 0; c < colCount; c++) {
                mirrorGrid[r][c] = rowData[c].charAt(0);
            }
        }

        int maxLoopCells = 0;

        // Try starting from every mirror cell in all directions
        for (int startR = 0; startR < rowCount; startR++) {
            for (int startC = 0; startC < colCount; startC++) {
                if (mirrorGrid[startR][startC] != '0') {
                    // Test all 4 possible starting directions
                    for (int startDir = 0; startDir < 4; startDir++) {
                        int loopSize = traceLightBeam(mirrorGrid, startR, startC, startDir);
                        if (loopSize > maxLoopCells) {
                            maxLoopCells = loopSize;
                        }
                    }
                }
            }
        }

        System.out.println(maxLoopCells);
    }

    // Follow light beam until it exits or completes a loop
    private static int traceLightBeam(char[][] grid, int startR, int startC, int startDir) {
        int rows = grid.length;
        int cols = grid[0].length;

        int currentR = startR;
        int currentC = startC;
        int currentDir = startDir;
        int cellsVisited = 0;

        // Track visited states to detect loops
        boolean[][][] visitedStates = new boolean[rows][cols][4];

        while (true) {
            // Check if light left the grid
            if (currentR < 0 || currentR >= rows || currentC < 0 || currentC >= cols) {
                return 0;
            }

            // Check if we returned to start with same direction (complete loop)
            if (currentR == startR && currentC == startC && cellsVisited > 0) {
                if (visitedStates[currentR][currentC][currentDir]) {
                    return cellsVisited;
                }
            }

            // Check for infinite cycles
            if (visitedStates[currentR][currentC][currentDir]) {
                return 0;
            }

            visitedStates[currentR][currentC][currentDir] = true;
            cellsVisited++;

            char currentCell = grid[currentR][currentC];

            if (currentCell == '0') {
                // Empty space - continue straight
                currentR += verticalMoves[currentDir];
                currentC += horizontalMoves[currentDir];
            } else if (currentCell == '/' || currentCell == '\\') {
                // Mirror reflection - change direction
                int mirrorType = (currentCell == '/') ? 0 : 1;
                currentDir = directionChanges[currentDir][mirrorType];

                // Move to next cell
                currentR += verticalMoves[currentDir];
                currentC += horizontalMoves[currentDir];
            } else {
                // Invalid cell type
                return 0;
            }
        }
    }
}