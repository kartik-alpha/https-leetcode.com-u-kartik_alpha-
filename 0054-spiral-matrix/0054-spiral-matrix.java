class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> res = new ArrayList<>();

        int left = 0, right = n - 1;
        int top = 0, bottom = m - 1;

      while(left <= right && top <= bottom) {

        for(int col = left; col <= right;col++) {
            res.add(matrix[top][col]);
        } 
        top++;

        for(int row = top; row <= bottom; row++) {
            res.add(matrix[row][right]);
        }
        right--;

        if(top <= bottom) {
            for(int col = right; col >= left;col--){
                res.add(matrix[bottom][col]);
            }
            bottom--;
        }
        if(left <= right) {
            for(int row = bottom;row >= top; row--) {
                res.add(matrix[row][left]);
            }
            left++;
        }
       }
      return res;
    }
}