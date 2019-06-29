package waitsolve;

public class Rob_198 {
    public int rob(int[] nums) {
        if(nums.length  == 0) return 0;
        if(nums.length < 2) return nums[nums.length - 1];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for(int i = 2;i < nums.length;i++){
            for(int j = i - 2;j >= 0;j--){
                dp[i] = Math.max(dp[i],nums[i] + dp[j]);
            }
        }
        int result = Integer.MIN_VALUE;
        for(int i = 0;i < dp.length;i++){
            result = Math.max(result,dp[i]);
        }
        return result;
    }
}
