public class SudokuSolver {

    public static final int GRID_SIZE = 9;

    public static final int [][] grid = {

            {3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}
    };

    public static void main(String[] args) {

        System.out.println("Unsolved Puzzle");
        printGrid(grid);

        //When the solve puzzle method returns true (meaning the puzzle has been solved)
        if(solvePuzzle(grid)){
            System.out.println("Puzzle successfully solved!");
        }
        //When the solve puzzle method returns false (meaning the puzzle could not be solved)
        else {
            System.out.println("Solving the puzzle was unsuccessful.");
        }

    }

    private static void printGrid(int grid[][]) {

        System.out.println("--------------------------");

        //Looping through each row of the grid
        for(int row = 0; row <= grid.length - 1; row++){

            //Looping through each column of the grid
            for(int column = 0; column <= grid.length - 1; column++) {

                if(column % 3 == 0) {
                    System.out.print("| ");
                }

                System.out.print(grid[row][column] + " ");

            }

            System.out.print("| ");
            System.out.println();

            if((row + 1) % 3 == 0){
                System.out.println("--------------------------");
            }
        }


    }

    private static boolean solvePuzzle(int[][] grid){
        //Loops through the entire 9x9 grid
        for(int row = 0; row < GRID_SIZE; row++){
            for(int column = 0; column < GRID_SIZE; column++){
                if(grid[row][column] == 0){
                    //If there is an empty space values from 1-9 will be tested
                    for(int numToTry = 1; numToTry <= GRID_SIZE; numToTry++){
                        //If the number is valid in that spot it will be added to the array
                        if(isPlacementValid(grid, numToTry, row, column)){
                            grid[row][column] = numToTry;

                            //Recursion of Solve Puzzle method until the full puzzle is solved
                            if(solvePuzzle(grid)){
                                return true;
                            }
                            //If the value from this stage of recursion is not valid, the previous value is replaced with
                            //an empty space (0) and other values are tested
                            else {grid[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }

        System.out.println("\n\n Solved Puzzle");
        printGrid(grid);
        return true;
    }

    //Calls all 3 methods that check if a number is in a row, column or inner grid
    private static boolean isPlacementValid(int[][] grid, int num, int row, int column){
        return !isNumInRow(grid, num, row) &&
                !isNumInColumn(grid, num, column) &&
                !isNumInBox(grid, num, row, column);
    }

    //This method loops through all the rows at a specific column to check if the number is present in the entire column
    private static boolean isNumInRow(int[][] grid, int num, int row){
        for (int column = 0; column < GRID_SIZE; column++){
            if(grid[row][column] == num){
                return true;
            }
        }
        return false;
    }

    //This method loops through all the rows at a specific column to check if the number is present in the entire column
    private static boolean isNumInColumn(int[][] grid, int num, int column){
        for (int row = 0; row < GRID_SIZE; row++){
            if(grid[row][column] == num){
                return true;
            }
        }
        return false;
    }

    private static boolean isNumInBox(int[][] grid, int num, int row, int column){
        //Finds the top left corner of an inner box
       int localBoxRow = row - (row % 3);
       int localBoxColumn = column - (column % 3);

       //Loops through each row and column of an inner grid to determine if the number is present.
       for(int i = localBoxRow; i < localBoxRow + 3; i++){
           for(int j = localBoxColumn; j < localBoxColumn + 3; j++){
               if(grid[i][j] == num){
                   return true;
               }
           }
       }
       return false;
    }



}