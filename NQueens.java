public class NQueens {
    private int[] x;
    private int nSolutions;

    public NQueens(int nQueens) {
        x = new int[nQueens];
        nSolutions = 0;
    }

    private void printArray(int[] a) {
        System.out.print(String.format("%d. [ ", nSolutions));
        for (int e : a)
            System.out.print((e+1) + " ");
        System.out.println("]");
    }

    // function P (bounding function)
    private boolean canPlaceQueen(int targetRow, int targetCol) {
        for (int i=0; i<targetRow; i++) {
            if (x[i] == targetCol || Math.abs(x[i]-targetCol) == Math.abs(i-targetRow)) // two queens in the same column or in the same diagonal
                return false;
        }
        return true;
    }

    public void printSolutions() {
        printSolutions(0);
    }

    private void printSolutions(int currentQueen) {
        for (int col=0; col<x.length; col++) { // for each column (each position in x)
            if (canPlaceQueen(currentQueen, col)) { // if the current queen can be placed in that column (bounding function)
                x[currentQueen] = col; // assign that column to the queen
                if (currentQueen == x.length-1) { // if all queens have been successfully assigned to a column
                    nSolutions++;
                    printArray(x); // a solution has been found, so print it
                }
                else // a solution has not yet been found, but we are still complying with the bounding function
                    printSolutions(currentQueen+1); // so continue to the next queen
            }
            // if queen cannot be placed in that column, check the next column
        }   
    }
}