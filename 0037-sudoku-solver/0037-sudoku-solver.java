class Solution {
    static boolean findEmptyCell(char[][] board , int[] emptyCell ) {
        for(int i = 0;i<9;i++) {
            for(int j = 0;j<9;j++) {

                if(board[i][j] == '.') {

                    emptyCell[0]  = i;

                    emptyCell[1]  =  j;

                    return true;
                }
            }
        }

        return false;

    }

    static boolean  isSafetoPlace(char[][] board , char charValue , int rowIndex , int colIndex ) {

// check sbhi col mein 
        for(int col = 0; col <9;col++){
            if(board[rowIndex][col] == charValue ){
                return false;
            }
        }

        //check sbhi row mein 
        for(int row = 0; row < 9;row++) {
           if(board[row][colIndex] == charValue ){
                return false;
            }
        }


        //3*3 matrix row or col mein check kaise krte hai 
        //loop continue chlta i = 3 tk or j = 3 travsel krte pure loop ko 

    // row%3 - row same 

    int StartingRow = rowIndex - rowIndex%3;
    int StartingCol = colIndex - colIndex%3;

    for(int i = 0;i<3;i++) {
        for(int j = 0;j<3;j++) {

            int actualRow  = StartingRow + i;
            int actualCol  = StartingCol + j;

            if(board[actualRow][actualCol] == charValue) {
                return false;
            }
        }
    }



       return true; 


    }


    static boolean solveSudokuHelper(char[][] board) {

        int[] emptyCell = new int[2];
        if(!findEmptyCell(board , emptyCell)) {

            return true;
        }

        int rowIndex  = emptyCell[0];
        int colIndex  = emptyCell[1];


        for(int value = 1; value <= 9;value++) {
            char charValue  =  (char)(value + '0');

            if(isSafetoPlace(board , charValue , rowIndex , colIndex)) {

                board[rowIndex][colIndex]  = charValue;

                if(solveSudokuHelper(board) == true) {
                    return true;
                }

                // curent value ko  undo krna hai 
                board[rowIndex][colIndex] = '.';
            }
        }

        //not able to solve prblm 

        return false;

    }
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
        
    }
}