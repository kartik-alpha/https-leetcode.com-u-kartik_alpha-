class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int s = 0;
        int e = n - 1;

        while( s <  m  &&  e >= 0  /*s < e*/) {    // check every column and row;;
            if(matrix[s][e] == target) {
                return true;
            } else if (matrix[s][e] > target) {

                e--;
            } else {
                 s++;
            }
        }
         return false;
    }
}