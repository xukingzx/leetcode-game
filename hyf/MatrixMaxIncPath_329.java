package waitsolve;

public class MatrixMaxIncPath_329 {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        /*for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(i - 1 >= 0){
                    dp[i - 1][j] = Math.max((matrix[i][j] < matrix[i - 1][j])?dp[i][j] + 1:0,dp[i - 1][j]);
                }
                if(j - 1 >= 0){
                    dp[i][j - 1] = Math.max((matrix[i][j] < matrix[i][j - 1])?dp[i][j] + 1:0,dp[i][j - 1]);
                }
                if(i + 1 < row){
                    dp[i + 1][j] = Math.max((matrix[i][j] < matrix[i + 1][j])?dp[i][j] + 1:0,dp[i + 1][j]);
                }
                if(j + 1 < col){
                    dp[i][j + 1] = Math.max((matrix[i][j] < matrix[i][j + 1])?dp[i][j] + 1:0,dp[i][j + 1]);
                }
            }
        }
        */
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                maxValue = Math.max(dp[i][j],maxValue);
            }
        }
        return maxValue + 1;
    }
}
