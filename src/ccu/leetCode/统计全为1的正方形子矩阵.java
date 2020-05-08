package ccu.leetCode;

public class 统计全为1的正方形子矩阵 {


    /**
     * 最大正方形 题解是类似
     * 我们用 f[i][j] 表示以 (i, j) 为右下角的正方形的最大边长，
     * 那么除此定义之外，f[i][j] = x 也表示以 (i, j)
     * 为右下角的正方形的数目为 x（即边长为 1, 2, ..., x 的正方形各一个）。
     * @param matrix
     * @return
     */
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int cnt  = 0;
        int[][] dp  =  new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i ==0 || j==0) {
                    dp[i][j] = matrix[i][j];
                }else if(matrix[i][j] ==0){
                    dp[i][j] =0;
                }else{
                    dp[i][j] = Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]))+1;
                }
                cnt += dp[i][j];
            }
        }
        return cnt;

    }
}
