package waitsolve;

public class NumSquares_279 {
    public int numSquares(int n) {
        /*int count = (int)Math.sqrt(n);
        int[] squreNums = new int[count + 1];
        for(int i = 0; i < count + 1;i++){
            squreNums[i] = i * i;
        }
        int result = Integer.MAX_VALUE;
        for(int startNumIndex = count;startNumIndex > 0; startNumIndex--){
            int tempN = n,tempResult = 0;
            for(int currentNumIndex = startNumIndex; currentNumIndex > 0;){
                if(tempN - squreNums[currentNumIndex] >= squreNums[currentNumIndex]){
                    tempN -= squreNums[currentNumIndex];
                    tempResult++;
                }
                else if(tempN  >= squreNums[currentNumIndex]){
                    tempN -= squreNums[currentNumIndex];
                    tempResult++;
                    currentNumIndex--;
                }
                else {
                    currentNumIndex--;
                }
            }
            result = Math.min(result,tempResult);
        }
        return result;

         */

        //利用动态规划 定义长度为n+1的数组 对应索引所对应的数装最少的步数
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = i; //先假设到这一步的最大的步数为每次+1
            for (int j = 1; i - j * j >= 0; j++) { //i-j*j>=0 找到最大的j j*j就是i里面最大的完全平方数
                //dp[i-j*j]+1 表示d[i-j*j]的步数＋1 1即j*j这个完全平方数只需要一步
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
