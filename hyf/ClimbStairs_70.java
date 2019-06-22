package waitSolve;

public class ClimbStairs_70 {
    public int climbStairs_v1(int n) {
        return f1(n,0);
    }
    private int f1(int n,int count){
        if(n == 0) return count;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int temp = count;
        temp++;
        return f1(n - 1,temp) + f1(n-2,temp);
    }

    public int climbStairs_v2(int n){
        if(n == 1) return 1;
        int[] memo = new int[n + 1];
        memo[1] = 1;
        memo[2] = 2;
        return f2(n,memo);
    }

    private int f2(int n,int[] memo){
        if(n == 0 || memo[n] != 0) return memo[n];
        return memo[n] = f2( n - 1,memo) + f2(n - 2,memo);
    }

    public int climbStairs_v3(int n){
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3;i <= n;i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
