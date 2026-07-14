class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int left = 0 , right = n - 1;
        int top = 0 , bottom =  n - 1;

        int nums = 1;

      while(top <= bottom && left <= right) {

        for(int i = left; i <= right;i++) {
            matrix[top][i] = nums++;
        }
        top++;

        for(int j = top; j <= bottom ; j++) {
            matrix[j][right]  = nums++;
        }
        right--;

        if(top <= bottom) {
            for(int i = right; i >= left; i--) {
                matrix[bottom][i] = nums++;
            }
        bottom--;
        
        }
        if(left <= right) {
            for(int j = bottom; j >= top; j--) {
                matrix[j][left] = nums++;
            }
            left++;
        }
        }
      

        return matrix;
        
    }
}