class Solution {
    public boolean placeWordInCrossword(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m;i++) {
            int j = 0;
            while( j < n) {
                while(j < n && board[i][j] == '#') j++;
                int start = j;

                while(j < n && board[i][j] != '#') j++;

                if( j - start == word.length()) {
                    if(checkRow(board , word , true , start , i) ||
                       checkRow(board , word , false , start, i)) {
                        return true;
                       }
                }
            }
        }

        
        for(int j = 0; j < n;j++) {
            int i = 0;
            while( i < m) {
                while(i < m && board[i][j] == '#') i++;
                int start = i;

                while(i < m && board[i][j] != '#') i++;

                if( i - start == word.length()) {
                    if(checkcol(board ,  word , true , start , j ) ||
                       checkcol(board ,  word , false , start , j )) {
                        return true;
                       }
                }
            }
        }

        return false;

    }
        private boolean checkRow(char[][] board, String word , boolean forward , int start , int row ) {

            int len = word.length();

            for( int k = 0 ; k < len; k++ ) {
                char ch = board[row][start + k];
                char w = forward ? word.charAt(k) : word.charAt(len - 1 - k);

                if(ch != ' ' && ch != w) {
                    return false;
                }
            }

            return true;
        }

        
        private boolean checkcol(char[][] board, String word , boolean forward , int start , int col ) {

            int len = word.length();

            for( int k = 0 ; k < len; k++ ) {
                char ch = board[start + k][col];
                char w = forward ? word.charAt(k) : word.charAt(len - 1 - k);

                if(ch != ' ' && ch != w) {
                    return false;
                }
            }

            return true;

        
    }
}