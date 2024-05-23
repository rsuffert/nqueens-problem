import java.util.Arrays;

/**
 * Implements a solution to the n-queens problem using backtracking.
 */
public class NQueens {
    /**
     * Prints one or all of the solutions of the problem for a certain number of queens.
     * @param nQueens the number of queens.
     * @param stopAfterFirst whether or not all solutions should be calculated and printed.
     */
    public static void printSolutions(int nQueens, boolean stopAfterFirst) {
        int[] x = new int[nQueens];
        calculate(x, 0, stopAfterFirst, 0);
    }

    /**
     * Effectively calculates the solution using backtracking.
     * @param x the array that stores the solutions (its length determines the number of queens).
     * @param currentQueen the current queen being investigated (0...x.length).
     * @param stopAfterFirst whether or not all solutions should be calculated and printed.
     * @param currentSolutions how many solutions have been currently found.
     * @return how many solutions have been found.
     */
    private static int calculate(int[] x, int currentQueen, boolean stopAfterFirst, int currentSolutions) {
        for (int col=0; col<x.length; col++) { // for each column (each position in x)
            if (canPlaceQueen(x, currentQueen, col)) { // if the current queen can be placed in that column (bounding function)
                x[currentQueen] = col; // assign that column to the queen
                if (currentQueen == x.length-1) { // if all queens have been successfully assigned to a column
                    currentSolutions++;
                    System.out.print(currentSolutions + ". ");
                    System.out.println(Arrays.toString(x));
                }
                else {// a solution has not yet been found, but we are still complying with the bounding function
                    currentSolutions = calculate(x, currentQueen+1, stopAfterFirst, currentSolutions); // so continue to the next queen
                    if (stopAfterFirst && currentSolutions > 0) return currentSolutions; // stop searching if a solution has been found and the user requested only one solution
                }
            }
            // if queen cannot be placed in that column, check the next column
        }
        return currentSolutions;
    }

    /**
     * The bounding (P) function. Tells whether or not a queen can be placed at a specific row and column on the board.
     * @param x the array that stores the solutions (its length determines the number of queens).
     * @param targetRow the row where the queen is intended to be placed.
     * @param targetCol the column where the queen is intended to be placed.
     * @return {@code true} if the queen can be placed at the given cell of the board; {@code false} if not.
     */
    private static boolean canPlaceQueen(int[] x, int targetRow, int targetCol) {
        for (int i=0; i<targetRow; i++) {
            if (x[i] == targetCol || Math.abs(x[i]-targetCol) == Math.abs(i-targetRow)) // two queens in the same column or in the same diagonal
                return false;
        }
        return true;
    }
}