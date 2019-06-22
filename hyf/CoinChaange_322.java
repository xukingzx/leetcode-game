package waitSolve;

import java.util.List;

public class CoinChaange_322 {
    public int coinChange_v1(int[] coins, int amount) {
        return f(coins,amount,0);
    }
    int min = Integer.MAX_VALUE;
    private int f(int[] coins, int amount, int count){
        if(amount < 0) return 0;
        if(amount == 0) return 1;
        for(int i = 0;i < coins.length;i++){
            int temp = count;
            temp++;
            if(f(coins,amount-coins[i],temp) == 1){
                if(temp < min){
                    min = temp;
                }
                return min;
            }
        }
        return min;
    }
    public int coinChange_v2(int[] coins, int amount) {
        if(amount == 0) return 0;
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i < coins.length;i++){
            if(amount - coins[i] >= 0){
                int subPro = coinChange_v2(coins,amount - coins[i]);
                if(subPro != -1) ans = Math.min(ans,subPro + 1);
            }
        }
        return ans == Integer.MAX_VALUE?-1:ans;
    }


    public int coinChange_v3(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        for(int i = 0;i < memo.length;i++){
            memo[i] = -2;
        }
        return func(coins,amount,memo);
    }

    private int func(int[] coins,int amount,int[] memo){
        if(amount == 0) return 0;
        if(memo[amount] != -2) return memo[amount];
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i < coins.length;i++){
            if(amount - coins[i] >= 0){
                int subPro = func(coins,amount - coins[i],memo);
                if(subPro != -1) ans = Math.min(ans,subPro + 1);
            }
        }
        memo[amount] = (ans == Integer.MAX_VALUE)?-1:ans;
        return memo[amount];
    }
    public int coinChange_v4(int[] coins, int amount) {
        int [] f = new int[amount + 1];
        f[0] = 0;
        for(int i = 1; i <= amount; i++){
            int cost = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++){
                if(i - coins[j] >= 0){
                    if(f[i-coins[j]] != Integer.MAX_VALUE)
                        cost = Math.min(cost, f[i - coins[j]] + 1);
                }
            }
            f[i] = cost;
        }
        return  f[amount] == Integer.MAX_VALUE? -1 : f[amount];
    }

}
