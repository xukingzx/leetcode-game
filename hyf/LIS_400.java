package waitSolve;

import java.util.Arrays;
import java.util.Collections;

public class LIS_400 {
    public int lengthOfLIS_v1(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        for(int i = 1;i < nums.length;i++){
            for(int j = 0;j < i;j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
        }
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0;i < nums.length;i++){
            maxValue = Math.max(maxValue,dp[i]);
        }
        return maxValue;
    }
}
