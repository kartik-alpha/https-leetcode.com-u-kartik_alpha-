class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        int[][] prefix = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefix[i + 1][j + 1] = mat[i][j] 
                                     + prefix[i][j + 1] 
                                     + prefix[i + 1][j] 
                                     - prefix[i][j];
            }
        }
        
        // Step 2: Compute the block sum for each cell (i, j)
        int[][] answer = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Determine the clamped boundaries for the submatrix
                int r1 = Math.max(0, i - k);
                int c1 = Math.max(0, j - k);
                int r2 = Math.min(m - 1, i + k);
                int c2 = Math.min(n - 1, j + k);
                
                // Convert to 1-indexed coordinates for the prefix sum array
                int r1_p = r1 + 1, c1_p = c1 + 1;
                int r2_p = r2 + 1, c2_p = c2 + 1;
                
                answer[i][j] = prefix[r2_p][c2_p] 
                             - prefix[r1_p - 1][c2_p] 
                             - prefix[r2_p][c1_p - 1] 
                             + prefix[r1_p - 1][c1_p - 1];
            }
        }
        
        return answer;
    }
}
