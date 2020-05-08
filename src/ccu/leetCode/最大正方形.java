package ccu.leetCode;

public class 最大正方形 {

    /**
     *  DP
     *  dp[i][j] 表示右下角的最大正方形的边
     *  动态转移方法
     *  if i != 0 j != 0
     *  dp[i][j] = min (dp[i-1][j], dp[i][j-1],dp[i-1][j-1])+1
     *  i ==0 || j ==0
     *  dp[i][j] =1;
     *  如果该位置的值是 00，则 dp(i, j) = 0dp(i,j)=0，因为当前位置不可能在由 11 组成的正方形中；
     *
     * 如果该位置的值是 1，则 dp(i, j) 的值由其上方、左方和左上方的三个相邻位置的 dp 值决定。
     * 具体而言，当前位置的元素值等于三个相邻位置的元素中的最小值加 1，状态转移方程如下：
     * dp(i, j)=min(dp(i−1, j), dp(i−1, j−1), dp(i, j−1))+1
     * dp(i,j)=min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))+1
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int n = matrix.length;
        int m = matrix[0].length;
        int max = 0;
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i< n; i++){
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] =='1'){
                    if(i ==0 || j ==0){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                    }
                }

                max = Math.max(max,dp[i][j]);
            }
        }
        return max*max;
    }
}
