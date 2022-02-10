package com.majorxp;

public class SudokuSolver {

    public static int [][] grid = {

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

        printUnsolvedGrid();

    }

    private static void printUnsolvedGrid() {

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
}
