class Solution {

    static boolean isSafePlace(int n , int rowIndex , int colIndex , char[][] boards ) {

        int row = rowIndex;
        int col = colIndex;

        while(col >= 0) {

           if (boards[row][col] == 'Q' )  {

            return false;
           }
           col--;
        }


         //left uperside
        row = rowIndex;
        col = colIndex;

        while(col >= 0 && row >= 0) {
            if(boards[row][col] == 'Q') {

                return false;
            }

            row = row - 1;
            col = col - 1;
        }

        row = rowIndex;
        col = colIndex;

        while(row < n && col >= 0) {

               if(boards[row][col] == 'Q') {

                return false;
            }

            row = row + 1;
            col = col - 1;

        }

        return true;


    }

    static void solve(int n , char[][] boards , List<List<String>> ans , int colIndex) {

        //base case 
        if(colIndex >= n) {

            List<String> temp = new ArrayList<>();

            for(int i = 0; i < n;i++) {
                temp.add(new String(boards[i]));
            }

            ans.add(temp);
            return;
        }

        for(int rowIndex = 0; rowIndex < n; rowIndex++) {
            if(isSafePlace( n ,rowIndex , colIndex , boards)) {

                boards[rowIndex][colIndex] = 'Q';

                solve(n , boards , ans , colIndex + 1); 

                //backtracking 
                boards[rowIndex][colIndex] = '.';

            }
        }


    }
    public List<List<String>> solveNQueens(int n) {

        char[][]  boards = new char[n][n];

        for(int i = 0; i < n;i++) {
            Arrays.fill(boards[i] , '.');
        }

        List<List<String>> ans = new  ArrayList<>();
        int colIndex = 0;

        solve( n , boards , ans , colIndex);
        return ans;

    }
}