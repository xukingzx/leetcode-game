package waitSolve;

public class MinPathSum_64 {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        // dp[i][j] = dp[i][j] + min(dp[i+1][j],dp[i][j+1])
        for(int i = row - 1;i >= 0;i--){
            for(int j = col - 1;j >= 0;j--){
                if(i + 1 >= row && j + 1 >= col) continue;
                grid[i][j] = grid[i][j] + Math.min(i + 1 >= row ? Integer.MAX_VALUE:grid[i+1][j],
                        j + 1 >= col ? Integer.MAX_VALUE:grid[i][j+1]);
            }
        }
        return grid[0][0];
    }

    public int minPathSum_v2(int[][] grid) {
        return helper(grid,0,0);
    }
    private int helper(int[][] grid,int i,int j){
        if(i == grid.length - 1 && j == grid[0].length - 1) return grid[i][j];
        if(i == grid.length || j == grid[0].length) return Integer.MAX_VALUE;
        grid[i][j] += Math.min(helper(grid,i+1,j) , helper(grid,i,j+1) );
        return grid[i][j];
    }
}
