package waitSolve;

public class UniquePath2_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] m = new int[row][col];
        for(int i = 0;i < row;i++) {
            if(obstacleGrid[i][0] != 1)m[i][0] = 1;
            else break;
        }
        for(int i = 0;i < col;i++) {
            if(obstacleGrid[0][i] != 1)m[0][i] = 1;
            else break;
        }
        for(int i = 1;i < row;i++){
            for(int j = 1;j < col;j++){
                if(obstacleGrid[i][j] != 1){
                     //m[i][j] = m[i-1][j] == 1?0:m[i-1][j] + m[i][j-1] == 1?0:m[i][j-1];
                    int a = obstacleGrid[i-1][j] == 1 ? 0 : m[i-1][j];
                    int b = obstacleGrid[i][j-1] == 1 ? 0 : m[i][j-1];
                    m[i][j] = a+b;
                }
            }
        }
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                System.out.print(m[i][j]+" ");
            }
            System.out.print("\n");
        }
        return m[row-1][col-1];
    }

    public int uniquePathsWithObstacles_v2(int[][] obstacleGrid) {
        int R = obstacleGrid.length;
        int C = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        obstacleGrid[0][0] = 1;
        for (int i = 1; i < R; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
            //当前行为0，上一行为1
        }
        for (int i = 1; i < C; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[R - 1][C - 1];
    }

}
