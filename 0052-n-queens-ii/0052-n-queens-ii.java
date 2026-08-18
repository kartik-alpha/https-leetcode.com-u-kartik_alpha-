class Solution {

    static boolean isSafePlace(int n , int rowIndex , int colIndex , char[][] boards) {


        int row  =  rowIndex;
        int col  =  colIndex;

        while(col >= 0) {
            if(boards[row][col] == 'Q') {
                return false;
            }
            col--;
        }

        //left upside 
        row  =  rowIndex;
        col  =  colIndex;

          while(col >= 0 && row >= 0) {
            if(boards[row][col] =='Q') {
                return false;
            }

            col = col - 1;
            row = row - 1;
        }


        //down left side
         row  =  rowIndex;
        col  =  colIndex;

          while(col >= 0 && row < n) {
            if(boards[row][col] == 'Q') {
                return false;
            }

            col = col - 1;
            row = row + 1;
        }
        return true;
    }

    static int solve(int n , int colIndex ,  char[][] boards) {

        if(colIndex  >= n) {
            return 1;
        }

        int count = 0;

        for(int rowIndex = 0;rowIndex < n;rowIndex++) {
            if(isSafePlace(n, rowIndex , colIndex , boards )) {

                  boards[rowIndex][colIndex] = 'Q';

                count += solve(n, colIndex + 1  , boards);

                boards[rowIndex][colIndex] = '.';

            }
        }

        return count;
    }
    public int totalNQueens(int n) {

        char[][] boards = new char[n][n];

        int colIndex = 0;

        for(int i = 0; i < n;i++) {
            Arrays.fill(boards[i] , '.');

        }

       
       int ans =  solve( n , colIndex  , boards);

    return ans;

    }
}