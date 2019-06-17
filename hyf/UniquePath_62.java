package waitSolve;

import java.util.Arrays;

public class UniquePath_62 {
    int count = 0;
    public int uniquePaths_v1(int m, int n) {
        if(m == 1 || n == 1){
            count++;
            return count;
        }
        if(m > 1) uniquePaths_v1(m - 1,n);
        if(n > 1) uniquePaths_v1(m,n-1);
        return count;
    }

    int[][] memo = new int[101][101];
    public int uniquePaths_v2(int m, int n) {
        if(m == 1 || n == 1){
            return 1;
        }
        if(memo[m][n] > 0) return memo[m][n];
        memo[m-1][n] = uniquePaths_v2(m-1,n);
        memo[m][n-1] = uniquePaths_v2(m,n-1);
        memo[m][n] = memo[m-1][n]+memo[m][n-1];
        return memo[m][n];
    }

    public int uniquePaths_v3(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePaths_v4(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] += cur[j-1] ;
            }
        }
        return cur[n-1];

    }

}
