import java.util.*;
import java.io.*;
/*
 * Coder : Karunagaran V
 * Purpose: Pikachoo program tcs codevita
 */
public class Pikachu_code_Karan {

    // So this is like direction right, left, up and down for creating a thing
    static final int[] directionCreationForRow = {-1, 0, 1, 0};
    static final int[] directionCreationForColumn = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader brInputForGettingData = new BufferedReader(new InputStreamReader(System.in));

        // here i will get input from console like dimen
        String sizeLine = brInputForGettingData.readLine();
        if (sizeLine == null) return; // recheck
        String[] sizeInput = sizeLine.trim().split(" ");
        int numberRowsToGet = Integer.parseInt(sizeInput[0]);
        int numberColToGet = Integer.parseInt(sizeInput[1]);

        char[][] griddChar = new char[numberRowsToGet][numberColToGet];
        for (int i = 0; i < numberRowsToGet; i++) {
            String rowLine = brInputForGettingData.readLine();
            if (rowLine == null || rowLine.length() < numberColToGet) {
                rowLine = String.format("%-" + numberColToGet + "s", rowLine == null ? "" : rowLine).replace(' ', '.');
            }
            griddChar[i] = rowLine.toCharArray();
        }

        // Check the mov
        String instructing = brInputForGettingData.readLine();
        if (instructing == null) instructing = "";
        instructing = instructing.trim();

        // save unique
        Set<String> finalPositions = new HashSet<>();

        for (int i = 0; i < numberRowsToGet; i++) {
            for (int j = 0; j < numberColToGet; j++) {
                if (griddChar[i][j] != '#') {
                    goingInCell(griddChar, i, j, instructing, finalPositions);
                }
            }
        }

        // Output show i think impossible to no value otherwise show some value
        System.out.println(finalPositions.isEmpty() ? "Impossible" : finalPositions.size());
    }

    static void goingInCell(char[][] gridVal, int startR, int startC, String instructing, Set<String> results) {
        for (int direction = 0; direction < 4; direction++) {
            int[] place = checkThePath(gridVal, startR, startC, direction, instructing);
            if (place != null) {
                results.add(place[0] + "," + place[1]);
            }
        }
    }

    static int[] checkThePath(char[][] gridFix, int r, int c, int direct, String moving) {
        int maxRows = gridFix.length;
        int maxCols = gridFix[0].length;

        for (char action : moving.toCharArray()) {
            switch (action) {
                case 'L': // i think this work
                    direct = (direct + 3) % 4;
                    break;

                case 'R':
                    direct = (direct + 1) % 4;
                    break;

                case 'S':
                    int newRow = r + directionCreationForRow[direct];
                    int newCol = c + directionCreationForColumn[direct];

                    if (newRow < 0 || newRow >= maxRows || newCol < 0 || newCol >= maxCols || gridFix[newRow][newCol] == '#') {
                        return null;
                    }

                    r = newRow;
                    c = newCol;
                    break;
            }
        }

        return new int[]{r, c};
    }
}
